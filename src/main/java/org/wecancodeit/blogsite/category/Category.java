package org.wecancodeit.blogsite.category;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
//	private Collection<Post> posts;
	
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

//	public Collection<Post> getPosts() {
//		return posts;
//	}
//
//	@Override
//	public String toString() {
//		return "name=" + name + ", posts=" + posts;
//	}
	
	
	
	

}
