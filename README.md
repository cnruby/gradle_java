<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![IntelliJ IDEA Community Edition](https://img.shields.io/badge/IntelliJ%20IDEA%20Community%20Edition-blue?style=flat)](https://www.jetbrains.com/idea/download/#section=linux)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_202.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_202)



---

Lesson 202: Hello @RestController!
<h1>Lesson 202: Hello @RestController!</h1>

- How to Create a Java Web App By existing GitHub's Project
- How to Understand An Annotation @RestController By A Simple Example

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web Application](#create-a-new-java-web-application)
	- [DO (create a new project)](#do-create-a-new-project)
	- [DO (check the project)](#do-check-the-project)
- [Develop The Project](#develop-the-project)
	- [DO (create and edit the java file)](#do-create-and-edit-the-java-file)
	- [DO (check the project)](#do-check-the-project-1)
- [Run The Application on Local](#run-the-application-on-local)
	- [DO (start webserver with web application)](#do-start-webserver-with-web-application)
	- [DO (browse the web application with url `/`)](#do-browse-the-web-application-with-url-)
	- [DO (browse the web application with url `/api`)](#do-browse-the-web-application-with-url-api)
- [Run The Application on Docker](#run-the-application-on-docker)
	- [DO (build an OCI image of the application)](#do-build-an-oci-image-of-the-application)
	- [DO (run the application on Docker)](#do-run-the-application-on-docker)
	- [DO (browse the web application with url `/` on Docker)](#do-browse-the-web-application-with-url--on-docker)
	- [DO (browse the web application with url `/api` on Docker)](#do-browse-the-web-application-with-url-api-on-docker)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- `@RestController` `Java Web App` webapp web-app `Spring Boot` `Command Line`
- `Java JDK` `IntelliJ CE` CircleCI CI
- tutorial example Ubuntu Gradle jabba JDK Java JVM




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)




## Create A New Java Web Application

### DO (create a new project)
```bash
EXISTING_APP_ID=201 && NEW_APP_ID=202 \
&& git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result
	2021-01-20 14:45:11.678  INFO 37828 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
```




## Develop The Project

### DO (create and edit the java file)
```bash
touch ./src/main/java/de/iotoi/HelloRestController.java
```
```bash
nano ./src/main/java/de/iotoi/HelloRestController.java
```

```bash
# FILE (HelloRestController.java)
package de.iotoi

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloRestController {
    @GetMapping("/api")
    fun helloJava(): String {
        return "Hello @RestController!"
    }
}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result
    2021-01-20 16:38:54.575  INFO 56159 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
```



## Run The Application on Local

### DO (start webserver with web application)
```bash
./gradlew -q bootRun
```
```bash
	# DO (Ctrl+C, if stop web server)
    # >> Result
	2021-01-20 16:39:02.401  INFO 56303 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
	2021-01-20 16:39:02.420  INFO 56303 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
	2021-01-20 16:39:02.421  INFO 56303 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
	2021-01-20 16:39:02.547  INFO 56303 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	2021-01-20 16:39:02.547  INFO 56303 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1275 ms
	Hallo Welt!
	2021-01-20 16:39:02.825  INFO 56303 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
	2021-01-20 16:39:03.058  INFO 56303 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
	Hello World!
	<==========---> 80% EXECUTING [1m 35s]
	> :bootRun
```

### DO (browse the web application with url `/`)
```bash
curl http://localhost:8080 | json_pp
```
```bash
	# >> Result
	  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
									 Dload  Upload   Total   Spent    Left  Speed
	100   102    0   102    0     0    207      0 --:--:-- --:--:-- --:--:--   207
	{
		"error" : "Not Found",
		"message" : "",
		"path" : "/",
		"status" : 404,
		"timestamp" : "2021-01-20T15:40:56.630+00:00"
	}
```

### DO (browse the web application with url `/api`)
```bash
curl http://localhost:8080/api
```
```bash
	# >> Result
	Hello @RestController!
```




## Run The Application on Docker

### DO (build an OCI image of the application)
```bash
./gradlew bootBuildImage --imageName=gradle_java/basic_202
```
```bash
	# >> Result
	> Task :bootBuildImage
	Building image 'docker.io/gradle_java/basic_202:latest'

	 > Pulling builder image 'docker.io/paketobuildpacks/builder:base' ..................................................
	 ...
	 ...
		[creator]           docker.io/gradle_java/basic_202:latest

	Successfully built image 'docker.io/gradle_java/basic_202:latest'

	BUILD SUCCESSFUL in 3m 3s
	5 actionable tasks: 3 executed, 2 up-to-date	 
```

### DO (run the application on Docker)
```bash
docker run -p 80:8080 gradle_java/basic_202
```
```bash
	# >> Result
	Setting Active Processor Count to 4
	Calculating JVM memory based on 1114596K available memory
	Calculated JVM Memory Configuration: -XX:MaxDirectMemorySize=10M -Xmx520462K -XX:MaxMetaspaceSize=82133K -XX:ReservedCodeCacheSize=240M -Xss1M (Total Memory: 1114596K, Thread Count: 250, Loaded Class Count: 12087, Headroom: 0%)
	Adding 138 container CA certificates to JVM truststore
	Spring Cloud Bindings Enabled
	Picked up JAVA_TOOL_OPTIONS: -Djava.security.properties=/layers/paketo-buildpacks_bellsoft-liberica/java-security-properties/java-security.properties -agentpath:/layers/paketo-buildpacks_bellsoft-liberica/jvmkill/jvmkill-1.16.0-RELEASE.so=printHeapHistogram=1 -XX:ActiveProcessorCount=4 -XX:MaxDirectMemorySize=10M -Xmx520462K -XX:MaxMetaspaceSize=82133K -XX:ReservedCodeCacheSize=240M -Xss1M -Dorg.springframework.cloud.bindings.boot.enable=true
	2021-01-20 15:54:07.713  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
	2021-01-20 15:54:07.760  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
	2021-01-20 15:54:07.761  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
	2021-01-20 15:54:07.997  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	2021-01-20 15:54:07.998  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 4410 ms
	Hallo Welt!
```

### DO (browse the web application with url `/` on Docker)
```bash
curl http://localhost:80/ | json_pp
```
```bash
    # >> Result
	  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
									 Dload  Upload   Total   Spent    Left  Speed
	100   102    0   102    0     0  17000      0 --:--:-- --:--:-- --:--:-- 17000
	{
	   "error" : "Not Found",
	   "message" : "",
	   "path" : "/",
	   "status" : 404,
	   "timestamp" : "2021-01-20T15:55:39.130+00:00"
	}
```

### DO (browse the web application with url `/api` on Docker)
```bash
curl http://localhost:80/api
```
```bash
	# >> Result
	Hello @RestController!
```




## References
- http://zetcode.com/springboot/bean/#:~:text=Spring%20%40Bean%20annotation%20tells%20that,a%20bean%20within%20a%20BeanFactory%20.
- https://spring.io/blog/2021/01/04/ymnnalft-easy-docker-image-creation-with-the-spring-boot-maven-plugin-and-buildpacks
- https://medium.com/@ashoksl/build-docker-image-using-spring-boot-buildimage-gradle-ac5bc1f71303
- https://github.com/ashoksl/java_samples/tree/master/buildimagedemo
- https://reflectoring.io/spring-boot-docker/
- https://github.com/francescopeloi/spring-boot-build-docker-image-demo
- https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1
- https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/




## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)