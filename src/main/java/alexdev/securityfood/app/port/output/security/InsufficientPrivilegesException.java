package alexdev.securityfood.app.port.output.security;

import alexdev.securityfood.app.GenericFoodAppException;

public class InsufficientPrivilegesException extends GenericFoodAppException {
    public InsufficientPrivilegesException(String message) {
        super(message);
    }

    public InsufficientPrivilegesException(String message, Throwable cause) {
        super(message, cause);
    }
}
