<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_211.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_211)


---

Lesson 211: Hello Seed Data!
<h1>Lesson 211: Hello Seed Data!</h1>

- How to Understand Database h2 with JPA/Hibernate/DataSource
- How to Understand Seed Data Import as Developmet Phase


---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (check the project)](#do-check-the-project)
- [Configure Hibernate as Seed Data Import](#configure-hibernate-as-seed-data-import)
  - [DO (add a seed hibernate data file)](#do-add-a-seed-hibernate-data-file)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project-1)
- [Use Hibernate as Seed Data Import](#use-hibernate-as-seed-data-import)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle)
  - [DO (access the web application api)](#do-access-the-web-application-api)
  - [DO (stop the web server)](#do-stop-the-web-server)
  - [DO (delete h2 database)](#do-delete-h2-database)
- [Configure DataSource as Seed Data Import](#configure-datasource-as-seed-data-import)
  - [DO (add a seed datasource data file)](#do-add-a-seed-datasource-data-file)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file-1)
  - [DO (check the project)](#do-check-the-project-2)
- [Use DataSource as Seed Data Import](#use-datasource-as-seed-data-import)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle-1)
  - [DO (access the web application api)](#do-access-the-web-application-api-1)
  - [DO (stop the web server)](#do-stop-the-web-server-1)
  - [DO (delete h2 database)](#do-delete-h2-database-1)
- [Configure DataSource and Hibernate as Seed Data Import](#configure-datasource-and-hibernate-as-seed-data-import)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file-2)
  - [DO (check the project)](#do-check-the-project-3)
- [Use DataSource and Hibernate as Seed Data Import](#use-datasource-and-hibernate-as-seed-data-import)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle-2)
  - [DO (access the web application api)](#do-access-the-web-application-api-2)
  - [DO (stop the web server)](#do-stop-the-web-server-2)
  - [DO (delete h2 database)](#do-delete-h2-database-2)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- - `Spring Boot` `Web Application` REST API h2 JPA Hibernate DataSource
- `Java JDK` `IntelliJ CE` CircleCI CI
- tutorial example Ubuntu Gradle jabba JDK Java JVM
- `Spring Boot` `Web Application` database Console




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)




## Create A New Java Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=210 && NEW_APP_ID=211 \
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




## Configure Hibernate as Seed Data Import

### DO (add a seed hibernate data file)
```bash
mkdir ./src/main/resources/seed
```
```bash
touch ./src/main/resources/seed/data_hibernate.sql
```
```bash
nano ./src/main/resources/seed/data_hibernate.sql
```
```bash
# FILE (data_hibernate.sql)
INSERT INTO book(id, title, author) VALUES (1, 'Kotlin 211A', 'Jeo');
INSERT INTO book(id, title, author) VALUES (2, 'Rust 211A', 'Leo');
```

### DO (edit the spring property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
# JPA (JpaBaseConfiguration)
spring.jpa.database-platform = org.hibernate.dialect.H2Dialect
spring.jpa.open-in-view = true

# JPA (HibernateJpaAutoConfiguration)
spring.jpa.hibernate.ddl-auto = create-drop
spring.jpa.properties.hibernate.hbm2ddl.import_files = ./seed/data_hibernate.sql
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Use Hibernate as Seed Data Import

### DO (run the web application with gradle)
- All records will be deleted after every spring boot start.

```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # Result
    [
       {
          "author" : "Jeo",
          "id" : 1,
          "title" : "Kotlin 211A"
       },
       {
          "author" : "Leo",
          "id" : 2,
          "title" : "Rust 211A"
       }
    ]
```

### DO (stop the web server)
```bash
# !!! (Ctrl+C)
```

### DO (delete h2 database)
```bash
rm database/development.*
```



## Configure DataSource as Seed Data Import

### DO (add a seed datasource data file)
```bash
touch ./src/main/resources/seed/data_datasource.sql
```
```bash
nano ./src/main/resources/seed/data_datasource.sql
```
```bash
# FILE (data_datasource.sql)
INSERT INTO book(id, title, author) VALUES (3, 'Java 211B', 'Jeo');
INSERT INTO book(id, title, author) VALUES (4, 'Ruby 211B', 'Leo');
```

### DO (edit the spring property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
spring.datasource.initialization-mode=always
spring.datasource.data=classpath*:seed/data_datasource.sql

# JPA (JpaBaseConfiguration)
spring.jpa.database-platform = org.hibernate.dialect.H2Dialect
spring.jpa.open-in-view = true

# JPA (HibernateJpaAutoConfiguration)
spring.jpa.hibernate.ddl-auto = create-drop
#spring.jpa.properties.hibernate.hbm2ddl.import_files = ./seed/data_hibernate.sql
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Use DataSource as Seed Data Import

### DO (run the web application with gradle)
- All records will be deleted after every spring boot start.

```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # Result
    [
      {
          "author" : "Jeo",
          "id" : 3,
          "title" : "Java 211B"
      },
      {
          "author" : "Leo",
          "id" : 4,
          "title" : "Ruby 211B"
      }
    ]
```

### DO (stop the web server)
```bash
# !!! (Ctrl+C)
```

### DO (delete h2 database)
```bash
rm database/development.*
```




## Configure DataSource and Hibernate as Seed Data Import

### DO (edit the spring property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
spring.datasource.initialization-mode=always
spring.datasource.data=classpath*:seed/data_datasource.sql

# JPA (JpaBaseConfiguration)
spring.jpa.database-platform = org.hibernate.dialect.H2Dialect
spring.jpa.open-in-view = true

# JPA (HibernateJpaAutoConfiguration)
spring.jpa.hibernate.ddl-auto = create-drop
spring.jpa.properties.hibernate.hbm2ddl.import_files = ./seed/data_hibernate.sql
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Use DataSource and Hibernate as Seed Data Import

### DO (run the web application with gradle)
- All records will be deleted after every spring boot start.

```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # Result
    [
       {
          "author" : "Jeo",
          "id" : 1,
          "title" : "Kotlin 211A"
       },
       {
          "author" : "Leo",
          "id" : 2,
          "title" : "Rust 211A"
       },
       {
          "author" : "Jeo",
          "id" : 3,
          "title" : "Java 211B"
       },
       {
          "author" : "Leo",
          "id" : 4,
          "title" : "Ruby 211B"
       }
    ]
```

### DO (stop the web server)
```bash
# !!! (Ctrl+C)
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




## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)
