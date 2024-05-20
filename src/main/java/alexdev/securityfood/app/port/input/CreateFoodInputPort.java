package alexdev.securityfood.app.port.input;

import alexdev.securityfood.app.entity.Food;

public interface CreateFoodInputPort {
    void create(Food foo);
}
