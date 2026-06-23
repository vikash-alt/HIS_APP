package vikash.DC_API.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vikash.DC_API.binding.PlanSelection;
import vikash.DC_API.service.DcService;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanSelectionController {

    private final DcService dcService;

    @PostMapping("/selectPlan")
    public ResponseEntity<String> selectThePlan (@RequestBody PlanSelection planSelection) {

        Long caseNum = dcService.savePlanSelection(planSelection);
        return ResponseEntity.ok("Plan selection is saved on case number: " + caseNum);
    }
}
