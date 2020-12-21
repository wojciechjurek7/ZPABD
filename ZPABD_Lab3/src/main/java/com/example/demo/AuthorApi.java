package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorApi {
	private AuthorManager authorManager;

	@Autowired
	public AuthorApi(AuthorManager authorManager) {
		super();
		this.authorManager = authorManager;
	}
	
	@GetMapping("/all")
	public Iterable<Author> getAll() {
		return authorManager.findAll();
	}
	
	@GetMapping("/id")
	public Optional<Author> getById(@RequestParam Long id) {
		return authorManager.findById(id);
	}
	
	@PostMapping("/add")
	public Author addAuthor(@RequestBody Author author) {
		return authorManager.save(author);
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam Long id) {
		authorManager.delete(id);
	}

}
