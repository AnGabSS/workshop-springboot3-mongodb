package com.devsuperior.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.workshopmongo.domain.Post;
import com.devsuperior.workshopmongo.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		return ResponseEntity.ok(service.findById(id));
	}

}