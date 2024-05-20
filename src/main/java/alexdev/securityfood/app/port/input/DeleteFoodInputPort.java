package alexdev.securityfood.app.port.input;

import java.util.UUID;

public interface DeleteFoodInputPort {
    void delete(UUID fooId);
}
