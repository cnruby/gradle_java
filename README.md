<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_213.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_213)


---

Lesson 213: Hello Spring DataSource!
<h1>Lesson 213: Hello Spring DataSource!</h1>

- How to Understand The Database h2 with Spring DataSource
- Use Spring DataSource to Create Tables and Records
- Table `BOOK` and all records will be deleted after every spring boot start 



---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (check the project)](#do-check-the-project)
  - [DO (delete h2 database)](#do-delete-h2-database)
- [Loads SQL Files From The Custom Classpath Locations](#loads-sql-files-from-the-custom-classpath-locations)
  - [DO (edit the application properties file for spring)](#do-edit-the-application-properties-file-for-spring)
  - [DO (edit a schema file for datasource)](#do-edit-a-schema-file-for-datasource)
  - [DO (edit a data file for datasource)](#do-edit-a-data-file-for-datasource)
  - [DO (check the project)](#do-check-the-project-1)
  - [DO (delete h2 database)](#do-delete-h2-database-1)
- [Use SQL Files From The Custom Classpath Locations](#use-sql-files-from-the-custom-classpath-locations)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle)
  - [DO (access the web application api)](#do-access-the-web-application-api)
  - [DO (add a new record to the web application api)](#do-add-a-new-record-to-the-web-application-api)
  - [DO (access the web application api again)](#do-access-the-web-application-api-again)
  - [DO (stop the web server)](#do-stop-the-web-server)
  - [DO (delete h2 database)](#do-delete-h2-database-2)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle-1)
  - [DO (access the web application api)](#do-access-the-web-application-api-1)
  - [DO (view the h2 Console)](#do-view-the-h2-console)
  - [DO (stop the web server)](#do-stop-the-web-server-1)
  - [DO (delete h2 database)](#do-delete-h2-database-3)
- [Load The Standard SQL Files From The Standard Root Classpath Locations](#load-the-standard-sql-files-from-the-standard-root-classpath-locations)
  - [DO (edit the application properties file for spring)](#do-edit-the-application-properties-file-for-spring-1)
  - [DO (add a standard schema file for standard root classpath location)](#do-add-a-standard-schema-file-for-standard-root-classpath-location)
  - [DO (add a standard data file for standard root classpath location)](#do-add-a-standard-data-file-for-standard-root-classpath-location)
  - [DO (check the project)](#do-check-the-project-2)
  - [DO (delete h2 database)](#do-delete-h2-database-4)
- [Use The Standard SQL Files From The Standard Root Classpath Locations](#use-the-standard-sql-files-from-the-standard-root-classpath-locations)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle-2)
  - [DO (access the web application api)](#do-access-the-web-application-api-2)
  - [DO (stop the web server)](#do-stop-the-web-server-2)
  - [DO (delete h2 database)](#do-delete-h2-database-5)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- `Spring DataSource` `Web Application` REST API h2 JPA Hibernate Classpath
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
EXISTING_APP_ID=212 && NEW_APP_ID=213 \
&& git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```

### DO (delete h2 database)
```bash
rm database/development.*
```




## Loads SQL Files From The Custom Classpath Locations

### DO (edit the application properties file for spring)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
spring.datasource.url = jdbc:h2:file:./database/development

spring.datasource.initialization-mode=always
spring.datasource.schema=classpath*:db/schema.sql
spring.datasource.data=classpath*:db/data.sql

# JPA (JpaBaseConfiguration)
spring.jpa.database-platform = org.hibernate.dialect.H2Dialect
spring.jpa.show-sql = true
spring.jpa.open-in-view = true

# Hibernate (HibernateJpaAutoConfiguration)
spring.jpa.properties.hibernate.format_sql = true
spring.jpa.hibernate.ddl-auto = none
```

### DO (edit a schema file for datasource)
```bash
mkdir ./src/main/resources/db
```
```bash
touch ./src/main/resources/db/schema.sql
```
```bash
nano ./src/main/resources/db/schema.sql
```
```sql
-- FILE (schema.sql)
DROP TABLE IF EXISTS book;

CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250),
  created TIMESTAMP(9) DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO book(title, author) VALUES
  ('Ruby', 'Leo 213A');
```

### DO (edit a data file for datasource)
```bash
touch ./src/main/resources/db/data.sql
```
```bash
nano ./src/main/resources/db/data.sql
```
```sql
-- FILE (data.sql)
INSERT INTO book(title, author) VALUES ('Java', 'Thomas 213A');
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```

### DO (delete h2 database)
```bash
rm database/development.*
```




## Use SQL Files From The Custom Classpath Locations

### DO (run the web application with gradle)

```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # >> Result
    [
        {
            "author" : "Leo 213A",
            "id" : 1,
            "title" : "Ruby"
        },
        {
            "author" : "Thomas 213A",
            "id" : 2,
            "title" : "Java"
        }
    ]
```

### DO (add a new record to the web application api)
```bash
curl --no-progress-meter \
    -H "Content-Type: application/json" \
    -X POST -d '{"title":"Rust","author":"Joe 213A"}' \
    localhost:8080/api/books | json_pp
```
```bash
    # >> Result
    {
        "author" : "Joe 213A",
        "id" : 3,
        "title" : "Rust"
    }
```

### DO (access the web application api again)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # >> Result
    [
        {
            "author" : "Leo 213A",
            "id" : 1,
            "title" : "Ruby"
        },
        {
            "author" : "Thomas 213A",
            "id" : 2,
            "title" : "Java"
        },
        {
            "author" : "Joe 213A",
            "id" : 3,
            "title" : "Rust"
        }
    ]
```

### DO (stop the web server)
```bash
# DO (Ctrl+C)
```

### DO (delete h2 database)
```bash
rm database/development.*
```

### DO (run the web application with gradle)

```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # >> Result
    [
        {
            "author" : "Leo 213A",
            "id" : 1,
            "title" : "Ruby"
        },
        {
            "author" : "Thomas 213A",
            "id" : 2,
            "title" : "Java"
        }
    ]
```

### DO (view the h2 Console)
```bash
google-chrome http://localhost:8080/h2-console/
```
![h2_console](doc/image/h2_console.png)


### DO (stop the web server)
```bash
# DO (Ctrl+C)
```

### DO (delete h2 database)
```bash
rm database/development.*
```




## Load The Standard SQL Files From The Standard Root Classpath Locations
- The Standard SQL Schema Files is `schema.sql`
- - The Standard SQL Data Files is `data.sql`
- The Standard Root Classpath Locations is `./src/main/resources` here

### DO (edit the application properties file for spring)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
spring.datasource.initialization-mode=always
# spring.datasource.schema=classpath*:db/schema.sql
# spring.datasource.data=classpath*:db/data.sql
...
```

### DO (add a standard schema file for standard root classpath location)
```bash
touch ./src/main/resources/schema.sql
```
```bash
nano ./src/main/resources/schema.sql
```
```sql
-- FILE (schema.sql)
DROP TABLE IF EXISTS book;

CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250),
  created TIMESTAMP(9) DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO book(title, author) VALUES ('Ruby', 'Leo 213B');
```

### DO (add a standard data file for standard root classpath location)
```bash
touch ./src/main/resources/data.sql
```
```bash
nano ./src/main/resources/data.sql
```
```sql
-- FILE (data.sql)
INSERT INTO book(title, author) VALUES ('Java', 'Thomas 213B');
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```

### DO (delete h2 database)
```bash
rm database/development.*
```




## Use The Standard SQL Files From The Standard Root Classpath Locations

### DO (run the web application with gradle)

```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # >> Result
    [
        {
            "author" : "Leo 213B",
            "id" : 1,
            "title" : "Ruby"
        },
        {
            "author" : "Thomas 213B",
            "id" : 2,
            "title" : "Java"
        }
    ]
```

### DO (stop the web server)
```bash
# DO (Ctrl+C)
```

### DO (delete h2 database)
```bash
rm database/development.*
```




## References
- https://gist.github.com/memory-lovers/4132241df38456642ad888634caee5c6
- https://github.com/DeadLion/spring-boot-samples/blob/master/application.properties.md
- https://dzone.com/articles/run-the-rest-version-of-spring-petclinic-with-angu
- https://dimitr.im/loading-initial-data-with-spring
- https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/howto-database-initialization.html
- https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
- https://stackoverflow.com/questions/38040572/spring-boot-loading-initial-data
- https://docs.microsoft.com/de-de/azure/developer/java/spring-framework/configure-spring-data-jpa-with-azure-mysql
- https://www.xspdf.com/resolution/20463098.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html
- https://javabydeveloper.com/spring-boot-loading-initial-data/
- https://stackoverflow.com/questions/53464632/application-properties-to-application-yml-spring-boot
- https://github.com/cesarsicas/spring-blog
- https://github.com/spring-projects/spring-boot/issues/20920
- https://stackoverflow.com/questions/53922279/what-are-the-possible-values-of-spring-datasource-initialization-mode




## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)
