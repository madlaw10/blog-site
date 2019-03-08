package org.wecancodeit.blogsite.post;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {
	
	@Resource
	PostRepository postRepo;

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

}
