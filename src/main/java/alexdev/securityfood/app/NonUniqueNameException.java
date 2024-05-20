package alexdev.securityfood.app;

public class NonUniqueNameException extends GenericFoodAppException {
    public NonUniqueNameException(String message) {
        super(message);
    }

    public NonUniqueNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
