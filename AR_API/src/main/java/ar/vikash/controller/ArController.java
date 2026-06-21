package ar.vikash.controller;

import ar.vikash.dto.CitizenApps;
import ar.vikash.service.ArService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArController {

    private ArService arService;

    public ArController(ArService arService) {
        this.arService = arService;
    }

    @PostMapping("/app")
    public ResponseEntity<String> createCitizenApp(@RequestBody CitizenApps app) {
        Integer application = arService.createApplication(app);
        if (application > 0) {
            return new ResponseEntity<>("Application is created with app id: " + application, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid SSN", HttpStatus.BAD_REQUEST);
        }
    }
}
