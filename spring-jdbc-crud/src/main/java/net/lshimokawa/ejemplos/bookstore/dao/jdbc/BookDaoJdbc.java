package net.lshimokawa.ejemplos.bookstore.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import net.lshimokawa.ejemplos.bookstore.dao.BookDao;
import net.lshimokawa.ejemplos.bookstore.model.Book;

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

	public Book find(Integer id) {
		try {
			return getSimpleJdbcTemplate().queryForObject(
					"select id, title, author from books where id=?",
					new BeanPropertyRowMapper<Book>(Book.class), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Book> findAll() {
		return getSimpleJdbcTemplate().query(
				"select id, title, author from books",
				new BeanPropertyRowMapper<Book>(Book.class));
	}

	@Override
	public void create(Book book) {
		getJdbcTemplate().update(
				"insert into books (title, author) values(?, ?)",
				book.getTitle(), book.getAuthor());
		// Setear el id autogenerado por el identity de HSQL
		book.setId(getSimpleJdbcTemplate().queryForInt("call identity()"));
	}

	@Override
	public void update(Book book) {
		getSimpleJdbcTemplate().update(
				"update books set title=?, author=? where id=?",
				book.getTitle(), book.getAuthor(), book.getId());
	}

	@Override
	public void delete(Integer id) {
		getSimpleJdbcTemplate().update("delete from books where id=?", id);
	}

}
