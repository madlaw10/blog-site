package org.wecancodeit.blogsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.blogsite.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Author findByName(String name);

}
