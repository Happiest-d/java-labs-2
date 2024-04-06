package org.dstu.bpm;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ExternalTaskSubscription("check-vacancy")
public class CheckVacancyHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Map<String, Object> vars = new LinkedHashMap<>();
        vars.put("vacancyAvailable", true);

        RestTemplate rt = new RestTemplate();
        Object response = rt.getForObject("http://localhost:8082/vacancy/list", Object.class);
        System.out.println(response);

        Logger.getLogger("check-vacancy").log(Level.INFO, "Checked vacancy availability");
        externalTaskService.complete(externalTask, vars);
    }
}
