package org.wecancodeit.blogsite.post;

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
public class PostTest {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource 
	private PostRepository postRepo;
	
	@Test
	public void shouldLoadPostByTitle() {
		Post post = postRepo.save(new Post("Post Title", "Post Content"));
		
		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();
		
		Post blogPostFromDatabase =  postRepo.findByTitle("Post Title");
		
		assertThat(blogPostFromDatabase.getTitle(), is("Post Title"));		
	}

}
