package org.wecancodeit.blogsite.post;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
	private PostRepository postRepo;
	
	@Mock
	private Post post;
	
	@Mock
	private Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddPostToModel() throws Exception {
		Long id = 1L;
		when(postRepo.findById(id)).thenReturn(Optional.of(post));
		
		underTest.getPost(id, model);
		
		verify(model).addAttribute("post", post);
	}

}
