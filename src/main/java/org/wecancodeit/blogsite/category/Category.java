package org.wecancodeit.blogsite.category;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.wecancodeit.blogsite.post.Post;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany (mappedBy= "category")
	private Collection<Post> posts;
	public Category() {}
	
	public Category(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Post> getPosts() {
	return posts;
	}

	@Override
	public String toString() {
		return "name=" + name + ", posts=" + posts;
	}
	
	
	
	

}
