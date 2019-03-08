package org.wecancodeit.blogsite.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.blogsite.models.Author;
import org.wecancodeit.blogsite.models.Category;
import org.wecancodeit.blogsite.models.Post;
import org.wecancodeit.blogsite.repositories.AuthorRepository;
import org.wecancodeit.blogsite.repositories.CategoryRepository;
import org.wecancodeit.blogsite.repositories.PostRepository;

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
	private AuthorRepository authorRepo;

	@Test
	public void shouldLoadPostByTitle() {

		Category category = categoryRepo.save(new Category("Category"));
		Author author = authorRepo.save(new Author("Author"));
		Post post = postRepo.save(new Post("Post Title", "Post Content", category, author));

		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();

		Post blogPostFromDatabase = postRepo.findByTitle("Post Title");

		assertThat(blogPostFromDatabase.getTitle(), is("Post Title"));
	}

}
