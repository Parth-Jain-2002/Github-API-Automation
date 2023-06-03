package com.parth.miniproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.parth.miniproject.models.Repo;

public interface RepoRepository extends MongoRepository<Repo, String>{
    
}
