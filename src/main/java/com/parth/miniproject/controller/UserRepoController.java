package com.parth.miniproject.controller;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parth.miniproject.models.Repo;
import com.parth.miniproject.models.RepoRequestDTO;
import com.parth.miniproject.repository.RepoRepository;
import com.parth.miniproject.service.RestService;

@RestController
@RequestMapping("/me")
public class UserRepoController {

    @Autowired
    private RepoRepository repoRepository;
    
    @PostMapping("/create/repo")
    public ResponseEntity<?> createUserRepo(@RequestBody RepoRequestDTO repoRequestDTO) throws JsonMappingException, JsonProcessingException{
        // Create a user repo for the given username
        RestService restService = new RestService();
        String requestRepo = restService.createUserRepo(repoRequestDTO);

        if (requestRepo == "Failure"){
            return ResponseEntity.badRequest().body("Failed to create repo");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(requestRepo);

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
    
        this.repoRepository.save(repo);
        return ResponseEntity.ok(requestRepo);
    }
}
