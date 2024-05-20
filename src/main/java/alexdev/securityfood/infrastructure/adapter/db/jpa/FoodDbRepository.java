package alexdev.securityfood.infrastructure.adapter.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodDbRepository extends JpaRepository<FoodDb, UUID> {
    boolean existsByName(String name);
}
