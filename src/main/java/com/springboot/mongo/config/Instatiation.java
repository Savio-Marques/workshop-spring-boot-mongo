package com.springboot.mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springboot.mongo.domain.Post;
import com.springboot.mongo.domain.User;
import com.springboot.mongo.repository.PostRepository;
import com.springboot.mongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		postRepository.deleteAll();

		
		Post post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu Viagem", "Vou viajar para são paulo, abraços", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2024"), "Bom dia", "Acordei feliz hoje", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
