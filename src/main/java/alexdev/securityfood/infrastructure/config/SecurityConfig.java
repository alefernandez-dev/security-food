package alexdev.securityfood.infrastructure.config;


import alexdev.securityfood.infrastructure.adapter.SecurityAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService inMemoryUserDetailService() {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        inMemoryUserDetailsManager.createUser(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin123"))
                        .authorities(SecurityAdapter.FOOD_ADMIN, SecurityAdapter.FOOD_USER)
                        .build()
        );

        inMemoryUserDetailsManager.createUser(
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("user123"))
                        .authorities(SecurityAdapter.FOOD_USER)
                        .build()
        );

        return inMemoryUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // no RBAC configuration here: all security is in use cases


        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth
                                //.requestMatchers("/food")
                                //.permitAll()
                                .anyRequest()
                                .authenticated())
                .httpBasic(Customizer.withDefaults());

/*
        httpSecurity
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/food")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .formLogin(login ->
                        login
                                .defaultSuccessUrl("/food", true)
                                .permitAll())
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/food")
                                .permitAll());

 */


        return httpSecurity.build();

    }


}
