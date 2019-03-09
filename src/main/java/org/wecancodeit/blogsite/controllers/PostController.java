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
import org.wecancodeit.blogsite.models.Post;
import org.wecancodeit.blogsite.models.Tag;
import org.wecancodeit.blogsite.repositories.AuthorRepository;
import org.wecancodeit.blogsite.repositories.CategoryRepository;
import org.wecancodeit.blogsite.repositories.PostRepository;
import org.wecancodeit.blogsite.repositories.TagRepository;

@Controller
@RequestMapping("/posts")
public class PostController {
	
	@Resource
	PostRepository postRepo;
	@Resource
	AuthorRepository authorRepo;
	@Resource
	CategoryRepository categoryRepo;
	@Resource
	TagRepository tagRepo;

	@GetMapping("/post/{id}")
	public String getPost(@PathVariable Long id, Model model) throws Exception {
		Optional<Post> post = postRepo.findById(id);
		if(post.isPresent()) {
			model.addAttribute("post", post.get());
		} else {
			throw new Exception("The post you're looking for does not exist");
		}
		return "posts/post-single";
		
	}
	@GetMapping("/")
	public String getAllPosts(Model model) {
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		return "posts/post-all";
		
		
	}
	
	@PostMapping("/")
	public String addPost(String title, String body, String categoryName, String authorName, String tagName) {
		Category category = categoryRepo.findByName(categoryName);
		Author author = authorRepo.findByName(authorName);
		Tag tag = tagRepo.findByName(tagName);
		postRepo.save(new Post(title, body, category, author, tag));
		return "redirect:/posts/";
		
		
	}

}
