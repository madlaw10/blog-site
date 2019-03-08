package org.wecancodeit.blogsite.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.blogsite.models.Category;
import org.wecancodeit.blogsite.repositories.CategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CategoryTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource 
	private CategoryRepository categoryRepo;
	
	@Test
	public void shouldLoadBlogPostByTitle() {
		Category category = categoryRepo.save(new Category("test name"));
		
		entityManager.persist(category);
		entityManager.flush();
		entityManager.clear();
		
		Category categoryFromDatabase =  categoryRepo.findByName("test name");
		
		assertThat(categoryFromDatabase.getName(), is("test name"));		
	}


}
