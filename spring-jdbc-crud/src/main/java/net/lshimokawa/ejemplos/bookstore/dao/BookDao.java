package net.lshimokawa.ejemplos.bookstore.dao;

import java.util.List;

import net.lshimokawa.ejemplos.bookstore.model.Book;

/**
 * 
 * @author lshimokawa
 * 
 */
public interface BookDao {

	Book find(Integer id);

	List<Book> findAll();

	void create(Book book);

	void update(Book book);

	void delete(Integer id);

}
