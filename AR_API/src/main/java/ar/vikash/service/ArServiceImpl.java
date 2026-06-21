package ar.vikash.service;

import ar.vikash.dto.CitizenApps;
import ar.vikash.entity.CitizenAppsEntity;
import ar.vikash.repository.CitizenAppsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ArServiceImpl implements ArService {

    private CitizenAppsRepository appRepo;

    public ArServiceImpl(CitizenAppsRepository repo) {
        this.appRepo = repo;
    }

    @Override
    public Integer createApplication(CitizenApps app) {

        String endpointUrl = "https://ssa-api-qyyg.onrender.com/ssn/{ssn}";

        /* // Deprecated
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity(endpointUrl, String.class, app.getSsn());
        String stateName = response.getBody();
        */

        WebClient webClient = WebClient.create();

        String stateName = webClient.get() // it represents a GET Request
                .uri(endpointUrl, app.getSsn()) // Represents URL to request to be sent
                .retrieve() // to retrieve response
                .bodyToMono(String.class) // to specify response type
                .block(); // to make synchronus call

        if ("New Jersey".equalsIgnoreCase(stateName)) {
            CitizenAppsEntity entity = new CitizenAppsEntity();
            BeanUtils.copyProperties(app, entity);
            entity.setStateName(stateName);
            CitizenAppsEntity savedApp = appRepo.save(entity);
            return savedApp.getAppId();
        }

        return 0;
    }
}
