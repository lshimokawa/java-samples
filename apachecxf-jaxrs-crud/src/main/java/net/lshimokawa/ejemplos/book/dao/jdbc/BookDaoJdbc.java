package net.lshimokawa.ejemplos.book.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import net.lshimokawa.ejemplos.book.dao.BookDao;
import net.lshimokawa.ejemplos.book.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author lshimokawa
 * 
 */
@Repository
public class BookDaoJdbc extends SimpleJdbcDaoSupport implements BookDao {

	@Autowired
	public BookDaoJdbc(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public Book find(String isbn) {
		try {
			return getSimpleJdbcTemplate().queryForObject(
					"select isbn, title, author from books where isbn=?",
					new BeanPropertyRowMapper<Book>(Book.class), isbn);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Book> findAll() {
		return getSimpleJdbcTemplate().query(
				"select isbn, title, author from books",
				new BeanPropertyRowMapper<Book>(Book.class));
	}

	@Override
	public void save(Book book) {
		getSimpleJdbcTemplate().update(
				"insert into books(isbn, title, author) values (?, ?, ?)",
				book.getIsbn(), book.getTitle(), book.getAuthor());
	}

	@Override
	public void update(Book book) {
		getSimpleJdbcTemplate().update(
				"update books set title=?, author=? where isbn=?",
				book.getTitle(), book.getAuthor(), book.getIsbn());
	}

	@Override
	public void delete(String isbn) {
		getSimpleJdbcTemplate().update("delete from books where isbn=?", isbn);
	}

}
