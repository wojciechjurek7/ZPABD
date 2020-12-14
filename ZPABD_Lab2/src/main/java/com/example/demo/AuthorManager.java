package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorManager {
	
	private final AuthorRepository authorRepository;
	
	@Autowired
	public AuthorManager(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	public Optional<Author> findById(Long id) {
		return authorRepository.findById(id);
	}
	
	public Iterable<Author> findAll() {
		return authorRepository.findAll();
	}
	
	public Author save(Author author) {
		return authorRepository.save(author);
	}
	
	public void delete(Long id) {
		authorRepository.deleteById(id);
	}
}
