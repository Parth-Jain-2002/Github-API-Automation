package com.parth.miniproject.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestService {
    private RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        //this.restTemplate = restTemplateBuilder.build();
    }

    public String getUserRepos(String username){
        String url = "https://api.github.com/users/Parth-Jain-2002/repos";
        String response = this.restTemplate.getForObject(url, String.class);
        return "Success";
    }

    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplate();

        // Set the URL endpoint you want to send the GET request to
        String url = "https://api.github.com/users/Parth-Jain-2002/repos";

        // Send the GET request and retrieve the response
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Extract the response body
        String responseBody = response.getBody();

        // Process the response as needed
        System.out.println(responseBody);
    }
}
