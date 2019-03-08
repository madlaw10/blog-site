package org.wecancodeit.blogsite.author;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.blogsite.category.Category;
import org.wecancodeit.blogsite.category.CategoryRepository;
import org.wecancodeit.blogsite.post.Post;
import org.wecancodeit.blogsite.post.PostRepository;
import org.wecancodeit.blogsite.tag.Tag;
import org.wecancodeit.blogsite.tag.TagRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AuthorTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource 
	private AuthorRepository authorRepo;
	@Resource 
	private PostRepository postRepo;
	@Resource
	private CategoryRepository categoryRepo;
	@Resource
	private TagRepository tagRepo;
	
	@Test
	public void shouldLoadAuthorByName() {
		Category category = categoryRepo.save(new Category("Category"));
		Tag tag = tagRepo.save(new Tag("Tag"));
		Post post = postRepo.save(new Post("Post Title", "Post Content", category, tag));
		Author author = authorRepo.save(new Author("test name", post));
		
		entityManager.persist(author);
		entityManager.flush();
		entityManager.clear();
		
		Author authorFromDatabase = authorRepo.findByName("test name");
		
		assertThat(authorFromDatabase.getName(), is("test name"));		
	}

}
