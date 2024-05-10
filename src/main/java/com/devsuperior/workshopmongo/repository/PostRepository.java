package com.devsuperior.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devsuperior.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
