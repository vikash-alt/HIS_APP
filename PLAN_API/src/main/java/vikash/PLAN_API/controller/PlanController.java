package vikash.PLAN_API.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vikash.PLAN_API.binding.Plan;
import vikash.PLAN_API.service.PlanService;

@RestController
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping("newPlan")
    private ResponseEntity<String> createPlan(@RequestBody Plan plan) {
        Plan newPlan = planService.createNewPlan(plan);
        return new ResponseEntity<>("New plan " + newPlan.getPlanName() + " is created with plan ID: " + newPlan.getPlanId(), HttpStatus.OK);
    }
}
