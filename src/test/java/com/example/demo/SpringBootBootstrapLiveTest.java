// package com.example.demo;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.util.List;

// import org.apache.commons.lang3.RandomStringUtils;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit4.SpringRunner;

// import com.example.persistence.models.Book;

// import io.restassured.RestAssured;
// import io.restassured.response.Response;

// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class SpringBootBootstrapLiveTest {
// 	private static final String API_ROOT = "http://localhost:8080/api/books";

// 	private Book createRandomBook() {
// 		Book book = new Book();
// 		book.setTitle(RandomStringUtils.randomAlphabetic(10));
// 		book.setAuthor(RandomStringUtils.randomAlphabetic(25));
// 		return book;
// 	}

// 	private String creatBookAsUrl(Book book) {
// 		Response response = RestAssured.given()
// 			.contentType(MediaType.APPLICATION_JSON_VALUE)
// 			.body(book)
// 			.post(API_ROOT);
// 		return API_ROOT + "/" + response.jsonPath().get("id");
// 	}

// 	@Test
// 	public void whenGetAllBooks_thenOk() {
// 		Response response = RestAssured.get(API_ROOT);

// 		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
// 	}

// 	@Test
// 	public void whenGetBooksByTitle_thenOk() {
// 		Book book = createRandomBook();
// 		creatBookAsUrl(book);
// 		Response response = RestAssured.get(
// 			API_ROOT + "/title/" + book.getTitle()
// 		);

// 		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
// 		assertTrue(response.as(List.class)
// 			.size() > 0
// 		);
// 	}

// 	@Test
// 	public void whenGetCreatedBookById_thenOk() {
// 		Book book = createRandomBook();
// 		String location = creatBookAsUrl(book);
// 		Response response = RestAssured.get(location);
// 		System.out.println(location);

// 		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
// 		assertEquals(book.getTitle(), response.jsonPath()
// 			.get("title"));
// 	}

// 	@Test
// 	public void whenGetNotExxisteBookById_thenNotFound() {
// 		Response response = RestAssured.get(
// 			API_ROOT + "/" + RandomStringUtils.randomNumeric(4)
// 		);

// 		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
// 	}

// 	@Test
// 	public void whenCreateNewBook_thenCreated() {
// 		Book book = createRandomBook();
// 		Response response = RestAssured.given()
// 		.contentType(MediaType.APPLICATION_JSON_VALUE)
// 		.body(book)
// 		.post(API_ROOT);
		
// 		assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
// 	}
	
// 	@Test
// 	public void whenInvalidBook_thenError() {
// 		Book book = createRandomBook();
// 		book.setAuthor(null);
// 		Response response = RestAssured.given()
// 		.contentType(MediaType.APPLICATION_JSON_VALUE)
// 		.body(book)
// 		.post(API_ROOT);
		
// 		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
// 	}

// 	@Test
// 	public void whenUpdateCreatedBook_thenUpdate() {
// 		Book book = createRandomBook();
// 		String location = creatBookAsUrl(book);
// 		Long id = Long.parseLong(location.split("api/books/")[1]);
// 		book.setId(id);
// 		String newAuthor = RandomStringUtils.randomAlphabetic(25);
// 		book.setAuthor(newAuthor);

// 		Response response = RestAssured.given()
// 			.contentType(MediaType.APPLICATION_JSON_VALUE)
// 			.body(book)
// 			.put(location);

// 		assertEquals(HttpStatus.OK.value(), response.getStatusCode());

// 		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
// 		assertEquals(newAuthor, response.jsonPath().get("author"));
// 	}

// 	@Test
// 	public void whenDeleteCreatedBook_thenOk() {
// 		Book book = createRandomBook();
// 		String location = creatBookAsUrl(book);
// 		Response response = RestAssured.delete(location);

// 		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
// 	}
// }
