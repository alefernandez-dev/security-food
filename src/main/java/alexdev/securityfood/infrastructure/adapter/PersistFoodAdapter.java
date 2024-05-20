package alexdev.securityfood.infrastructure.adapter;

import alexdev.securityfood.app.port.output.PersistFoodOutputPort;
import alexdev.securityfood.app.entity.Food;
import alexdev.securityfood.infrastructure.adapter.db.jpa.FoodDb;
import alexdev.securityfood.infrastructure.adapter.db.jpa.FoodDbRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersistFoodAdapter implements PersistFoodOutputPort {

    private final FoodDbRepository foodDbRepository;

    @Override
    public void persist(Food foo) {
        foodDbRepository.save(new FoodDb(foo.fooId(), foo.name()));
    }
}
