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
import org.wecancodeit.blogsite.controllers.TagController;
import org.wecancodeit.blogsite.models.Tag;
import org.wecancodeit.blogsite.repositories.TagRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(TagController.class)
public class TagMvcTest {
	
	@Resource
	private MockMvc mvc;

	@MockBean
	private TagRepository tagRepo;

	@Mock
	private Tag tag;

	@Test
	public void shouldRouteToSingleTagView() throws Exception {
		Long id = 1L;
		when(tagRepo.findById(id)).thenReturn(Optional.of(tag));
		mvc.perform(get("/tags/tag/1")).andExpect(view().name(is("tags/tag-single")));
	}

	@Test
	public void shouldBeOkForSingleTag() throws Exception {
		Long id = 1L;
		when(tagRepo.findById(id)).thenReturn(Optional.of(tag));
		mvc.perform(get("/tags/tag/1")).andExpect(status().isOk());
	}

	@Test
	public void shouldPutSingleTagIntoModel() throws Exception {
		Long id = 1L;
		when(tagRepo.findById(id)).thenReturn(Optional.of(tag));
		mvc.perform(get("/tags/tag/1")).andExpect(model().attribute("tag", is(tag)));
	}


}
