<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_209.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_209)


---

Lesson 209: Hello @Entity!
<h1>Lesson 209: Hello @Entity!</h1>

- How to Understand the Annotation @Entity!

---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project)
- [Develop the Java Project](#develop-the-java-project)
  - [DO (create and edit the spring model file)](#do-create-and-edit-the-spring-model-file)
  - [DO (create and edit the spring model repository file)](#do-create-and-edit-the-spring-model-repository-file)
  - [DO (create and edit the spring model repository file)](#do-create-and-edit-the-spring-model-repository-file-1)
- [Run The Web Application on the Project](#run-the-web-application-on-the-project)
  - [DO (run The Web Application with Gradle)](#do-run-the-web-application-with-gradle)
  - [DO (show all records)](#do-show-all-records)
  - [DO (insert a new record)](#do-insert-a-new-record)
  - [DO (update the record by id)](#do-update-the-record-by-id)
  - [DO (show a record by id)](#do-show-a-record-by-id)
  - [DO (show a record by title)](#do-show-a-record-by-title)
  - [DO (delete a record by id)](#do-delete-a-record-by-id)
  - [DO (show all records)](#do-show-all-records-1)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- Annotation @Entity `Spring Boot` `Web Application` h2 REST API
- `Java JDK` `IntelliJ CE` CircleCI CI
- tutorial example Ubuntu Gradle jabba JDK Java JVM




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)




## Create A New Java Web App

### DO (create a new project)
```bash
NEW_APP_ID=209 && \
mkdir ${NEW_APP_ID}_gradle_java && cd ${NEW_APP_ID}_gradle_java && \
curl https://start.spring.io/starter.zip -d language=java \
  -d dependencies=web,devtools,jpa,h2 \
  -d packageName=de.iotoi \
  -d groupId=de.iotoi \
  -d artifactId=_gradle_java \
  -d name=java -d type=gradle-project -o basic_${NEW_APP_ID}.zip && \
unzip basic_${NEW_APP_ID}.zip
```

### DO (edit the spring property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
spring.main.banner-mode=off
spring.main.log-startup-info=off
web.app.name=Hello @Entity
logging.level.root=WARN

# JPA (JpaBaseConfiguration)
spring.jpa.open-in-view = true
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Develop the Java Project

### DO (create and edit the spring model file)
```bash
mkdir -p src/main/java/de/iotoi/model
```
```bash
touch ./src/main/java/de/iotoi/model/Book.java
```
```bash
nano ./src/main/java/de/iotoi/model/Book.java
```
```bash
# FILE (Book.java)
package de.iotoi.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;

    public Book() {
        super();
    }

    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (id != other.id)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }
}
```

### DO (create and edit the spring model repository file)
```bash
touch ./src/main/java/de/iotoi/model/BookRepository.java
```
```bash
nano ./src/main/java/de/iotoi/model/BookRepository.java
```
```bash
# FILE (BookRepository.java)
package de.iotoi.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
```

### DO (create and edit the spring model repository file)
```bash
touch ./src/main/java/de/iotoi/BookRestController.java
```
```bash
nano ./src/main/java/de/iotoi/BookRestController.java
```
```bash
# FILE (BookRestController.java)
package de.iotoi;

import de.iotoi.model.Book;
import de.iotoi.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book requestBook, @PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        book.setTitle(requestBook.getTitle());
        book.setAuthor(requestBook.getAuthor());

        return bookRepository.save(book);
    }
}
```




## Run The Web Application on the Project

### DO (run The Web Application with Gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (show all records)
```bash
curl --no-progress-meter localhost:8080/api/books | json_pp
```
```bash
    # Result
    []
```

### DO (insert a new record)
```bash
curl --no-progress-meter \
    -H "Content-Type: application/json" \
    -X POST -d '{"title":"Java","author":"Joe"}' \
    localhost:8080/api/books | json_pp
```
```bash
    # Result
    {
        "author" : "Joe",
        "id" : 1,
        "title" : "Java"
    }
```

### DO (update the record by id)
```bash
curl --no-progress-meter \
    -H "Content-Type: application/json" \
    -X PUT -d '{"title":"Rust","author":"Leo"}' \
    localhost:8080/api/books/1 | json_pp
```
```bash
    # Result
    {
        "author" : "Leo",
        "id" : 1,
        "title" : "Rust"
    }
```

### DO (show a record by id)
```bash
curl --no-progress-meter localhost:8080/api/books/1 | json_pp
```
```bash
    # Result
    {
        "author" : "Leo",
        "id" : 1,
        "title" : "Rust"
    }
```

### DO (show a record by title)
```bash
curl --no-progress-meter localhost:8080/api/books/title/Rust | json_pp
```
```bash
    # Result
    {
        "author" : "Leo",
        "id" : 1,
        "title" : "Rust"
    }
```

### DO (delete a record by id)
```bash
curl --no-progress-meter -X DELETE localhost:8080/api/books/1
```
```bash
    # Result: nothing
```

### DO (show all records)
```bash
curl --no-progress-meter localhost:8080/api/books | json_pp
```
```bash
    # Result
    []
```




## References
- https://www.baeldung.com/kotlin/kotlin-jpa




## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)