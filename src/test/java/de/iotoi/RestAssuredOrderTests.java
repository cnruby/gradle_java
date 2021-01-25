package de.iotoi;

import de.iotoi.model.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestAssuredOrderTests {
    private static final String API_ROOT
            = "http://localhost:8080/api/books";

    private static StringBuilder output = new StringBuilder("");

    private Book createRandomBook() {
        Book book = new Book();
        book.setTitle(randomAlphabetic(10));
        book.setAuthor(randomAlphabetic(15));
        return book;
    }

    @Test
    @Order(1)
    public void firstTest() {
        Response response = RestAssured.get(API_ROOT);
        assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatusCode());

        // if (mv SecurityConfig.java SecurityConfig.java.txt)
        // then (Status Code is 401)

        output.append("a");
    }

    @Test
    @Order(2)
    public void secondTest() {
        Book book = createRandomBook();
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);
        assertThat(HttpStatus.CREATED.value()).isEqualTo(response.getStatusCode());

        output.append("b");
    }

    @Test
    @Order(3)
    public void thirdTest() {
        Response response = RestAssured.get(API_ROOT);
        assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatusCode());

        output.append("c");
    }

    @AfterAll
    public static void assertOutput() {
        assertThat(output.toString()).isEqualTo("abc");
    }
}
