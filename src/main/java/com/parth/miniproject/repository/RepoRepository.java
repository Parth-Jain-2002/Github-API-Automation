package com.parth.miniproject.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.parth.miniproject.models.Repo;

public interface RepoRepository extends MongoRepository<Repo, String>{

    ArrayList<Repo> findByOwner(String username);
    
}
