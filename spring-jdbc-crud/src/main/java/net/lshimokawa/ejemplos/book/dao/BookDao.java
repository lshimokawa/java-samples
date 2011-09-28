package net.lshimokawa.ejemplos.book.dao;

import java.util.List;

import net.lshimokawa.ejemplos.book.model.Book;

/**
 * 
 * @author lshimokawa
 * 
 */
public interface BookDao {

	Book find(String isbn);

	List<Book> findAll();

	void save(Book book);

	void update(Book book);

	void delete(Book book);

}
