package net.lshimokawa.ejemplos.book.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author lshimokawa
 * 
 */
@XmlRootElement
public class Book {
	private String isbn;
	private String title;
	private String author;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
