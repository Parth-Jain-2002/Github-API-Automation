package com.parth.miniproject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.parth.miniproject.models.Repo;
import com.parth.miniproject.repository.RepoRepository;
import com.parth.miniproject.service.RestService;

@RestController
@RequestMapping("/public")
public class GitAPIController {

    @Autowired
    private RepoRepository repoRepository;
    
    @GetMapping("/repos/{username}")
    public ResponseEntity<String> getUserRepos(@PathVariable String username) throws JsonMappingException, JsonProcessingException{
        // Get repos from GitHub API and return them as a JSON string
        RestService restService = new RestService();
        String result = restService.getUserReposString(username);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/repos/save/{username}")
    public ResponseEntity<String> saveUserRepos(@PathVariable String username) throws JsonMappingException, JsonProcessingException{
        // Get repos from GitHub API and save them to the database
        RestService restService = new RestService();
        ArrayList<Repo> repos = restService.getUserReposArray(username);

        for (Repo repo : repos) {
            repoRepository.save(repo);
        }

        return ResponseEntity.ok("Saved " + repos.size() + " repos of " + username + " to the database.");
    }
}
