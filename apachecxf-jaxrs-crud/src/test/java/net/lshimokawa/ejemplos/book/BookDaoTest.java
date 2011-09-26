package net.lshimokawa.ejemplos.book;

import net.lshimokawa.ejemplos.book.dao.BookDao;
import net.lshimokawa.ejemplos.book.model.Book;

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
		Assert.assertEquals("Agile Software Development",
				bookDao.find("0201699699").getTitle());
	}

	@Test
	public void testCrud() {
		Book create = new Book();
		create.setIsbn("0123456789");
		create.setTitle("New title");
		create.setAuthor("New author");
		bookDao.save(create);
		Assert.assertEquals("New title", bookDao.find(create.getIsbn())
				.getTitle());
		logger.debug("Usuario creado");

		Book update = bookDao.find(create.getIsbn());
		update.setTitle("Updated title");
		bookDao.update(update);
		Assert.assertEquals("Updated title", bookDao.find(create.getIsbn())
				.getTitle());

		Book delete = new Book();
		delete.setIsbn(create.getIsbn());
		bookDao.delete(bookDao.find(create.getIsbn()));

		Assert.assertNull(bookDao.find(create.getIsbn()));
	}
}
