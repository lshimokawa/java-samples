package net.lshimokawa.ejemplos.book.service;

import java.util.List;

import net.lshimokawa.ejemplos.book.model.Book;

/**
 * @author lshimokawa
 */
public interface BookService {

	Book find(String isbn);

	List<Book> findAll();

	void save(Book book);

	void update(Book book);

	void delete(Book book);

}