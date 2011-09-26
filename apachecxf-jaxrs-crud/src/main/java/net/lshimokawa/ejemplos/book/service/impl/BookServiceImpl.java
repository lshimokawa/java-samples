package net.lshimokawa.ejemplos.book.service.impl;

import java.util.List;

import net.lshimokawa.ejemplos.book.dao.BookDao;
import net.lshimokawa.ejemplos.book.model.Book;
import net.lshimokawa.ejemplos.book.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lshimokawa
 */
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	public Book find(String isbn) {
		return bookDao.find(isbn);
	}

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	public void save(Book usuario) {
		bookDao.save(usuario);
	}

	public void update(Book usuario) {
		bookDao.update(usuario);
	}

	public void delete(Book usuario) {
		bookDao.delete(usuario);
	}

}
