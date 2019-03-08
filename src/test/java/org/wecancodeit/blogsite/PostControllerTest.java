package org.wecancodeit.blogsite;


import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class PostControllerTest {
	
	@InjectMocks
	private PostController underTest;
	
	@Mock
	private PostRepository blogPostRepo;
	
	@Mock
	private Post blogPost;
	
	@Mock
	private Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddBlogPostToModel() throws Exception {
		Long blogPostId = 1L;
		when(blogPostRepo.findById(blogPostId)).thenReturn(Optional.of(blogPost));
		
		underTest.getBlogPost(blogPostId, model);
		
		verify(model).addAttribute("blogPost", blogPost);
	}

}
