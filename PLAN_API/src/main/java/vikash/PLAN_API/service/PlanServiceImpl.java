package vikash.PLAN_API.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import vikash.PLAN_API.binding.Plan;
import vikash.PLAN_API.entity.PlanEntity;
import vikash.PLAN_API.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepo) {
        this.planRepository = planRepo;
    }

    @Override
    public Plan createNewPlan(Plan plan) {
        PlanEntity planEntity = new PlanEntity();
        BeanUtils.copyProperties(plan, planEntity);
        PlanEntity savedPlan = planRepository.save(planEntity);
        return convertToPlanDTO(savedPlan);
    }

    public Plan convertToPlanDTO (PlanEntity planEntity){
        Plan plan = new Plan();
        BeanUtils.copyProperties(planEntity, plan);
        return plan;
    }
}
