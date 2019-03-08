package org.wecancodeit.blogsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.blogsite.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{

	Tag findByName(String name);

}
