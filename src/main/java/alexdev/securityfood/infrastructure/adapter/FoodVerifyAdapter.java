package alexdev.securityfood.infrastructure.adapter;

import alexdev.securityfood.app.port.output.FoodVerifyOutputPort;
import alexdev.securityfood.infrastructure.adapter.db.jpa.FoodDbRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class FoodVerifyAdapter implements FoodVerifyOutputPort {


    private final FoodDbRepository foodDbRepository;

    @Override
    public boolean existsById(UUID foodId) {
        return foodDbRepository.existsById(foodId);
    }

    @Override
    public boolean existsByName(String name) {
        return foodDbRepository.existsByName(name);
    }
}
