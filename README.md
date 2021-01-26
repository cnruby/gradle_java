<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_225.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_225)



---

Lesson 225: Hello @RequestMapping and @RequestParam!
<h1>Lesson 225: Hello @RequestMapping and @RequestParam!</h1>

- How to Understand the Annotation @RequestMapping and @RequestParam!
- How to Download the Image File from Server to Local System


---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web App](#create-a-new-java-web-app)
  - [DO (create a new project)](#do-create-a-new-project)




## Keywords
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
EXISTING_APP_ID=224 && NEW_APP_ID=225 \
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
web.app.name=Hello @RequestMapping and @RequestParam
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Develop the Project for checking url `/api/test_download`

### DO (add a new download file for server folder)
```bash
mkdir ./server_download
```
```bash
wget https://github.com/cnruby/gradle_java/raw/basic_225/server_download/server_java.png -O ./server_download/server_java.png
```

### DO (edit the spring rest controller file)
```bash
nano ./src/main/java/de/iotoi/HelloRestController.java
```
```java
// FILE (HelloRestController.java)
...
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
...
    @RequestMapping(path = "/api/test_download", method = RequestMethod.GET)
    public String testDownload(
        @RequestParam("imageX")
        String imageName
    ) throws IOException {
        String strPath = "./server_download" + File.separator.toString() + imageName;
        File file = new File(strPath);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("path", strPath);
        jsonObj.put("fileSize", file.length());
        return jsonObj.toString();
    }
}
```

### DO (run the web application with gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    Hello @RequestMapping and @RequestParam from init()!
    Hello @RequestMapping and @RequestParam from init()!!    
    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (access the web api with url `/api/test_download`)
```bash
curl --no-progress-meter http://localhost:8080/api/test_download?imageX=server_java.png | json_pp
```
```json5
    // >> Result
    {
      "fileSize" : 21493,
      "path" : "./server_download/server_java.png"
    }
```

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## Develop the Project for downloading url `/api/download`

### DO (edit the spring rest controller file)
```bash
nano ./src/main/java/de/iotoi/HelloRestController.java
```
```java
// FILE (HelloRestController.java)
...
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
...
    @RequestMapping(path = "/api/download", method = RequestMethod.GET)
    public ResponseEntity<Resource> parseDownloadFile(
        @RequestParam("imageX")
        String imageName
    ) throws IOException {        
        File file = new File("./server_download" + File.separator.toString() + imageName );
        HttpHeaders header = new HttpHeaders();
        // header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=server_java.svg")
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        return ResponseEntity.ok()
            .headers(header)
            .contentLength(file.length())
            .contentType(MediaType.parseMediaType("application/octet-stream"))
            .body(resource);
    }
}
```

### DO (run the web application with gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    Hello @RequestMapping and @RequestParam from init()!
    Hello @RequestMapping and @RequestParam from init()!!    
    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (access the web api with url `/api/download`)
```bash
curl http://localhost:8080/api/download?imageX=server_java.png --output local_java.png
```bash
    # >> Result
      % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                    Dload  Upload   Total   Spent    Left  Speed
    100 21493  100 21493    0     0  97695      0 --:--:-- --:--:-- --:--:-- 97253    
```

### DO (view the downloaded file)
```bash
ls -al local_java.png
```
```bash
    # >> Result:
    -rw-rw-r-- 1 gudao gudao 21493 Jan 20 04:48 local_java.png
```

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## References
- https://stackoverflow.com/questions/35680932/download-a-file-from-spring-boot-rest-service
- https://www.baeldung.com/curl-rest
- http://www.mastertheboss.com/jboss-frameworks/resteasy/using-rest-services-to-manage-download-and-upload-of-files
- https://dzone.com/articles/java-springboot-rest-api-to-uploaddownload-file-on
- https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/
- 


## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)

