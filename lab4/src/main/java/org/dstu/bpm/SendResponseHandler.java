package org.dstu.bpm;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@ExternalTaskSubscription("send-response")
public class SendResponseHandler implements ExternalTaskHandler {
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Logger.getLogger("send-response").log(Level.INFO, "Sending vacancy response...");

        RestTemplate rt = new RestTemplate();
        Object response = rt.postForObject("http://localhost:8082/vacancy/send-response", null, Object.class);
        System.out.println(response);

        externalTaskService.complete(externalTask);
    }
}
