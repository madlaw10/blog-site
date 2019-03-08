package org.wecancodeit.blogsite.post;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import org.wecancodeit.blogsite.author.Author;
import org.wecancodeit.blogsite.category.Category;
import org.wecancodeit.blogsite.tag.Tag;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String body;
	private LocalDateTime date;
	@ManyToMany (mappedBy= "posts")
	private Collection<Author> authors;
	@ManyToOne
	private Category category;
	@ManyToMany
	private Collection<Tag> tags;

	public Post() {
	}

	public Post(String title, String body, Category category, Tag ...tags) {
		this.title = title;
		this.body = body;
		this.date = LocalDateTime.now();
		this.category = category;
		this.tags =Arrays.asList(tags);
		
		
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public Category getCategory() {
		return category;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "title=" + title + ", body=" + body + ", date=" + date + ", authors=" + authors + ", category="
				+ category + ", tags=" + tags;
	}

}
