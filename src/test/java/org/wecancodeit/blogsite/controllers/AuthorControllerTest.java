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
import org.wecancodeit.blogsite.controllers.AuthorController;
import org.wecancodeit.blogsite.models.Author;
import org.wecancodeit.blogsite.repositories.AuthorRepository;

public class AuthorControllerTest {
	
	@InjectMocks
	private AuthorController underTest;
	
	@Mock
	private AuthorRepository authorRepo;
	
	@Mock
	private Author author;
	
	@Mock
	private Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddAuthorToModel() throws Exception {
		Long id = 1L;
		when(authorRepo.findById(id)).thenReturn(Optional.of(author));
		
		underTest.getAuthor(id, model);
		
		verify(model).addAttribute("author", author);
	}
	
	@Test
	public void shouldAddAllAuthorsToModel() {
		underTest.getAllAuthors(model);
		verify(model).addAttribute("authors", authorRepo.findAll());
		
		
		
	}
}
