package org.wecancodeit.blogsite;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.blogsite.controllers.PostController;
import org.wecancodeit.blogsite.models.Post;
import org.wecancodeit.blogsite.repositories.PostRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private PostRepository postRepo;

	@Mock
	private Post post;

	@Test
	public void shouldRouteToSingleBlogPostView() throws Exception {
		Long id = 1L;
		when(postRepo.findById(id)).thenReturn(Optional.of(post));
		mvc.perform(get("/posts/post/1")).andExpect(view().name(is("posts/post-single")));
	}

	@Test
	public void shouldBeOkForSingleBlogPost() throws Exception {
		Long id = 1L;
		when(postRepo.findById(id)).thenReturn(Optional.of(post));
		mvc.perform(get("/posts/post/1")).andExpect(status().isOk());
	}

	@Test
	public void shouldPutSingleBlogPostIntoModel() throws Exception {
		Long id = 1L;
		when(postRepo.findById(id)).thenReturn(Optional.of(post));
		mvc.perform(get("/posts/post/1")).andExpect(model().attribute("post", is(post)));
	}

}
