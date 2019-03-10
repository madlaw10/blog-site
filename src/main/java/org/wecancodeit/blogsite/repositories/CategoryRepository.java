package org.wecancodeit.blogsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.blogsite.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	Category findByName(String name);

}
