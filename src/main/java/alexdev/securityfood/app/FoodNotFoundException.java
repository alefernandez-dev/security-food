package alexdev.securityfood.app;

public class FoodNotFoundException extends GenericFoodAppException {
    public FoodNotFoundException(String message) {
        super(message);
    }

    public FoodNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
