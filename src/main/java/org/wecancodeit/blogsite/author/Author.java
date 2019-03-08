package org.wecancodeit.blogsite.author;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



import org.wecancodeit.blogsite.post.Post;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToMany 
	private Collection<Post> posts;
	
	public Author() {}
	
	public Author(String name, Post ...posts) {
		this.name = name;
		this.posts = Arrays.asList(posts);
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
