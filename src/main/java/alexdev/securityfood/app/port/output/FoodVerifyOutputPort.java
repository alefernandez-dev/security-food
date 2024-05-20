package alexdev.securityfood.app.port.output;

import java.util.UUID;

public interface FoodVerifyOutputPort {
    boolean existsById(UUID foodId);

    boolean existsByName(String name);
}
