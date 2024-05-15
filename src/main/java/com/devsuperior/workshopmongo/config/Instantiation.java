package com.devsuperior.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devsuperior.workshopmongo.domain.Post;
import com.devsuperior.workshopmongo.domain.User;
import com.devsuperior.workshopmongo.dto.AuthorDTO;
import com.devsuperior.workshopmongo.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(thom, mBovary, david));
		
		Post post1 = new Post(null, sdf.parse("12/09/2024"), "Partiu viagem", "Vou viajar para São Paulo, abraços! :)", new AuthorDTO(thom));
		Post post2 = new Post(null, sdf.parse("06/10/2024"), "Bom dia", "Hoje acordei mto feliz", new AuthorDTO(mBovary));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(david));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(thom));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(mBovary));
		
		post1.getComments().addAll(Arrays.asList(c1, c3));
		post2.getComments().addAll(Arrays.asList(c2));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		thom.getPosts().add(post1);
		mBovary.getPosts().add(post2);
		userRepository.saveAll(Arrays.asList(thom, mBovary));
	}

}
