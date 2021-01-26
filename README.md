<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_226.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_226)



---

Lesson 226: Hello OpenAPI!
<h1>Lesson 226: Hello OpenAPI!</h1>

- How to Understand the Java Document `OpenAPI`

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)




## Keywords
- OpenAPI Annotation `@Operation` `@Schema` Document API
- Annotation `@RequestMapping` `@RequestParam` `Spring Boot` GET download file `Spring Boot`
- Annotation `@PosMapping` `@RequestPart` `Spring Boot` POST upload file
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
EXISTING_APP_ID=225 && NEW_APP_ID=226 \
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
web.app.name=Hello OpenAPI
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Configure the Project for `OpenAPI`

### DO (add the `OpenAPI` to gradle build file)
```bash
nano ./build.gradle
```
```bash
# FILE (build.gradle)
...
dependencies {
  implementation 'org.springdoc:springdoc-openapi-ui:1.5.2'
  implementation 'io.springfox:springfox-swagger2:3.0.0'
  implementation 'io.springfox:springfox-swagger-ui:3.0.0'
...
```

### DO (add a new java class file for `OpenAPI`)
```bash
touch ./src/main/java/de/iotoi/OpenApiConfig.java
```
```bash
nano ./src/main/java/de/iotoi/OpenApiConfig.java
```
```java
// FILE (OpenApiConfig.java)
package de.iotoi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
  info = @Info(
    title = "Java Spring Boot REST API",
    version = "v1.0.0",
    description = "This app provides REST APIs for get and post information",
    contact = @Contact(name = "Gudao LUO", email = "gudao.luo@gmail.de", url = "http://iotoi.de")
  )
)
public class OpenApiConfig {}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Use the `OpenAPI` for the Project

### DO (run the web application with gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    Hello OpenAPI from init()!
    Hello OpenAPI from init()!!    
    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (access the web openapi)
```bash
google-chrome http://localhost:8080/swagger-ui.html
```

### DO (view the result)
![openapi_null](doc/image/openapi_null.png)

### DO (view the video for url `/api/str`)
![openapi_api_str](doc/video/openapi_api_str.gif)

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## Add the OpenAPI's Annotation @Operation for the Project

### DO (edit the java rest controller file)
```bash
nano ./src/main/java/de/iotoi/HelloRestController.java
```
```java
// FILE (HelloRestController.java)
...
import io.swagger.v3.oas.annotations.Operation;
...
    @Operation(summary = "Unit 224: Hello @PostMapping and @RequestPart!")
    @PostMapping(
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        path = "/api/upload"
    )
...
```

### DO (run the web application with gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    Hello OpenAPI from init()!
    Hello OpenAPI from init()!!    
    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (access the web openapi)
```bash
google-chrome http://localhost:8080/swagger-ui.html
```

### DO (view the result for @Operation)
![openapi_operation](doc/image/openapi_operation.png)

### DO (view the video for url `/api/download`)
![openapi_api_download](doc/video/openapi_api_download.gif)

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## Add the OpenAPI's Annotation @Schema for the Project

### DO (before add the annotation @Schema)
![openapi_before_schema](doc/image/openapi_before_schema.png)

### DO (edit the java rest controller file)
```bash
nano ./src/main/java/de/iotoi/HelloRestController.java
```
```java
// FILE (HelloRestController.java)
...
import io.swagger.v3.oas.annotations.media.Schema;
...
    public String helloCommand(
        @Schema(
            example = "{\"cmd\":\"ls\"}",
            format = "json",
            description = "Get a information by the json format.",
            required = true
        )        
        @RequestBody
...
```

```bash
./gradlew -q bootRun
```
```bash
    # Result
    Hello OpenAPI from init()!
    Hello OpenAPI from init()!!    
    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (access the web openapi)
```bash
google-chrome http://localhost:8080/swagger-ui.html
```

### DO (after add the annotation @Schema)
![openapi_after_schema](doc/image/openapi_after_schema.png)

### DO (view the video for url `/api/cmd`)
![openapi_api_cmd](doc/video/openapi_api_cmd.gif)

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## References
- https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api




## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)

