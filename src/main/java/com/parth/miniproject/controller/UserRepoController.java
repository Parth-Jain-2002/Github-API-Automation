package com.parth.miniproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.parth.miniproject.models.RepoRequestDTO;
import com.parth.miniproject.service.RestService;

@RestController
@RequestMapping("/me")
public class UserRepoController {
    
    @PostMapping("/create/repo")
    public ResponseEntity<?> createUserRepo(@RequestBody RepoRequestDTO repoRequestDTO) throws JsonMappingException, JsonProcessingException{
        // Create a user repo for the given username
        RestService restService = new RestService();
        String requestRepo = restService.createUserRepo(repoRequestDTO);
        return ResponseEntity.ok(requestRepo);
    }
}
