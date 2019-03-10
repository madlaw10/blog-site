package org.wecancodeit.blogsite.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.blogsite.models.Tag;
import org.wecancodeit.blogsite.repositories.TagRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TagTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource 
	private TagRepository tagRepo;
	
	@Test
	public void shouldLoadTagByTitle() {
		Tag tag = tagRepo.save(new Tag("test name"));
		
		entityManager.persist(tag);
		entityManager.flush();
		entityManager.clear();
		
		Tag tagFromDatabase =  tagRepo.findByName("test name");
		
		assertThat(tagFromDatabase.getName(), is("test name"));		
	}

}
