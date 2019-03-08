package org.wecancodeit.blogsite.tag;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
//	private Collection<Post> posts;
	
	public Tag() {}
	
	public Tag(String name) {
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
