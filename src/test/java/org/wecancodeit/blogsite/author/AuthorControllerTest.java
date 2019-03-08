package org.wecancodeit.blogsite.author;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

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

}
