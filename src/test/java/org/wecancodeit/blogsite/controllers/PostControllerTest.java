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
import org.wecancodeit.blogsite.models.Post;
import org.wecancodeit.blogsite.repositories.PostRepository;

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
	
	@Test
	public void shouldAddAllPostsToModel() {
		underTest.getAllPosts(model);
		verify(model).addAttribute("posts", postRepo.findAll());
		
		
		
	}

}
