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
import org.wecancodeit.blogsite.controllers.AuthorController;
import org.wecancodeit.blogsite.models.Author;
import org.wecancodeit.blogsite.repositories.AuthorRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorMvcTest {
	

		@Resource
		private MockMvc mvc;

		@MockBean
		private AuthorRepository authorRepo;

		@Mock
		private Author author;

		@Test
		public void shouldRouteToSingleAuthorView() throws Exception {
			Long id = 1L;
			when(authorRepo.findById(id)).thenReturn(Optional.of(author));
			mvc.perform(get("/authors/author/1")).andExpect(view().name(is("authors/author-single")));
		}

		@Test
		public void shouldBeOkForSingleAuthor() throws Exception {
			Long id = 1L;
			when(authorRepo.findById(id)).thenReturn(Optional.of(author));
			mvc.perform(get("/authors/author/1")).andExpect(status().isOk());
		}

		@Test
		public void shouldPutSingleAuthorIntoModel() throws Exception {
			Long id = 1L;
			when(authorRepo.findById(id)).thenReturn(Optional.of(author));
			mvc.perform(get("/authors/author/1")).andExpect(model().attribute("author", is(author)));
		}

//		@Test
//		public void shouldRouteToAllAuthorsView() throws Exception {
//			when(authorRepo.findAll()).thenReturn(authorRepo.findAll());
//			mvc.perform(get("/authors")).andExpect(view().name(is("authors/author-all")));
//		}

//		@Test
//		public void shouldBeOkForSingleAuthor() throws Exception {
//			Long id = 1L;
//			when(authorRepo.findById(id)).thenReturn(Optional.of(author));
//			mvc.perform(get("/authors/author/1")).andExpect(status().isOk());
//		}
//
//		@Test
//		public void shouldPutSingleAuthorIntoModel() throws Exception {
//			Long id = 1L;
//			when(authorRepo.findById(id)).thenReturn(Optional.of(author));
//			mvc.perform(get("/authors/author/1")).andExpect(model().attribute("author", is(author)));
//		}
}
