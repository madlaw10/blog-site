package org.wecancodeit.blogsite;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PostTest {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource 
	private PostRepository blogPostRepo;
	
	@Test
	public void shouldLoadBlogPostByTitle() {
		Post blogPost = blogPostRepo.save(new Post("Blog Post Title", "Blog Post Content"));
		
		entityManager.persist(blogPost);
		entityManager.flush();
		entityManager.clear();
		
		Post blogPostFromDatabase =  blogPostRepo.findByTitle("Blog Post Title");
		
		assertThat(blogPostFromDatabase.getTitle(), is("Blog Post Title"));		
	}

}
