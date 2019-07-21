package com.example.julesbackend.controller;

import com.example.julesbackend.model.Microservice;
import com.example.julesbackend.repositories.CarRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.*;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarController {

    private String username;
    private String password;


    private void setCredential(){
        Scanner scan  = new Scanner(System.in);

        System.out.println("Type your sid");
        username = scan.nextLine();

        System.out.println("Type your pasword");
        password = scan.nextLine();

    }

    @GetMapping("/go")
    public String showJenkin() throws Exception {
        int rspCode =0;
        StringBuilder builder = new StringBuilder();
//        setCredential();

        try {
            URL url = new URL("https://reqres.in/api/login"); // Jenkins URL localhost:8080, job named 'test'
            HttpsURLConnection urlConn = (HttpsURLConnection) url.openConnection();

            System.out.println("sending request...");
            urlConn.setRequestMethod("POST");
//            urlConn.setAllowUserInteraction(false); // no user interaction
            urlConn.setDoOutput(true); // want to send
            urlConn.setRequestProperty("User-Agent", USER_AGENT);


//            urlConn.setRequestProperty("Content-type", "application/json");
//            urlConn.setRequestProperty("accept", "application/json");
            username = "o";
            password = "o";
            String cred = username + ":" + password;
//            urlConn.setRequestProperty("authorization", "Basic " + Base64.getEncoder().encodeToString(cred.getBytes("utf-8")));
            Map headerFields = urlConn.getHeaderFields();
            System.out.println("Status Code: " + urlConn.getResponseCode());
            System.out.println("header fields are: " + headerFields);
            rspCode = urlConn.getResponseCode();

            if (rspCode == 200) {
                BufferedReader  br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                String line;
                while ((line=br.readLine()) !=null) {
                    builder.append(line);
                }
                br.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
        return builder.toString();
    }

    @GetMapping("/apres")
    public String doIt() throws Exception{
        String url = "https://reqres.in/api/login";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("POST");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        return response.toString();
    }

}
