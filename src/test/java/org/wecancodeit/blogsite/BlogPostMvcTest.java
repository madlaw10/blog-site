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

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class BlogPostMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private PostRepository blogPostRepo;

	@Mock
	private Post blogPost;

	@Test
	public void shouldRouteToSingleBlogPostView() throws Exception {
		Long blogPostId = 1L;
		when(blogPostRepo.findById(blogPostId)).thenReturn(Optional.of(blogPost));
		mvc.perform(get("/blog/1")).andExpect(view().name(is("blog-posts/single")));
	}

	@Test
	public void shouldBeOkForSingleBlogPost() throws Exception {
		Long blogPostId = 1L;
		when(blogPostRepo.findById(blogPostId)).thenReturn(Optional.of(blogPost));
		mvc.perform(get("/blog/1")).andExpect(status().isOk());
	}

	@Test
	public void shouldPutSingleBlogPostIntoModel() throws Exception {
		Long blogPostId = 1L;
		when(blogPostRepo.findById(blogPostId)).thenReturn(Optional.of(blogPost));
		mvc.perform(get("/blog/1")).andExpect(model().attribute("blogPost", is(blogPost)));
	}

}
