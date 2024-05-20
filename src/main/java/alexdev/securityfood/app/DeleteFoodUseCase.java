package alexdev.securityfood.app;

import alexdev.securityfood.app.port.input.DeleteFoodInputPort;
import alexdev.securityfood.app.port.output.DeleteFoodOutputPort;
import alexdev.securityfood.app.port.output.FoodVerifyOutputPort;
import alexdev.securityfood.app.port.output.security.SecurityOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteFoodUseCase implements DeleteFoodInputPort {

    private final DeleteFoodOutputPort deleteFooOutputPort;
    private final FoodVerifyOutputPort foodVerifyOutputPort;
    private final SecurityOutputPort securityOutputPort;

    @Override
    public void delete(UUID fooId) {

        securityOutputPort.assertThatUserIsAdmin();

        if(!foodVerifyOutputPort.existsById(fooId)) {
            throw new FoodNotFoundException("foo with id: " + fooId + " doesn't exist");
        }

        deleteFooOutputPort.delete(fooId);

    }
}
