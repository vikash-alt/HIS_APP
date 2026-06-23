package vikash.DC_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vikash.DC_API.binding.PlanDTO;
import vikash.DC_API.entity.PlanEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Serializable> {

    @Query("SELECT new vikash.DC_API.binding.PlanDTO(e.planName, e.planId) from PlanEntity e")
    List<PlanDTO> getAllPlanNames();

    @Query(value = """
    SELECT a.plan_name
    FROM plan_master a
    JOIN dc_cases b
        ON a.plan_id = b.plan_id
    WHERE b.case_num = :caseNum
    """,
            nativeQuery = true)
    Optional<String> getPlanName(@Param("caseNum") Long caseNum);
}
