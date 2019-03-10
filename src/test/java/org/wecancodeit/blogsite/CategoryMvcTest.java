package org.wecancodeit.blogsite;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.blogsite.controllers.CategoryController;
import org.wecancodeit.blogsite.models.Category;
import org.wecancodeit.blogsite.repositories.CategoryRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryMvcTest {
	
	@Resource
	private MockMvc mvc;

	@MockBean
	private CategoryRepository categoryRepo;

	@Mock
	private Category category;

	@Test
	public void shouldRouteToSingleCategoryView() throws Exception {
		Long id = 1L;
		when(categoryRepo.findById(id)).thenReturn(Optional.of(category));
		mvc.perform(get("/categories/category/1")).andExpect(view().name(is("categories/category-single")));
	}

	@Test
	public void shouldBeOkForSingleCategory() throws Exception {
		Long id = 1L;
		when(categoryRepo.findById(id)).thenReturn(Optional.of(category));
		mvc.perform(get("/categories/category/1")).andExpect(status().isOk());
	}

	@Test
	public void shouldPutSingleCategoryIntoModel() throws Exception {
		Long id = 1L;
		when(categoryRepo.findById(id)).thenReturn(Optional.of(category));
		mvc.perform(get("/categories/category/1")).andExpect(model().attribute("category", is(category)));
	}

}
