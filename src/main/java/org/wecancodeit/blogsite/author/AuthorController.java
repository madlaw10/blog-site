package org.wecancodeit.blogsite.author;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
