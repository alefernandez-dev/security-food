package alexdev.securityfood.app;

public class GenericFoodAppException extends RuntimeException {
    public GenericFoodAppException(String message) {
        super(message);
    }

    public GenericFoodAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
