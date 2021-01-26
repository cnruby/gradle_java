<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_224.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_224)



---

Lesson 224: Hello @PostMapping and @RequestPart!
<h1>Lesson 224: Hello @PostMapping and @RequestPart!</h1>

- How to Understand the Annotation @PostMapping and @RequestPart!
- How to Upload the Text File from Local to Server


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
  - [DO (add a new upload file)](#do-add-a-new-upload-file)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle)
  - [DO (access the web api with url `/api/upload`)](#do-access-the-web-api-with-url-apiupload)
  - [DO (stop the web application with gradle)](#do-stop-the-web-application-with-gradle)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
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
EXISTING_APP_ID=223 && NEW_APP_ID=224 \
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
web.app.name=Hello @PostMapping and @RequestPart
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestPart;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
...
    @PostMapping(
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        path = "/api/upload"
    )
    public String parseUploadFile(
        @RequestPart(value = "uploadX", required = true)
        MultipartFile multipartFile
    ) throws IOException {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("fileName", multipartFile.getOriginalFilename());
        jsonObj.put("fileContent", new String(multipartFile.getBytes(), StandardCharsets.UTF_8));
        jsonObj.put("fileSize", multipartFile.getSize());
        return jsonObj.toString();
    }
}
```

### DO (add a new upload file)
```bash
mkdir ./local_upload
```
```bash
touch ./local_upload/hello.txt
```
```bash
nano ./local_upload/hello.txt
```
```bash
# FILE (hello.txt)
Hello @PostMapping and @RequestPart!
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

### DO (access the web api with url `/api/upload`)
```bash
curl --no-progress-meter -H "Content-Type: multipart/form-data" -H "accept: application/json" \
    -X POST \
    -F "uploadX=@./local_upload/hello.txt;type=text/plain" \
    http://localhost:8080/api/upload | json_pp
```
```json5
    // >> Result
    {
      "fileContent" : "Hello @PostMapping and @RequestPart!",
      "fileName" : "hello.txt",
      "fileSize" : "36"
    }
```

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## References
- https://www.codeflow.site/de/article/java-org-json
- https://www.baeldung.com/java-org-json
- https://mkyong.com/java/how-do-convert-byte-array-to-string-in-java/



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)

