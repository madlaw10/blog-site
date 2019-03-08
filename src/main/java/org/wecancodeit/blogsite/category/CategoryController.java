package org.wecancodeit.blogsite.category;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Resource
	CategoryRepository categoryRepo;

	@GetMapping("/category/{id}")
	public String getCategory(@PathVariable Long id, Model model) throws Exception {
	Optional<Category> category = categoryRepo.findById(id);	
	if(category.isPresent()) {
		model.addAttribute("category", category.get());
	}
	else {
		throw new Exception("The category you're looking for does not exist");
	}
		return "categories/category-single";
		
	}

}
