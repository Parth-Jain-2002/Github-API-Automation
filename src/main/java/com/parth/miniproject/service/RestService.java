package com.parth.miniproject.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

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

    public ArrayList<Repo> getUserReposArray(String username) throws JsonMappingException, JsonProcessingException{
        JsonNode jsonNode = getUserRepos(username);
        ArrayList <Repo> repos = new ArrayList<Repo>();

        for (JsonNode node : jsonNode) {
            Repo repo = new Repo();
            repo.setId(node.get("id").asInt(0));
            repo.setNode_id(node.get("node_id").asText());
            repo.setName(node.get("name").asText());
            repo.setFull_name(node.get("full_name").asText());
            repo.setOwner(node.get("owner").get("login").asText());

            ZonedDateTime zdt = ZonedDateTime.parse(node.get("created_at").asText());
            LocalDateTime created_at = zdt.toLocalDateTime();
            zdt = ZonedDateTime.parse(node.get("updated_at").asText());
            LocalDateTime updated_at = zdt.toLocalDateTime();
            zdt = ZonedDateTime.parse(node.get("pushed_at").asText());
            LocalDateTime pushed_at = zdt.toLocalDateTime();

            repo.setCreated_at(created_at);
            repo.setUpdated_at(updated_at);
            repo.setPushed_at(pushed_at);
            
            repos.add(repo);
        }
        return repos;
    }

    public static void main(String[] args) throws JsonMappingException, JsonProcessingException{
        // RestTemplate restTemplate = new RestTemplate();

        // // Set the URL endpoint you want to send the GET request to
        // String url = "https://api.github.com/users/Parth-Jain-2002/repos";

        // // Send the GET request and retrieve the response
        // ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        
        
        // // Print the JSON response
        // System.out.println(getUserReposString("Parth-Jain-2002"));

        // // Extract the response body
        // String responseBody = response.getBody();

        // Process the response as needed
        //System.out.println(responseBody);
    }
}
