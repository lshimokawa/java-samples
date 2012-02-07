package net.lshimokawa.ejemplos.apachecxf.jaxrs.web;

import java.lang.reflect.Type;
import java.util.List;

import net.lshimokawa.ejemplos.bookstore.model.Book;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class BookControllerIntegrationTest {
	private Logger logger = Logger
			.getLogger(BookControllerIntegrationTest.class);
	private static final String BASE_URL = "http://localhost:8080/apachecxf-jaxrs-crud/services/books/";

	@Autowired
	private RestTemplate restTemplate;

	private Gson gson = new Gson();

	@Test
	public void testGetBooks() {
		String response = restTemplate.getForObject(BASE_URL, String.class);
		logger.debug("testGetBooks: " + response);
		List<Book> list = gson.fromJson(response, getGsonType());
		Assert.assertTrue(list.size() > 0);
	}

	@Test
	public void testGetBook() {
		String response = restTemplate.getForObject(BASE_URL + "{id}",
				String.class, 0);
		logger.debug("testGetBook: " + response);
		Book book = gson.fromJson(response, Book.class);
		Assert.assertEquals("Alistair Cockburn", book.getAuthor());
		Assert.assertEquals("Agile Software Development", book.getTitle());
	}

	@Test
	@ExpectedException(RestClientException.class)
	public void testGetBookNotExists() {
		restTemplate.getForObject(BASE_URL + "{isbn}", String.class, "XXX");
	}

	@Test
	public void testPostAndDelete() {
		String jsonRequest = createJsonTestBook();
		logger.debug("jsonRequest: " + jsonRequest);
		String jsonResponse = restTemplate.postForObject(BASE_URL, jsonRequest,
				String.class);
		logger.debug("jsonResponse: " + jsonResponse);
		Book createdBook = gson.fromJson(jsonResponse, Book.class);
		logger.debug("Se cre— el libro con id: " + createdBook.getId());

		String response = restTemplate.getForObject(BASE_URL + "{id}",
				String.class, createdBook.getId());
		Book book = gson.fromJson(response, Book.class);
		Assert.assertEquals("Test Author", book.getAuthor());
		Assert.assertEquals("Test Title", book.getTitle());

		restTemplate.delete(BASE_URL + "{id}", book.getId());
	}

	private String createJsonTestBook() {
		Book book = new Book();
		book.setTitle("Test Title");
		book.setAuthor("Test Author");
		String json = gson.toJson(book);
		return json;
	}

	private Type getGsonType() {
		return new TypeToken<List<Book>>() {
		}.getType();
	}
}
