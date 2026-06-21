package vikash.DC_API.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import vikash.DC_API.service.DcService;

import java.util.List;

@RestController
public class DcController {

    private final DcService dcService;

    public DcController(DcService dcService) {
        this.dcService = dcService;
    }

    @GetMapping("getPlans")
    public ResponseEntity<List<String>> getPlanNames() {
        List<String> planNames = dcService.getPlanNames();
        return new ResponseEntity<>(planNames, HttpStatus.OK);
    }
}
