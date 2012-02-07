package net.lshimokawa.ejemplos.bookstore.service.impl;

import java.util.List;

import net.lshimokawa.ejemplos.bookstore.dao.BookDao;
import net.lshimokawa.ejemplos.bookstore.model.Book;
import net.lshimokawa.ejemplos.bookstore.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lshimokawa
 */
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	public Book find(Integer id) {
		return bookDao.find(id);
	}

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public void create(Book book) {
		bookDao.create(book);
	}

	@Override
	public void update(Book book) {
		bookDao.update(book);
	}

	@Override
	public void delete(Integer id) {
		bookDao.delete(id);
	}

}
