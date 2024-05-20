package alexdev.securityfood.app.port.output;

import alexdev.securityfood.app.entity.Food;

public interface PersistFoodOutputPort {
    void persist(Food foo);
}
