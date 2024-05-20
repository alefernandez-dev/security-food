package alexdev.securityfood.infrastructure.adapter;

import alexdev.securityfood.app.port.output.DeleteFoodOutputPort;
import alexdev.securityfood.infrastructure.adapter.db.jpa.FoodDbRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteFoodAdapter implements DeleteFoodOutputPort {

    private final FoodDbRepository foodDbRepository;

    @Override
    public void delete(UUID fooId) {
        foodDbRepository.deleteById(fooId);
    }
}
