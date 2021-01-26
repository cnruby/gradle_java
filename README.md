<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_221.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_221)



---

Lesson 221: Hello @Configuration and @Bean!
<h1>Lesson 221: Hello @Configuration and @Bean!</h1>

- How to Understand An Annotation @Configuration and @PropertySouBeanrce
- How to Add A New Service


---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the application property file)](#do-edit-the-application-property-file)
  - [DO (edit the hello property file)](#do-edit-the-hello-property-file)
  - [DO (edit the hello property class file)](#do-edit-the-hello-property-class-file)
  - [DO (check the project)](#do-check-the-project)
- [Implement the Annotation `@Configuration` and `@Bean` in the Web App](#implement-the-annotation-configuration-and-bean-in-the-web-app)
  - [DO (add a new java interface file)](#do-add-a-new-java-interface-file)
  - [DO (add a new java implementation file)](#do-add-a-new-java-implementation-file)
  - [DO (add a new java class configuration file)](#do-add-a-new-java-class-configuration-file)
  - [DO (check the project)](#do-check-the-project-1)
- [Apply the Annotation `@Configuration` and `@Bean` in the Web App](#apply-the-annotation-configuration-and-bean-in-the-web-app)
  - [DO (edit the java class rest controller file)](#do-edit-the-java-class-rest-controller-file)
  - [DO (check the project)](#do-check-the-project-2)
- [View The Result for the web app](#view-the-result-for-the-web-app)
  - [DO (run The Application with Gradle)](#do-run-the-application-with-gradle)
  - [DO (access the web rest api with url `/api`)](#do-access-the-web-rest-api-with-url-api)
  - [DO (access the web rest api with url `/`)](#do-access-the-web-rest-api-with-url-)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- Annotation `@Configuration` `@Bean` `Spring Service`
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
EXISTING_APP_ID=220 && NEW_APP_ID=221 \
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
web.app.name=Hello @Configuration and @Bean in the file application.properties
...
```

### DO (edit the hello property file)
```bash
nano ./src/main/resources/hello.properties
```
```bash
# FILE (hello.properties)
...
web.app.name = Hello @Configuration and @Bean in the file hello.properties
...
```

### DO (edit the hello property class file)
```bash
nano ./src/main/java/de/iotoi/HelloPropertyValues.java
```
```bash
# FILE (HelloPropertyValues.java)
...
    public static final String WEB_APP_NAME = "${web.app.name}";
}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Implement the Annotation `@Configuration` and `@Bean` in the Web App

### DO (add a new java interface file)
```bash
mkdir -p ./src/main/java/de/iotoi/impl
```
```bash
touch ./src/main/java/de/iotoi/impl/HelloServiceable.java
```
```bash
nano ./src/main/java/de/iotoi/impl/HelloServiceable.java
```
```java
# FILE (HelloServiceable.java)
package de.iotoi.impl;

public interface HelloServiceable {
    public String getHello();
}
```

### DO (add a new java implementation file)
```bash
touch ./src/main/java/de/iotoi/impl/HelloService.java
```
```bash
nano ./src/main/java/de/iotoi/impl/HelloService.java
```
```java
# FILE (HelloService.java)
package de.iotoi.impl;

import de.iotoi.HelloPropertyValues;
import de.iotoi.PropertyValues;
import org.springframework.beans.factory.annotation.Value;

public class HelloService implements HelloServiceable {
    @Value(HelloPropertyValues.WEB_APP_NAME)
    private String webAppName;

    @Override
    public String getHello() {
      return webAppName + "!\n";
    }
}
```

### DO (add a new java class configuration file)
```bash
nano ./src/main/java/de/iotoi/HelloConfiguration.java
```
```java
// FILE (HelloConfiguration.java)
...
import de.iotoi.impl.HelloService;
import org.springframework.context.annotation.Bean;
...
    @Bean()
    public HelloService getHelloServiceObject() {
        return new HelloService();
    }
}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Apply the Annotation `@Configuration` and `@Bean` in the Web App

### DO (edit the java class rest controller file)
```bash
nano ./src/main/java/de/iotoi/HelloRestController.java
```
```java
# FILE (HelloRestController.java)
...
import de.iotoi.impl.HelloServiceable;
import de.iotoi.impl.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
...
    @RequestMapping("/")
    public String helloServiceKotlin() {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfiguration.class);
        HelloService objHelloService = (HelloService) context.getBean(HelloServiceable.class);

        return objHelloService.getHello();
    }
}
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
    Hello @Configuration and @Bean in the file application.properties from init()!
    Hello @Configuration and @Bean in the file application.properties from init()!!
    <==========---> 83% EXECUTING [13s]
    > :bootRun
```

### DO (access the web rest api with url `/api`)
```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello @Configuration and @Bean in the file application.properties!
```

### DO (access the web rest api with url `/`)
```bash
curl http://localhost:8080/
```
```bash
    # >> Result
    Hello @Configuration and @Bean in the file hello.properties!
```




## References
- https://zetcode.com/springboot/applicationcontext/
- https://www.baeldung.com/spring-application-context
- https://blog.frankel.ch/flavors-spring-application-context-configuration/
- 



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)