<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_205.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_205)



---

Lesson 205: Hello @Service!
<h1>Lesson 205: Hello @Service!</h1>

- How to Understand the Annotation @Service


---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project)
- [Develop the Project](#develop-the-project)
  - [DO (create and edit the spring service file)](#do-create-and-edit-the-spring-service-file)
  - [DO (edit the java rest controller file)](#do-edit-the-java-rest-controller-file)
  - [DO (check the project)](#do-check-the-project-1)
- [Start the Project](#start-the-project)
  - [DO (open a new terminal to start HotCode)](#do-open-a-new-terminal-to-start-hotcode)
  - [DO (open a new terminal to run the web application)](#do-open-a-new-terminal-to-run-the-web-application)
  - [DO (open a new terminal to access the web application)](#do-open-a-new-terminal-to-access-the-web-application)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- `Spring Boot` Annotation `@Service`
- `Java JDK` `IntelliJ CE` CircleCI CI
- tutorial example Ubuntu Gradle jabba JDK Java JVM
- `Spring Boot` `web app` web app




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create A New Java Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=204 && NEW_APP_ID=205 \
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
web.app.name=Hello @Service
logging.level.root=WARN
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```



## Develop the Project

### DO (create and edit the spring service file)
```bash
touch ./src/main/java/de/iotoi/HelloService.java
```
```bash
nano ./src/main/java/de/iotoi/HelloService.java
```
```bash
# FILE (HelloService.java)
package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service()
public class HelloService {
    @Value("${web.app.name}")
    String webAppName;

    public String getHello() {
        System.out.println(webAppName);
        return webAppName + "!!\n";
    }
}
```

### DO (edit the java rest controller file)
```bash
nano ./src/main/java/de/iotoi/JavaApplication.java
```
```bash
# FILE (JavaApplication.java)
...
    @Value(PropertyValues.WEB_APP_NAME)
    String webAppName;

    private HelloService helloService;
    HelloRestController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/api/value")
    public String helloJavaValue() {
        return webAppName + "!\n";
    }

    @RequestMapping("/api/service")
    public String helloJavaService() {
        return helloService.getHello();
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




## Start the Project

### DO (open a new terminal to start HotCode)
```bash
./gradlew -q bootJar --continuous
```

### DO (open a new terminal to run the web application)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    Hello @Service from init()!
    Hello @Service from init()!!
    <==========---> 80% EXECUTING [49s]
    > :bootRun
```

### DO (open a new terminal to access the web application)
```bash
curl --no-progress-meter http://localhost:8080/api/value
```
```bash
    # >>> Result
    Hello @Service!
```

```bash
curl --no-progress-meter http://localhost:8080/api/service
```
```bash
    # >>> Result
    Hello @Service!!
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