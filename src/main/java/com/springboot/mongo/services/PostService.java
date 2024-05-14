package com.springboot.mongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mongo.domain.Post;
import com.springboot.mongo.repository.PostRepository;
import com.springboot.mongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date dateMin, Date dateMax) {
		dateMax = new Date(dateMax.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, dateMin, dateMax);
	}
	
}