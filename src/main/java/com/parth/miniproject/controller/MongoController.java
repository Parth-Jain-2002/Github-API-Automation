package com.parth.miniproject.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.parth.miniproject.models.Repo;
import com.parth.miniproject.repository.RepoRepository;

@RestController
@RequestMapping("/local")
public class MongoController {
    
    @Autowired
    private RepoRepository repoRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllRepos(){
        return ResponseEntity.ok(repoRepository.findAll());
    }

    @GetMapping("/repos/username/{username}")
    public ResponseEntity<?> getUserRepos(@PathVariable String username){
        return ResponseEntity.ok(repoRepository.findByOwner(username));
    }

    @GetMapping("/repos/keyword/{keyword}")
    public ResponseEntity<?> getReposByKeyword(@PathVariable String keyword){
        List<Repo> repos = repoRepository.findAll();
        ArrayList <Repo> result = new ArrayList<Repo>();
        for (Repo repo : repos) {
            if(repo.getName().contains(keyword)){
                result.add(repo);
            }
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/repos/sort/{username}")
    public ResponseEntity<?> getUserReposSorted(@PathVariable String username){
        // Get the repos sorted by the field created_at
        List<Repo> repos = repoRepository.findByOwner(username);
        repos.sort((Repo r1, Repo r2) -> r1.getCreated_at().compareTo(r2.getCreated_at()));
        return ResponseEntity.ok(repos);
    }

    @GetMapping("/repos/delete/{username}")
    public ResponseEntity<?> deleteUserRepos(@PathVariable String username){
        repoRepository.deleteAll(repoRepository.findByOwner(username));
        return ResponseEntity.ok("Deleted all repos of " + username + " from the database.");
    }


}
