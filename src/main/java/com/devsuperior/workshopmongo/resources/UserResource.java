package com.devsuperior.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.workshopmongo.domain.User;
import com.devsuperior.workshopmongo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		/*
		 * User maria = new User("1", "Maria Luiza", "maria@outlook.com"); User thom =
		 * new User("2", "Thom Yorke", "radiohead@outlook.com");
		 */
		List<User> list = service.findAll();
		return ResponseEntity.ok(list);
	}

}
