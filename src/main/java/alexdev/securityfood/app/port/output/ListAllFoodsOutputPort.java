package alexdev.securityfood.app.port.output;

import alexdev.securityfood.app.entity.Food;

import java.util.List;

public interface ListAllFoodsOutputPort {
    List<Food> listAll();
}
