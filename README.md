<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_220.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_220)



---

Lesson 220: Hello @Configuration and @PropertySource!
<h1>Lesson 220: Hello @Configuration and @PropertySource!</h1>

- How to Understand An Annotation @Configuration and @PropertySource
- How to Add A New Custom Property File


---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the application property file)](#do-edit-the-application-property-file)
  - [DO (check the project)](#do-check-the-project)
- [Implement the Annotation `@Configuration` and `@PropertySource` in the Web App](#implement-the-annotation-configuration-and-propertysource-in-the-web-app)
  - [DO (add a new property file)](#do-add-a-new-property-file)
  - [DO (add a new java class property file)](#do-add-a-new-java-class-property-file)
  - [DO (add a new java class configuration file)](#do-add-a-new-java-class-configuration-file)
  - [DO (check the project)](#do-check-the-project-1)
- [Apply the Annotation `@Configuration` and `@PropertySource` in the Web App](#apply-the-annotation-configuration-and-propertysource-in-the-web-app)
  - [DO (edit the java class controller file)](#do-edit-the-java-class-controller-file)
  - [DO (check the project)](#do-check-the-project-2)
- [View The Result for the web app](#view-the-result-for-the-web-app)
  - [DO (run The Application with Gradle)](#do-run-the-application-with-gradle)
  - [DO (access the web rest api)](#do-access-the-web-rest-api)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- Annotation `@Configuration` `@PropertySource` `Property File`
- Annotation `@Value` `Spring Boot` `web app` web app
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
EXISTING_APP_ID=204 && NEW_APP_ID=220 \
&& git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

### DO (edit the application property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (hello.properties)
...
web.app.name=Hello @Configuration and @PropertySource
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Implement the Annotation `@Configuration` and `@PropertySource` in the Web App

### DO (add a new property file)
```bash
touch ./src/main/resources/hello.properties
```
```bash
nano ./src/main/resources/hello.properties
```
```bash
# FILE (hello.properties)
hello.api = /api
```

### DO (add a new java class property file)
```bash
touch ./src/main/java/de/iotoi/HelloPropertyValues.java
```
```bash
nano ./src/main/java/de/iotoi/HelloPropertyValues.java
```
```java
// FILE (HelloPropertyValues.java)
package de.iotoi;

public final class HelloPropertyValues {
    public static final String HELLO_API = "${hello.api}";
}
```

### DO (add a new java class configuration file)
```bash
touch ./src/main/java/de/iotoi/HelloConfiguration.java
```
```bash
nano ./src/main/java/de/iotoi/HelloConfiguration.java
```
```java
// FILE (HelloConfiguration.java)
package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:/hello.properties")
public class HelloConfiguration {}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Apply the Annotation `@Configuration` and `@PropertySource` in the Web App

### DO (edit the java class controller file)
```bash
nano ./src/main/java/de/iotoi/HelloRestController.java
```
```java
# FILE (HelloRestController.java)
...
    @RequestMapping(HelloPropertyValues.HELLO_API)
    public String helloJava() {
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## View The Result for the web app

### DO (run The Application with Gradle)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    Hello @Configuration and @PropertySource from init()!
    Hello @Configuration and @PropertySource from init()!!
    <==========---> 83% EXECUTING [13s]
    > :bootRun
```

### DO (access the web rest api)
```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello @Configuration and @PropertySource!!!
```




## References
- https://stackoverflow.com/questions/54937518/visual-studio-code-spring-boot-reload-static-content/55370810
- https://mkyong.com/spring-boot/intellij-idea-spring-boot-template-reload-is-not-working/
- https://gist.github.com/IMRFeng/eed589de6a6362ef23bc189fb135fdea
- https://www.vojtechruzicka.com/spring-boot-devtools/
- https://stackoverflow.com/questions/33349456/how-to-make-auto-reload-with-spring-boot-on-idea-intellij
- https://stackoverflow.com/questions/54556072/hot-to-hotswap-code-in-intellij-in-a-spring-boot-project
- https://www.nexsoftsys.com/articles/hot-swapping-in-spring-boot-applications.html
- https://stackoverflow.com/questions/57408522/spring-boot-maven-not-printing-logs-on-console



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)