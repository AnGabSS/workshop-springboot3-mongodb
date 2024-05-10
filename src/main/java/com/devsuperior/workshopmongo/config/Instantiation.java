package com.devsuperior.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devsuperior.workshopmongo.domain.User;
import com.devsuperior.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User thom = new User(null, "Thom Yorke", "radiohead@gmai.com");
		User mBovary = new User(null, "Madame Bovary", "bovary@hotmail.com");
		User david = new User(null, "David Bowie", "bowie@outlook.com");
		
		userRepository.saveAll(Arrays.asList(thom, mBovary, david));
		
	}

}
