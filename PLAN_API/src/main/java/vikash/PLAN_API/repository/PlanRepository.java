package vikash.PLAN_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vikash.PLAN_API.entity.PlanEntity;
import java.io.Serializable;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Serializable> {
}
