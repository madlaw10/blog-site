package org.wecancodeit.blogsite.category;

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
