package org.wecancodeit.blogsite.post;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.blogsite.category.Category;
import org.wecancodeit.blogsite.category.CategoryRepository;
import org.wecancodeit.blogsite.tag.Tag;
import org.wecancodeit.blogsite.tag.TagRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PostTest {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource 
	private PostRepository postRepo;
	@Resource
	private CategoryRepository categoryRepo;
	@Resource
	private TagRepository tagRepo;
	@Test
	public void shouldLoadPostByTitle() {
		
		Category category = categoryRepo.save(new Category("Category"));
		Tag tag = tagRepo.save(new Tag("Tag"));
		Post post = postRepo.save(new Post("Post Title", "Post Content", category, tag));
		
		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();
		
		Post blogPostFromDatabase =  postRepo.findByTitle("Post Title");
		
		assertThat(blogPostFromDatabase.getTitle(), is("Post Title"));		
	}

}
