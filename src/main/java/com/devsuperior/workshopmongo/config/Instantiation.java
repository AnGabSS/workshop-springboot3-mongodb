package com.devsuperior.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devsuperior.workshopmongo.domain.Post;
import com.devsuperior.workshopmongo.domain.User;
import com.devsuperior.workshopmongo.repository.PostRepository;
import com.devsuperior.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User thom = new User(null, "Thom Yorke", "radiohead@gmail.com");
		User mBovary = new User(null, "Madame Bovary", "bovary@hotmail.com");
		User david = new User(null, "David Bowie", "bowie@outlook.com");
		
		Post post1 = new Post(null, sdf.parse("12/09/2024"), "Partiu viagem", "Vou viajar para São Paulo, abraços! :)", thom);
		Post post2 = new Post(null, sdf.parse("06/10/2024"), "Bom dia", "Hoje acordei mto feliz", mBovary);
		
		userRepository.saveAll(Arrays.asList(thom, mBovary, david));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
