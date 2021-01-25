<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_218.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_218)


---

Lesson 218: Hello REST Assured!
<h1>Lesson 218: Hello REST Assured!</h1>

- How to Understand The REST Assured 
- REST Assured is a Java DSL
- REST Assured simplify testing of REST based services built on top of HTTP Builder



---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (check the project)](#do-check-the-project)
- [Develop the gradle build file](#develop-the-gradle-build-file)
  - [DO (add the package `rest-assured` to the gradle build file)](#do-add-the-package-rest-assured-to-the-gradle-build-file)
  - [DO (check the project to get the error)](#do-check-the-project-to-get-the-error)
  - [DO (edit a gradle build file for spring boot)](#do-edit-a-gradle-build-file-for-spring-boot)
  - [DO (check the project again to get many warnings)](#do-check-the-project-again-to-get-many-warnings)
  - [DO (edit a gradle build file for spring boot again)](#do-edit-a-gradle-build-file-for-spring-boot-again)
  - [DO (check the project noch again)](#do-check-the-project-noch-again)
- [DO (Upgrade the gradle version to 6.8, if need)](#do-upgrade-the-gradle-version-to-68-if-need)
- [Develop REST Assured Testing for The Web App](#develop-rest-assured-testing-for-the-web-app)
  - [DO (add a new book controller testing file)](#do-add-a-new-book-controller-testing-file)
  - [DO (start the web app)](#do-start-the-web-app)
  - [DO (run the testing in the project with gradle)](#do-run-the-testing-in-the-project-with-gradle)
  - [DO (see the testing report)](#do-see-the-testing-report)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- `Rest Assured` `Web Application` REST API Testing
- `Java JDK` `IntelliJ CE` CircleCI CI
- tutorial example Ubuntu Gradle jabba JDK Java JVM
- `Spring Boot` database Console DataSource




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)




## Create A New Java Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=216 && NEW_APP_ID=218 \
&& git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

### DO (check the project)
```bash
./gradlew -q clean check
```
```bash
    # >> Result:nothing
```




## Develop the gradle build file

### DO (add the package `rest-assured` to the gradle build file)
```bash
nano ./build.gradle
```
```sql
-- FILE (build.gradle)
...
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'io.rest-assured:rest-assured'
}
```

### DO (check the project to get the error)
```bash
./gradlew -q clean check
```
```bash
    # >> Result
    Errors occurred while build effective model from /home/gudao/.gradle/caches/modules-2/files-2.1/com.sun.xml.bind/jaxb-osgi/2.2.10/c926a537af564ec047ec6308df1d0d2a03364a86/jaxb-osgi-2.2.10.pom:
        'dependencyManagement.dependencies.dependency.systemPath' for com.sun:tools:jar must specify an absolute path but is ${tools.jar} in com.sun.xml.bind:jaxb-osgi:2.2.10
    WARNING: An illegal reflective access operation has occurred
    WARNING: Illegal reflective access by org.codehaus.groovy.reflection.CachedClass (file:/home/gudao/.gradle/caches/modules-2/files-2.1/org.codehaus.groovy/groovy/2.5.14/f0a005fb21e7bd9b7ebf04cd2ecda0fc8f3be59d/groovy-2.5.14.jar) to method java.lang.Object.finalize()
    WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.reflection.CachedClass
    WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
    WARNING: All illegal access operations will be denied in a future release
```

### DO (edit a gradle build file for spring boot)
```bash
nano ./build.gradle
```
```sql
-- FILE (build.gradle)
...
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation('io.rest-assured:rest-assured') {
		exclude group: 'com.sun.xml.bind', module: 'jaxb-osgi'
	}
...
```

### DO (check the project again to get many warnings)

```bash
./gradlew -q check
```
```bash
    # >> Result
    WARNING: An illegal reflective access operation has occurred
    WARNING: Illegal reflective access by org.codehaus.groovy.reflection.CachedClass (file:/home/gudao/.gradle/caches/modules-2/files-2.1/org.codehaus.groovy/groovy/2.5.14/f0a005fb21e7bd9b7ebf04cd2ecda0fc8f3be59d/groovy-2.5.14.jar) to method java.lang.Object.finalize()
    WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.reflection.CachedClass
    WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
    WARNING: All illegal access operations will be denied in a future release
```

### DO (edit a gradle build file for spring boot again)
```bash
nano ./build.gradle
```
```sql
-- FILE (build.gradle)
...
	useJUnitPlatform()
	jvmArgs("--illegal-access=deny")
...
```

### DO (check the project noch again)
```bash
./gradlew -q clean check
```
```bash
    # >> Result: nothing
```




## DO (Upgrade the gradle version to 6.8, if need)
```bash
./gradlew -q wrapper --gradle-version=6.8
```
```bash
    # >> Result: nothing
```




## Develop REST Assured Testing for The Web App

### DO (add a new book controller testing file)
```bash
touch ./src/test/java/de/iotoi/RestAssuredBookControllerTests.java
```
```bash
nano ./src/test/java/de/iotoi/RestAssuredBookControllerTests.java
```
```java
// FILE (RestAssuredBookControllerTests.java)
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
```

### DO (start the web app)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    <==========---> 83% EXECUTING [10s]
    > :bootRun
```

### DO (run the testing in the project with gradle)
```bash
./gradlew -q clean test --tests de.iotoi.RestAssuredBookControllerTests
```
```bash
    # >> Result: nothing
```

### DO (see the testing report)
```bash
google-chrome ./build/reports/tests/test/index.html
```
![result_testing](doc/image/testing-result.png)




## References
- https://rest-assured.io/
- https://github.com/rest-assured/rest-assured/wiki/GettingStarted
- https://docs.gradle.org/current/userguide/building_java_projects.html
- https://stackoverflow.com/questions/53790182/get-the-current-value-of-illegal-access-setting-in-java
- https://www.gitmemory.com/issue/spring-projects/spring-boot/22303/656792408
- https://backstage.forgerock.com/knowledge/kb/article/a15048811
- https://github.com/gradle/gradle/releases
- https://www.xspdf.com/resolution/58300460.html
- https://www.xspdf.com/resolution/52404548.html
- https://docs.microsoft.com/en-us/azure/developer/java/fundamentals/transition-from-java-8-to-java-11
- https://tools.ietf.org/html/rfc7231#section-6.5.1




## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)
