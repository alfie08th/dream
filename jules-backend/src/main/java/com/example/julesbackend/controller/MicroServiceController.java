package com.example.julesbackend.controller;

import com.example.julesbackend.model.Microservice;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

public class MicroServiceController {

    private List<Microservice> microservices = createList();

    @RequestMapping(value = "/service", produces = "application/json")
    public List<Microservice> allMicroServices() {
        return microservices;
    }

    private static List<Microservice> createList() {
        List<Microservice> tempService = new ArrayList<>();
        Microservice microservice = new Microservice();
        microservice.setServiceId(1L);
        microservice.setServiceName("danny was here");
        microservice.setServiceUrl("https://103146.jules.jpmchase.net/job/PRAESTOSF/job/call-service/");
        microservice.setLatestBuild("https://103146.jules.jpmchase.net/job/PRAESTOSF/job/call-service/job/0.0.9MiniIvrFix/lastBuild/");
        microservice.setLastBuild("true");
        tempService.add(microservice);
        return tempService;
    }
}
