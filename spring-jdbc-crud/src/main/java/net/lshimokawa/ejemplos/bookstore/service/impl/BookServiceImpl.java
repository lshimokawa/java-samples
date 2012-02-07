package net.lshimokawa.ejemplos.bookstore.service.impl;

import java.util.List;

import net.lshimokawa.ejemplos.bookstore.dao.BookDao;
import net.lshimokawa.ejemplos.bookstore.model.Book;
import net.lshimokawa.ejemplos.bookstore.service.BookService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lshimokawa
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
	private Logger logger = Logger.getLogger(BookServiceImpl.class);
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
		logger.debug("Book created with id: " + book.getId());
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
