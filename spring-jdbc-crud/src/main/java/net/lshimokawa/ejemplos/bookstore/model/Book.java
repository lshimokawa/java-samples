package net.lshimokawa.ejemplos.bookstore.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author lshimokawa
 * 
 */
@XmlRootElement
public class Book {
	private Integer id;
	private String title;
	private String description;
	private String author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
