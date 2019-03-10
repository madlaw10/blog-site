package org.wecancodeit.blogsite.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.blogsite.repositories.AuthorRepository;
import org.wecancodeit.blogsite.repositories.CategoryRepository;
import org.wecancodeit.blogsite.repositories.PostRepository;
import org.wecancodeit.blogsite.repositories.TagRepository;

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
	@Resource
	private TagRepository tagRepo;

	@Test
	public void shouldLoadPostByTitle() {

		Category category = categoryRepo.save(new Category("Category"));
		Author author = authorRepo.save(new Author("Author"));
		Tag tag = tagRepo.save(new Tag("Tag Name"));
		Post post = postRepo.save(new Post("Post Title", "Post Content", category, author, tag));

		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();

		Post blogPostFromDatabase = postRepo.findByTitle("Post Title");

		assertThat(blogPostFromDatabase.getTitle(), is("Post Title"));
	}

	@Test
	public void shouldAddTagToTags() {

		Category category = categoryRepo.save(new Category("Category"));
		Author author = authorRepo.save(new Author("Author"));
		Tag tag = tagRepo.save(new Tag("Tag One"));
		Post post = postRepo.save(new Post("Post Title", "Post Content", category, author, tag));
		Tag tagToAdd = tagRepo.save(new Tag("Tag Two"));
		post.addTagToTags(tagToAdd);
		System.out.println(post.getTags());
		assertThat(post.getTags().contains(tagToAdd), is(true));

	}

	@Test
	public void shouldAddAuthorToAuthors() {

		Category category = categoryRepo.save(new Category("Category"));
		Author author = authorRepo.save(new Author("Author One"));
		Tag tag = tagRepo.save(new Tag("Tag Name"));
		Post post = postRepo.save(new Post("Post Title", "Post Content", category, author, tag));
		Author testAuthor = authorRepo.save(new Author("Author Two"));
		post.addAuthorToAuthors(testAuthor);
		System.out.println(post.getAuthors());
		assertThat(post.getAuthors().contains(testAuthor), is(true));

	}
}