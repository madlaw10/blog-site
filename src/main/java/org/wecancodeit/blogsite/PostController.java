package org.wecancodeit.blogsite;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {
	
	@Resource
	PostRepository blogPostRepo;

	@GetMapping("/blog/{blogPostId}")
	public String getBlogPost(@PathVariable Long blogPostId, Model model) throws Exception {
		Optional<Post> blogPost = blogPostRepo.findById(blogPostId);
		if(blogPost.isPresent()) {
			model.addAttribute("blogPost", blogPost.get());
		} else {
			throw new Exception("The blog post you're looking for does not exist");
		}
		return "blog-posts/single";
		
	}

}
