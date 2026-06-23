package vikash.DC_API.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vikash.DC_API.binding.ChildRequest;
import vikash.DC_API.binding.DcSummary;
import vikash.DC_API.service.DcService;

@RestController
@RequestMapping("/child")
@RequiredArgsConstructor
public class ChildController {

    private final DcService dcService;

    @PostMapping("/saveChildren")
    public ResponseEntity<DcSummary> collectChildrenData(@RequestBody ChildRequest request) {
        Long caseNum = dcService.saveChildrenData(request);
        DcSummary summary = dcService.getSummary(caseNum);
        return ResponseEntity.ok(summary);
    }
}
