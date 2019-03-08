package org.wecancodeit.blogsite.tag;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tags")
public class TagController {
	
	@Resource
	TagRepository tagRepo;
	
	@GetMapping("/tag/{id}") 
		public String getTag(@PathVariable Long id, Model model) throws Exception {
			Optional<Tag> tag = tagRepo.findById(id);
			if (tag.isPresent()) {
				model.addAttribute("tag", tag.get());
			} else {
				throw new Exception("The tag you're looking for does not exist");
			}

			return "tags/tag-single";
	}

}
