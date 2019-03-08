package org.wecancodeit.blogsite.author;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AuthorTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource 
	private AuthorRepository authorRepo;
	
	@Test
	public void shouldLoadAuthorByName() {
		Author author = authorRepo.save(new Author("test name"));
		
		entityManager.persist(author);
		entityManager.flush();
		entityManager.clear();
		
		Author authorFromDatabase = authorRepo.findByName("test name");
		
		assertThat(authorFromDatabase.getName(), is("test name"));		
	}

}
