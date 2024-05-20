package alexdev.securityfood.app.port.output;

import java.util.UUID;

public interface DeleteFoodOutputPort {
    void delete(UUID fooId);
}
