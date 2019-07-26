package com.example.julesbackend.controller;

import com.example.julesbackend.model.Microservice;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.http.util.EntityUtils;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MicroServiceController {

    private List<Microservice> microservices = createList();
    int count;

    @RequestMapping(value = "/service", produces = "application/json")
    public List<Microservice> allMicroServices() {
        System.out.println("get mapping [service] started");
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

    @PostMapping("/responsebox")
    public @ResponseBody String firstApi(){
        count++;
        System.out.println("you made a post to /reponsebox, count: " + count);
        HttpHeaders headers = new HttpHeaders();
        headers.set("question1", "answer1");
        ResponseEntity<String> response = new ResponseEntity<>("there are thousand stars in my eyes", HttpStatus.OK);

        return response.ok()
                .headers(headers)
                .body("mother teressa was a awesome woman").getHeaders().toString();

    }
    @PutMapping(value = "/responsebox/1",
            consumes={MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
     public void firstPut()
    {

    }

    @GetMapping("/response")
    public String doIt() throws Exception{
        String url = "http://localhost:8080/responsebox/1";

        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        System.out.println("\nSending 'GET' request to URL : " + url);

        String inputLine;
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println("content: " + conn.getContent());
        return response.toString();
    }

}
