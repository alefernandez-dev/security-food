package alexdev.securityfood.infrastructure.config;

import alexdev.securityfood.app.CreateFoodUseCase;
import alexdev.securityfood.app.DeleteFoodUseCase;
import alexdev.securityfood.app.ListAllFoodsUseCase;
import alexdev.securityfood.app.port.input.CreateFoodInputPort;
import alexdev.securityfood.app.port.input.DeleteFoodInputPort;
import alexdev.securityfood.app.port.input.ListAllFoodsInputPort;
import alexdev.securityfood.app.port.output.DeleteFoodOutputPort;
import alexdev.securityfood.app.port.output.FoodVerifyOutputPort;
import alexdev.securityfood.app.port.output.ListAllFoodsOutputPort;
import alexdev.securityfood.app.port.output.PersistFoodOutputPort;
import alexdev.securityfood.app.port.output.security.SecurityOutputPort;
import alexdev.securityfood.infrastructure.adapter.*;
import alexdev.securityfood.infrastructure.adapter.db.jpa.FoodDbRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public PersistFoodOutputPort persistFoodOutputPort(FoodDbRepository foodDbRepository) {
        return new PersistFoodAdapter(foodDbRepository);
    }

    @Bean
    public ListAllFoodsOutputPort listAllFoodsOutputPort(FoodDbRepository foodDbRepository){
        return new ListAllFoodsAdapter(foodDbRepository);
    }

    @Bean
    public DeleteFoodOutputPort deleteFoodOutputPort(FoodDbRepository foodDbRepository) {
        return new DeleteFoodAdapter(foodDbRepository);
    }

    @Bean
    public FoodVerifyOutputPort foodVerifyOutputPort(FoodDbRepository foodDbRepository) {
        return new FoodVerifyAdapter(foodDbRepository);
    }

    @Bean
    public SecurityOutputPort securityOutputPort() {
        return new SecurityAdapter();
    }

    @Bean
    public CreateFoodInputPort createFoodInputPort(
            PersistFoodOutputPort persistFoodOutputPort,
            FoodVerifyOutputPort foodVerifyOutputPort,
            SecurityOutputPort securityOutputPort
            ){
        return new CreateFoodUseCase(persistFoodOutputPort, foodVerifyOutputPort, securityOutputPort);
    }

    @Bean
    public DeleteFoodInputPort deleteFoodInputPort(
            DeleteFoodOutputPort deleteFoodOutputPort,
            FoodVerifyOutputPort foodVerifyOutputPort,
            SecurityOutputPort securityOutputPort
            ) {
        return new DeleteFoodUseCase(deleteFoodOutputPort, foodVerifyOutputPort, securityOutputPort);
    }

    @Bean
    public ListAllFoodsInputPort listAllFoodsInputPort(
            ListAllFoodsOutputPort listAllFoodsOutputPort,
            SecurityOutputPort securityOutputPort
    ) {
        return new ListAllFoodsUseCase(listAllFoodsOutputPort, securityOutputPort);
    }

}
