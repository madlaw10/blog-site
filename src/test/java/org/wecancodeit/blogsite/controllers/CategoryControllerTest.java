package org.wecancodeit.blogsite.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.wecancodeit.blogsite.controllers.CategoryController;
import org.wecancodeit.blogsite.models.Category;
import org.wecancodeit.blogsite.repositories.CategoryRepository;

public class CategoryControllerTest {
	
	@InjectMocks
	private CategoryController underTest;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private Category category;
	
	@Mock
	private Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddPostToModel() throws Exception {
		Long id = 1L;
		when(categoryRepo.findById(id)).thenReturn(Optional.of(category));
		
		underTest.getCategory(id, model);
		
		verify(model).addAttribute("category", category);
	}
	
	@Test
	public void shouldAddAllCategoriesToModel() {
		underTest.getAllCategories(model);
		verify(model).addAttribute("categories", categoryRepo.findAll());
		
		
		
	}

}
