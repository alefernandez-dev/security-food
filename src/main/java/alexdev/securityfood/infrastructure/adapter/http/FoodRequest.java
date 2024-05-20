package alexdev.securityfood.infrastructure.adapter.http;

import java.io.Serializable;

public record FoodRequest(String name) implements Serializable {
}
