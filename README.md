<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_223.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_223)



---

Lesson 223: Hello @PostMapping and @RequestBody!
<h1>Lesson 223: Hello @PostMapping and @RequestBody!</h1>

- How to Understand the Annotation @PostMapping and @RequestBody!


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
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle)
  - [DO (access the web api with url `/api/str` or `/`)](#do-access-the-web-api-with-url-apistr-or-)
  - [DO (stop the web application with gradle)](#do-stop-the-web-application-with-gradle)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- Annotation `@PosMapping` `@RequestBody` `Spring Boot` POST
- `Java JDK` `IntelliJ CE` CircleCI CI
- tutorial example Ubuntu Gradle jabba JDK Java JVM
- `Spring Boot` `web app` web app Annotation `@Service` Liberary JSONObject json




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create A New Java Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=222 && NEW_APP_ID=223 \
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
web.app.name=Hello @PostMapping and @RequestBody
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
```bash
# FILE (HelloRestController.java)
...
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
...
    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        path = {"/api/cmd", "/"}
    )
    public String helloCommand(
        @RequestBody
        String strJSON
    ) {
        JSONObject jsonObj = new JSONObject(strJSON);
        String value = jsonObj.getString("cmd") + ": we have received this value";
        jsonObj.put("cmd", value);
        return jsonObj.toString();
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

### DO (run the web application with gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (access the web api with url `/api/str` or `/`)
```bash
curl --no-progress-meter -H "Content-Type: application/json" -X POST -d '{"cmd":"ls"}' localhost:8080/api/cmd | json_pp
```
OR
```bash
curl --no-progress-meter -H "Content-Type: application/json" -X POST -d '{"cmd":"ls"}' localhost:8080/ | json_pp
```
```json5
    # >> Result
    {
      "cmd" : "ls: we have received this value"
    }
```

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## References
- https://www.codeflow.site/de/article/java-org-json
- https://www.baeldung.com/java-org-json




## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)

