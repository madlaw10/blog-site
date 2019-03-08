package org.wecancodeit.blogsite.tag;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class TagControllerTest {
	
	@InjectMocks
	private TagController underTest;
	
	@Mock
	private TagRepository tagRepo;
	
	@Mock
	private Tag tag;
	
	@Mock
	private Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddTagToModel() throws Exception {
		Long id = 1L;
		when(tagRepo.findById(id)).thenReturn(Optional.of(tag));
		
		underTest.getTag(id, model);
		
		verify(model).addAttribute("tag", tag);
	}

}
