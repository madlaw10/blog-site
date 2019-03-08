package org.wecancodeit.blogsite.post;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String body;
	private LocalDateTime date;
//	private Collection<Author> authors;
//	private Category category;
//	private Collection<Tag> tags;

	public Post() {
	}

	public Post(String title, String body) {
		this.title = title;
		this.body = body;
		this.date = LocalDateTime.now();
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

//	public Collection<Author> getAuthors() {
//		return authors;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public Collection<Tag> getTags() {
//		return tags;
//	}

//	@Override
//	public String toString() {
//		return "title=" + title + ", body=" + body + ", date=" + date + ", authors=" + authors + ", category="
//				+ category + ", tags=" + tags;
//	}

}
