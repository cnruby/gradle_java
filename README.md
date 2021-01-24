<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_215.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_215)


---

Lesson 215: Hello Database Platform!
<h1>Lesson 215: Hello Database Platform!</h1>

- How to Understand The Database Platform By Database System H2 and PostgreSQL



---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (check the project)](#do-check-the-project)
- [Develop The Spring Web App Property Files with H2 and PostgreSQL](#develop-the-spring-web-app-property-files-with-h2-and-postgresql)
  - [DO (add a new application properties file for H2)](#do-add-a-new-application-properties-file-for-h2)
  - [DO (rename and edit the application properties file for PostgreSQL)](#do-rename-and-edit-the-application-properties-file-for-postgresql)
  - [DO (add a new application properties file for all)](#do-add-a-new-application-properties-file-for-all)
- [Develop The Spring Web App DataSource Files for H2](#develop-the-spring-web-app-datasource-files-for-h2)
  - [DO (add a new schema file for h2 datasource)](#do-add-a-new-schema-file-for-h2-datasource)
  - [DO (add a new data file for h2 datasource)](#do-add-a-new-data-file-for-h2-datasource)
- [Develop The Spring Web App DataSource Files for PostgreSQL](#develop-the-spring-web-app-datasource-files-for-postgresql)
  - [DO (rename and edit a schema file for PostgreSQL datasource)](#do-rename-and-edit-a-schema-file-for-postgresql-datasource)
  - [DO (rename and edit a data file for PostgreSQL datasource)](#do-rename-and-edit-a-data-file-for-postgresql-datasource)
- [Run the Spring Web Application with H2](#run-the-spring-web-application-with-h2)
  - [DO (check the project)](#do-check-the-project-1)
  - [DO (run the web application for h2)](#do-run-the-web-application-for-h2)
  - [DO (access the web application api)](#do-access-the-web-application-api)
  - [DO (stop the web server)](#do-stop-the-web-server)
- [Run the Spring Web Application with PostgreSQL](#run-the-spring-web-application-with-postgresql)
  - [DO (delete PostgreSQL database, if the database `prodDB` exists)](#do-delete-postgresql-database-if-the-database-proddb-exists)
  - [DO (add a new PostgreSQL database `prodDB` for user `gudao`)](#do-add-a-new-postgresql-database-proddb-for-user-gudao)
  - [DO (run the web application for PostgreSQL)](#do-run-the-web-application-for-postgresql)
  - [DO (access the web application api)](#do-access-the-web-application-api-1)
  - [DO (stop the web server)](#do-stop-the-web-server-1)
  - [DO (delete PostgreSQL database, if need)](#do-delete-postgresql-database-if-need)
- [Map for JPA/Hibernate/Spring DataSource](#map-for-jpahibernatespring-datasource)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- `Database Platform` H2 PostgreSQL `Spring DataSource` `Web Application` database
- `Java JDK` `IntelliJ CE` CircleCI CI
- tutorial example Ubuntu Gradle jabba JDK Java JVM
- h2 Console `Spring Boot` REST API h2 JPA Hibernate Classpath




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)
- [install Database postgreSQL](https://github.com/cnruby/gradle_kotlin/tree/basic_001)




## Create A New Java Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=214 && NEW_APP_ID=215 \
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




## Develop The Spring Web App Property Files with H2 and PostgreSQL

### DO (add a new application properties file for H2)
```bash
touch ./src/main/resources/application-dev.properties
```
```bash
nano ./src/main/resources/application-dev.properties
```
```bash
# FILE (application-dev.properties)
# DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.url = jdbc:h2:file:./database/development;AUTO_SERVER=TRUE
spring.datasource.platform=h2

spring.datasource.initialization-mode=always
spring.datasource.schema=classpath*:schema-h2.sql
spring.datasource.data=classpath*:data-h2.sql

# JPA (JpaBaseConfiguration)
spring.jpa.database-platform = org.hibernate.dialect.H2Dialect
```

### DO (rename and edit the application properties file for PostgreSQL)
```bash
mv ./src/main/resources/application.properties ./src/main/resources/application-prod.properties
```
```bash
nano ./src/main/resources/application-prod.properties
```
```bash
# FILE (application-prod.properties)
# DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=s$cret
spring.datasource.url = jdbc:postgresql://localhost:5432/prodDB
spring.datasource.platform = postgres

spring.datasource.initialization-mode=always
spring.datasource.schema=classpath*:schema-postgres.sql
spring.datasource.data=classpath*:data-postgres.sql

# JPA (JpaBaseConfiguration)
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

### DO (add a new application properties file for all)
```bash
touch ./src/main/resources/application.properties
```
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
spring.main.banner-mode=off
spring.main.log-startup-info=off
web.app.name=Hello Database Platform
logging.level.root=WARN

# JPA (JpaBaseConfiguration)
spring.jpa.show-sql = true
spring.jpa.open-in-view = true

# Hibernate (HibernateJpaAutoConfiguration)
spring.jpa.properties.hibernate.format_sql = true
spring.jpa.hibernate.ddl-auto = none
```




## Develop The Spring Web App DataSource Files for H2

### DO (add a new schema file for h2 datasource)
```bash
touch ./src/main/resources/schema-h2.sql
```
```bash
nano ./src/main/resources/schema-h2.sql
```
```sql
-- FILE (schema-h2.sql)
DROP TABLE IF EXISTS books;

CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250),
  created TIMESTAMP(9) DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO books(title, author) VALUES ('Ruby', 'Leo 215A');
INSERT INTO books(title, author) VALUES ('HTML', 'Jeo 215A');
```

### DO (add a new data file for h2 datasource)
```bash
touch ./src/main/resources/data-h2.sql
```
```bash
nano ./src/main/resources/data-h2.sql
```
```sql
-- FILE (data-h2.sql)
INSERT INTO books(title, author) VALUES ('Kotlin', 'Thomas 215A');
INSERT INTO books(title, author) VALUES ('CSS', 'Thomas 215A');
```




## Develop The Spring Web App DataSource Files for PostgreSQL

### DO (rename and edit a schema file for PostgreSQL datasource)
```bash
mv ./src/main/resources/schema.sql ./src/main/resources/schema-postgres.sql
```
```sql
-- FILE (schema-postgres.sql)
DROP TABLE IF EXISTS books;

DROP SEQUENCE IF EXISTS native;
CREATE SEQUENCE native START 5;

CREATE TABLE books (
  id serial PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250)
);

INSERT INTO books(title, author) VALUES ('Ruby', 'Leo 215B');
INSERT INTO books(title, author) VALUES ('HTML', 'Jeo 215B');
```

### DO (rename and edit a data file for PostgreSQL datasource)
```bash
mv ./src/main/resources/data.sql ./src/main/resources/data-postgres.sql
```
```sql
-- FILE (data-postgres.sql)
INSERT INTO books(title, author) VALUES ('Kotlin', 'Thomas 215B');
INSERT INTO books(title, author) VALUES ('CSS', 'Thomas 215B');
```




## Run the Spring Web Application with H2

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```

### DO (run the web application for h2)
```bash
./gradlew -q bootRun --args='--spring.profiles.active=dev'
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
            "author" : "Leo 215A",
            "id" : 1,
            "title" : "Ruby"
        },
        {
            "author" : "Jeo 215A",
            "id" : 2,
            "title" : "HTML"
        },
        {
            "author" : "Thomas 215A",
            "id" : 3,
            "title" : "Kotlin"
        },
        {
            "author" : "Thomas 215A",
            "id" : 4,
            "title" : "CSS"
        }
    ]
```

### DO (stop the web server)
```bash
# DO (Ctrl+C)
```




## Run the Spring Web Application with PostgreSQL

### DO (delete PostgreSQL database, if the database `prodDB` exists)
```bash
sudo -u postgres dropdb prodDB
```
```bash
    # >>> Result
    [sudo] password for gudao: <PASSWORD>
```

### DO (add a new PostgreSQL database `prodDB` for user `gudao`)
```bash
sudo -u postgres createdb prodDB -O gudao
```
```bash
    # >>> Result: nothing
```

### DO (run the web application for PostgreSQL)
```bash
./gradlew -q bootRun --args='--spring.profiles.active=prod'
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
            "author" : "Leo 215B",
            "id" : 1,
            "title" : "Ruby"
        },
        {
            "author" : "Jeo 215B",
            "id" : 2,
            "title" : "HTML"
        },
        {
            "author" : "Thomas 215B",
            "id" : 3,
            "title" : "Kotlin"
        },
        {
            "author" : "Thomas 215B",
            "id" : 4,
            "title" : "CSS"
        }
    ]
```

### DO (stop the web server)
```bash
# DO (Ctrl+C)
```

### DO (delete PostgreSQL database, if need)
```bash
sudo -u postgres dropdb prodDB
```




## Map for JPA/Hibernate/Spring DataSource
| Lesson Nr |	Lesson Title	|	Without schema file	| With schema file | With data file |
|---------|-------------|-------------|-------------|-------------|
| 210 | [Hello h2 Console!](https://github.com/cnruby/gradle_java/tree/basic_210) | JPA method |  |  |
| 211 | [Hello Seed Data!](https://github.com/cnruby/gradle_java/tree/basic_211#use-hibernate-as-seed-data-import) | with H2/path datasource/hibernate method |  | with H2/path datasource/hibernate method   |
| 211 | [Hello Seed Data!](https://github.com/cnruby/gradle_java/tree/basic_211#use-datasource-as-seed-data-import) | with H2/path datasource/spring method |  | with H2/path datasource/spring method   |
| 211 | [Hello Seed Data!](https://github.com/cnruby/gradle_java/tree/basic_211#use-datasource-and-hibernate-as-seed-data-import) | with H2/path datasource/hibernate+spring method |  | with H2/path datasource/hibernate+spring method   |
| 213 | [Spring Default DataSource!](https://github.com/cnruby/gradle_java/tree/basic_213#load-the-standard-sql-files-from-the-standard-root-classpath-locations) |  | with H2/spring method | with H2/spring method |
| 213 | [Spring Custom DataSource!](https://github.com/cnruby/gradle_java/tree/basic_213#loads-sql-files-from-the-custom-classpath-locations) |  | with H2/spring method | with H2/spring method |
| 214 | [Hello PostgreSQL with DataSource!](https://github.com/cnruby/gradle_java/tree/basic_214) |  | with PostgreSQL/default datasource/spring method | with PostgreSQL/default datasource/spring method |
| 215 | [Hello Database Platform!]() |  | with databas-platform | with databas-platform |




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
- https://medium.com/@omeryazir/create-a-spring-boot-application-postgresql-spring-security-499488c30beb
- https://docs.spring.io/spring-boot/docs/2.1.0.M1/reference/html/howto-database-initialization.html




## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)
