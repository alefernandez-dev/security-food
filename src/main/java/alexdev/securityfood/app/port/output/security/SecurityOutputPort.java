package alexdev.securityfood.app.port.output.security;


public interface SecurityOutputPort {
    String FOOD_USER = "FOOD_USER";
    String FOOD_ADMIN = "FOOD_ADMIN";

    boolean hasRole(String role);

    default boolean doesNotHaveRole(String role) {
        return !hasRole(role);
    }

    default void assertThatUserIsUser() {
        if (doesNotHaveRole(FOOD_USER)) {
            throw new InsufficientPrivilegesException("user isn't a USER");
        }
    }

    default void assertThatUserIsAdmin() {
        if (doesNotHaveRole(FOOD_ADMIN)) {
            throw new InsufficientPrivilegesException("user isn't a ADMIN");
        }
    }
}
