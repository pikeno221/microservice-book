package com.gabriel.hellospringboot.controller;

import com.gabriel.hellospringboot.model.BackendDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@ConfigurationProperties(prefix = "greeting")
@RequestMapping("/api")
public class GreeterRestController {


    private RestTemplate restTemplate = new RestTemplate();
    private String saying;
    private String backendServiceHost;
    private int backendServicePort;

    @GetMapping(value = "/greeting", produces = "text/plain")
    public String greeting() {

        try {
            String backendServiceUrl = String.format("http://%s:%d/api/backend?greeting={greeting}", backendServiceHost, backendServicePort);

            System.out.print("Sending to; " + backendServiceUrl);

            BackendDTO response = restTemplate.getForObject(backendServiceUrl, BackendDTO.class, saying);

            return response.getGreeting() + " at host: " + response.getIp();

        } catch (Exception e) {
            return "error on calling backend Service";
        }
    }


    public void setSaying(String saying) {
        this.saying = saying;
    }

    public void setBackendServiceHost(String backendServiceHost) {
        this.backendServiceHost = backendServiceHost;
    }

    public void setBackendServicePort(int backendServicePort) {
        this.backendServicePort = backendServicePort;
    }
}
