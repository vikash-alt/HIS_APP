package vikash.PLAN_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vikash.PLAN_API.entity.PlanCategory;
import java.io.Serializable;

@Repository
public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Serializable> {
}
