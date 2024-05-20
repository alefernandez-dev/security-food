package alexdev.securityfood.app;

import alexdev.securityfood.app.port.input.ListAllFoodsInputPort;
import alexdev.securityfood.app.port.output.ListAllFoodsOutputPort;
import alexdev.securityfood.app.port.output.security.SecurityOutputPort;
import alexdev.securityfood.app.entity.Food;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListAllFoodsUseCase implements ListAllFoodsInputPort {

    private final ListAllFoodsOutputPort listAllFoodsOutputPort;
    private final SecurityOutputPort verifyRoleOutputPort;

    @Override
    public List<Food> listAll() {

       verifyRoleOutputPort.assertThatUserIsAdmin();

        return listAllFoodsOutputPort.listAll();
    }
}
