package alexdev.securityfood.infrastructure.adapter.http;

import alexdev.securityfood.app.entity.Food;
import alexdev.securityfood.app.port.input.CreateFoodInputPort;
import alexdev.securityfood.app.port.input.DeleteFoodInputPort;
import alexdev.securityfood.app.port.input.ListAllFoodsInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/food")
public class FoodController {

    private final ListAllFoodsInputPort listAllFoodsInputPort;
    private final CreateFoodInputPort createFoodInputPort;
    private final DeleteFoodInputPort deleteFoodInputPort;


    @GetMapping
    public ResponseEntity<?> list() {
        var foods = listAllFoodsInputPort.listAll();

        return ResponseEntity.ok(foods);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody FoodRequest foodRequest) {
        createFoodInputPort.create(new Food(UUID.randomUUID(), foodRequest.name()));
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") UUID foodId) {
        deleteFoodInputPort.delete(foodId);
        return ResponseEntity.ok(null);
    }

}