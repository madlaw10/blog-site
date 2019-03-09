package org.wecancodeit.blogsite.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.blogsite.models.Author;
import org.wecancodeit.blogsite.models.Category;
import org.wecancodeit.blogsite.repositories.AuthorRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Resource
	AuthorRepository authorRepo;

	@GetMapping("/author/{id}")
	public String getAuthor(@PathVariable Long id, Model model) throws Exception {
		Optional<Author> author = authorRepo.findById(id);
		if (author.isPresent()) {
			model.addAttribute("author", author.get());
		} else {
			throw new Exception("The author you're looking for does not exist");
		}

		return "authors/author-single";

	}
	
	@GetMapping("/")
	public String getAllAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors/author-all";
		
		
	}

	@PostMapping("/")
	public String addAuthor(String name) {
		Author authorToAdd = authorRepo.findByName(name);
		if (authorToAdd == null) {
			authorToAdd = authorRepo.save(new Author(name));
		}
		
		return "redirect:/authors/";
		
	}
}
