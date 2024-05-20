package alexdev.securityfood.app;

import alexdev.securityfood.app.port.input.CreateFoodInputPort;
import alexdev.securityfood.app.port.output.FoodVerifyOutputPort;
import alexdev.securityfood.app.port.output.PersistFoodOutputPort;
import alexdev.securityfood.app.port.output.security.SecurityOutputPort;
import alexdev.securityfood.app.entity.Food;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateFoodUseCase implements CreateFoodInputPort {

    private final PersistFoodOutputPort persistFooOutputPort;
    private final FoodVerifyOutputPort foodVerifyOutputPort;
    private final SecurityOutputPort securityOutputPort;

    @Override
    public void create(Food foo) {

        securityOutputPort.assertThatUserIsAdmin();

        if(!foodVerifyOutputPort.existsByName(foo.name())) {
            throw new NonUniqueNameException("name " + foo.name() + "already exist");
        }

        persistFooOutputPort.persist(foo);

    }
}
