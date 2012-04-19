package net.lshimokawa.ejemplos.bookstore;

import net.lshimokawa.ejemplos.bookstore.dao.BookDao;
import net.lshimokawa.ejemplos.bookstore.model.Book;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author lshimokawa
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
@Transactional
public class BookDaoTest {
	private Logger logger = Logger.getLogger(BookDaoTest.class);

	@Autowired
	private BookDao bookDao;

	@Test
	public void testFind() {
		Assert.assertEquals("Agile Software Development", bookDao.find(0)
				.getTitle());
	}
	
	@Test
	public void testNotFound() {
		logger.debug(bookDao.find(999));
	}

	@Test
	public void testCrud() {
		Book create = new Book();
		create.setTitle("New title");
		create.setAuthor("New author");
		bookDao.create(create);
		Assert.assertEquals("New title", bookDao.find(create.getId())
				.getTitle());
		logger.debug("Libro creado, con id=" + create.getId());

		Book update = bookDao.find(create.getId());
		update.setTitle("Updated title");
		bookDao.update(update);
		Assert.assertEquals("Updated title", bookDao.find(create.getId())
				.getTitle());

		bookDao.delete(create.getId());

		Assert.assertNull(bookDao.find(create.getId()));
	}
}
