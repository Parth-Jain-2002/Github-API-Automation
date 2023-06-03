package com.parth.miniproject.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parth.miniproject.models.Repo;

public class RestService {
    private RestTemplate restTemplate;

    public RestService() {
        this.restTemplate = new RestTemplate();
    }

    public JsonNode getUserRepos(String username) throws JsonMappingException, JsonProcessingException{
        // Set the URL endpoint you want to send the GET request to
        String url = "https://api.github.com/users/" + username + "/repos";

        // Send the GET request and retrieve the response
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Extract the response body
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.getBody());

        return jsonNode;
    }

    public String getUserReposString(String username) throws JsonMappingException, JsonProcessingException{
        JsonNode jsonNode = getUserRepos(username);
        return jsonNode.toPrettyString();
    }

    public static void main(String[] args) throws JsonMappingException, JsonProcessingException{
        RestTemplate restTemplate = new RestTemplate();

        // Set the URL endpoint you want to send the GET request to
        String url = "https://api.github.com/users/Parth-Jain-2002/repos";

        // Send the GET request and retrieve the response
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        
        
        // Print the JSON response
        System.out.println(getUserReposString("Parth-Jain-2002"));

        // // Extract the response body
        // String responseBody = response.getBody();

        // Process the response as needed
        //System.out.println(responseBody);
    }
}
