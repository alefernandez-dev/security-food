package alexdev.securityfood.infrastructure.adapter;

import alexdev.securityfood.app.port.output.ListAllFoodsOutputPort;
import alexdev.securityfood.app.entity.Food;
import alexdev.securityfood.infrastructure.adapter.db.jpa.FoodDbRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListAllFoodsAdapter implements ListAllFoodsOutputPort {

    private final FoodDbRepository foodDbRepository;

    @Override
    public List<Food> listAll() {
        return foodDbRepository
                .findAll()
                .stream()
                .map(f -> new Food(f.getId(), f.getName()))
                .toList();
    }
}
