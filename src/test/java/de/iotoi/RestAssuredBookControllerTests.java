package de.iotoi;

import de.iotoi.model.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import static org.assertj.core.api.Assertions.*;


public class RestAssuredBookControllerTests {
    private static final String API_ROOT
            = "http://localhost:8080/api/books";

    private Book createRandomBook() {
        Book book = new Book();
        book.setTitle(randomAlphabetic(10));
        book.setAuthor(randomAlphabetic(15));
        return book;
    }

    private String createBookAsUri(Book book) {
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

    /*******************************************
     *
     * test finding books using variant methods
     *
     *******************************************/
     @Test
    public void whenGetAllBooks_thenOK() {
        Response response = RestAssured.get(API_ROOT);

        assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatusCode());
    }

    @Test
    public void whenGetBooksByTitle_thenOK() {
        Book book = createRandomBook();
        createBookAsUri(book);
        Response response = RestAssured.get(
                API_ROOT + "/title/" + book.getTitle());

        assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatusCode());
        assertThat(response.as(List.class)
                .size() > 0).isTrue();
    }

    @Test
    public void whenGetCreatedBookById_thenOK() {
        Book book = createRandomBook();
        String location = createBookAsUri(book);
        Response response = RestAssured.get(location);

        assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatusCode());
        assertThat(book.getTitle()).isEqualTo(response.jsonPath().get("title"));
    }

    @Test
    public void whenGetNotExistBookById_thenNotFound() {
        Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));

        assertThat(HttpStatus.NOT_FOUND.value()).isEqualTo(response.getStatusCode());
    }

    /*************************************
     *
     * test creating a new book
     *
    **************************************/
    @Test
    public void whenInvalidBookAuthor_thenError() {
        Book book = createRandomBook();
        book.setAuthor(null);
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);

        assertThat(HttpStatus.INTERNAL_SERVER_ERROR.value()).isEqualTo(response.getStatusCode());
    }

    @Test
    public void whenInvalidBookTitle_thenError() {
        Book book = createRandomBook();
        book.setTitle(null);
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);

        assertThat(HttpStatus.INTERNAL_SERVER_ERROR.value()).isEqualTo(response.getStatusCode());
    }


    @Test
    public void whenCreateNewBook_thenCreated() {
        Book book = createRandomBook();
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);

        assertThat(HttpStatus.CREATED.value()).isEqualTo(response.getStatusCode());
    }

    /*************************************
     *
     * test updating an existing book
     *
     *************************************/
    @Test
    public void whenUpdateCreatedBook_thenUpdated() {
        Book book = createRandomBook();
        String location = createBookAsUri(book);
        book.setId(Long.parseLong(location.split("api/books/")[1]));
        book.setAuthor("newAuthor");
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .put(location);

        assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatusCode());

        response = RestAssured.get(location);

        assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatusCode());
        assertThat("newAuthor").isEqualTo(response.jsonPath().get("author"));
    }
}
