package alexdev.securityfood.app.port.input;

import alexdev.securityfood.app.entity.Food;

import java.util.List;

public interface ListAllFoodsInputPort {
    List<Food> listAll();
}
