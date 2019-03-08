package org.wecancodeit.blogsite.post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{

	Post findByTitle(String blogPostTitle);

}
