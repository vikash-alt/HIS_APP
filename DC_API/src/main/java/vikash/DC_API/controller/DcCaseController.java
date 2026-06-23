package vikash.DC_API.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vikash.DC_API.binding.CreateCaseResponse;
import vikash.DC_API.binding.PlanDTO;
import vikash.DC_API.service.DcService;

import java.util.List;

@RestController
@RequestMapping("/dcCase")
@RequiredArgsConstructor
public class DcCaseController {

    private final DcService dcService;

    @PostMapping("createCase")
    public ResponseEntity<CreateCaseResponse>createDcCase(@RequestParam("id") Integer appId) {
        Long caseNum = dcService.loadCaseNum(appId);
        if (caseNum > 0) {
            List<PlanDTO> planNames = dcService.getPlanNames();
            CreateCaseResponse caseResponse = new CreateCaseResponse();
            caseResponse.setStatus(true);
            caseResponse.setMessage("Case created successfully");
            caseResponse.setCaseNum(caseNum);
            caseResponse.setAllPlans(planNames);
            return ResponseEntity.ok(caseResponse);
        } else {
            CreateCaseResponse caseResponse = new CreateCaseResponse();
            caseResponse.setStatus(false);
            caseResponse.setMessage("Invalid application ID");
            return ResponseEntity.badRequest().body(caseResponse);
        }
    }
}
