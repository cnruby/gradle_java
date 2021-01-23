<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_208.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_208)



---

Lesson 208: Hello @Autowired!
<h1>Lesson 208: Hello @Autowired!</h1>

- How to Understand the Annotation @Autowired
- How to Understand the REST Controller with the Annotation @Autowired


---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project)
- [Develop the Project](#develop-the-project)
  - [DO (edit the spring rest controller file)](#do-edit-the-spring-rest-controller-file)
  - [DO (check the project)](#do-check-the-project-1)
- [Start the Project](#start-the-project)
  - [DO (open a new terminal to start HotCode)](#do-open-a-new-terminal-to-start-hotcode)
  - [DO (open a new terminal to run the web application)](#do-open-a-new-terminal-to-run-the-web-application)
  - [DO (open a new terminal to access the web application)](#do-open-a-new-terminal-to-access-the-web-application)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- Annotation `@Component` Java Web Application 
- `Java JDK` `IntelliJ CE` CircleCI CI
- tutorial example Ubuntu Gradle jabba JDK Java JVM
- `Spring Boot` `web app` web app `@Service` Thymeleaf Template Web Page




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)




## Create A New Java Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=207 && NEW_APP_ID=208 \
&& git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

### DO (edit the spring property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
web.app.name=Hello @Autowired
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```



## Develop the Project 

### DO (edit the spring rest controller file)
```bash
nano ./src/main/java/de/iotoi/HelloRestController.java
```
```java
// FILE (HelloRestController.java)
...
    @Autowired
    private HelloService helloService;
    @Autowired
    private HelloComponent helloComponent;

    @RequestMapping("/api/value")
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Start the Project

### DO (open a new terminal to start HotCode)
```bash
./gradlew -q bootJar --continuous
```
```bash
    # >> Result
    Waiting for changes to input files of tasks... (ctrl-d to exit)
    <=============> 100% EXECUTING [12s]
    > IDLE
```

### DO (open a new terminal to run the web application)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    Hello @Autowired from init()!
    Hello @Autowired from init()!!
    Hello @Autowired!!
    
    Hello @Autowired from class HelloComponent!
```

### DO (open a new terminal to access the web application)
```bash
 curl --no-progress-meter http://localhost:8080/api/component
```
```bash
    # >> Result
    Hello @Autowired from class HelloComponent!
```




## References
- https://javalang.org/docs/reference/interfaces.html
- https://www.baeldung.com/java/java-interfaces
- https://www.baeldung.com/spring-component-repository-service
- https://www.javaguides.net/2018/11/spring-component-annotation-example.html
- https://www.baeldung.com/spring-bean-annotations
- https://www.baeldung.com/spring-application-context




## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)