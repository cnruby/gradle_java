<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![IntelliJ IDEA Community Edition](https://img.shields.io/badge/IntelliJ%20IDEA%20Community%20Edition-blue?style=flat)](https://www.jetbrains.com/idea/download/#section=linux)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_123.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_123)
[![Release--basic_123](https://github.com/cnruby/gradle_java/workflows/Release--basic_123/badge.svg?branch=basic_123)](https://github.com/cnruby/gradle_java/actions)


---

Lesson 201: Hello @Bean!
<h1>Lesson 201: Hello @Bean!</h1>

- How to Create a Java Web App By Gradle Command Line
- How to Understand An Annotation @Bean By A Simple Example

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Java Web Application](#create-a-new-java-web-application)
	- [DO (create a new project)](#do-create-a-new-project)
	- [DO (edit the spring boot configuration file)](#do-edit-the-spring-boot-configuration-file)
	- [DO (check the project)](#do-check-the-project)
- [Develop The Project](#develop-the-project)
	- [DO (edit the java file)](#do-edit-the-java-file)
	- [DO (check the project)](#do-check-the-project-1)
- [Run The Application with Gradle](#run-the-application-with-gradle)
	- [DO (start webserver with web application)](#do-start-webserver-with-web-application)
	- [DO (browse the web application)](#do-browse-the-web-application)
	- [DO (stop the web server)](#do-stop-the-web-server)
- [Run The Application on Docker](#run-the-application-on-docker)
	- [DO (build an OCI image of the application)](#do-build-an-oci-image-of-the-application)
	- [DO (show all images)](#do-show-all-images)
	- [DO (run the application on Docker)](#do-run-the-application-on-docker)
	- [DO (browse the web application on Docker)](#do-browse-the-web-application-on-docker)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- `Java Web App` webapp web-app `Spring Boot` `Command Line`
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
NEW_APP_ID=201 && \
mkdir ${NEW_APP_ID}_gradle_java && cd ${NEW_APP_ID}_gradle_java && \
curl https://start.spring.io/starter.zip -d language=java \
	-d dependencies=web \
	-d packageName=de.iotoi \
	-d groupId=de.iotoi \
	-d artifactId=_gradle_java \
	-d name=java -d type=gradle-project -o basic_${NEW_APP_ID}.zip && \
unzip basic_${NEW_APP_ID}.zip
```

### DO (edit the spring boot configuration file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
spring.main.banner-mode=off
spring.main.log-startup-info=off
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

### DO (edit the java file)
```bash
nano ./src/main/java/de/iotoi/JavaApplication.kt
```

```bash
# FILE (JavaApplication.kt)
...
import org.springframework.context.annotation.Bean
import org.springframework.boot.CommandLineRunner

@SpringBootApplication
public class JavaApplication {
	public static void main(String[]args) {
		SpringApplication.run(JavaApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			System.out.println("Hello World!");
		};
	}

	@Bean
	public void hello() {
		System.out.println("Hallo Welt!");
	}

	public CommandLineRunner niHao() {
		return args -> {
			System.out.println("世界，你好!");
		};
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




## Run The Application with Gradle

### DO (start webserver with web application)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
	2021-01-20 15:29:26.766  INFO 44006 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
	2021-01-20 15:29:26.783  INFO 44006 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
	2021-01-20 15:29:26.783  INFO 44006 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
	2021-01-20 15:29:26.861  INFO 44006 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	2021-01-20 15:29:26.862  INFO 44006 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1045 ms
	Hallo Welt!
	2021-01-20 15:29:27.154  INFO 44006 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
	2021-01-20 15:29:27.347  INFO 44006 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
	Hello World!
	<==========---> 83% EXECUTING [20s]
	> :bootRun

# DO (Ctrl+C, if stop web server)
```

### DO (browse the web application)
```bash
curl http://localhost:8080 | json_pp
```
```bash
	# >> Result
	  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
									 Dload  Upload   Total   Spent    Left  Speed
	100   102    0   102    0     0    239      0 --:--:-- --:--:-- --:--:--   239
	{
	   "error" : "Not Found",
	   "message" : "",
	   "path" : "/",
	   "status" : 404,
	   "timestamp" : "2021-01-20T14:31:40.684+00:00"
	}
```

### DO (stop the web server)
```bash
# !!! Ctrl+C 
```




## Run The Application on Docker

### DO (build an OCI image of the application)
```bash
./gradlew bootBuildImage --imageName=gradle_java/basic_201
```
```bash
	# >> Result
	> Task :bootBuildImage
	Building image 'docker.io/gradle_java/basic_201:latest'

	 > Pulling builder image 'docker.io/paketobuildpacks/builder:base' ..................................................
	 ...
	 ...
		[creator]           docker.io/gradle_java/basic_201:latest

	Successfully built image 'docker.io/gradle_java/basic_201:latest'

	BUILD SUCCESSFUL in 3m 3s
	5 actionable tasks: 3 executed, 2 up-to-date	 
```

### DO (show all images)
```bash
docker images
```
```bash
    # >> Result
    REPOSITORY                      TAG        IMAGE ID       CREATED        SIZE
    paketobuildpacks/run            base-cnb   4347963b10a1   2 weeks ago    106MB
    paketobuildpacks/builder        base       6f3af49aa748   41 years ago   565MB
    gradle_java/basic_201           latest     3fdcce3843e3   41 years ago   281MB
```

### DO (run the application on Docker)
```bash
docker run -p 80:8080 gradle_java/basic_201
```
```bash
	# >> Result
	Setting Active Processor Count to 4
	Calculating JVM memory based on 2506712K available memory
	Calculated JVM Memory Configuration: -XX:MaxDirectMemorySize=10M -Xmx1912578K -XX:MaxMetaspaceSize=82133K -XX:ReservedCodeCacheSize=240M -Xss1M (Total Memory: 2506712K, Thread Count: 250, Loaded Class Count: 12087, Headroom: 0%)
	Adding 138 container CA certificates to JVM truststore
	Spring Cloud Bindings Enabled
	Picked up JAVA_TOOL_OPTIONS: -Djava.security.properties=/layers/paketo-buildpacks_bellsoft-liberica/java-security-properties/java-security.properties -agentpath:/layers/paketo-buildpacks_bellsoft-liberica/jvmkill/jvmkill-1.16.0-RELEASE.so=printHeapHistogram=1 -XX:ActiveProcessorCount=4 -XX:MaxDirectMemorySize=10M -Xmx1912578K -XX:MaxMetaspaceSize=82133K -XX:ReservedCodeCacheSize=240M -Xss1M -Dorg.springframework.cloud.bindings.boot.enable=true
	2021-01-20 14:38:11.967  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
	2021-01-20 14:38:11.998  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
	2021-01-20 14:38:11.999  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
	2021-01-20 14:38:12.087  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	2021-01-20 14:38:12.087  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1936 ms
	Hallo Welt!
	2021-01-20 14:38:12.545  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
	2021-01-20 14:38:12.951  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
	Hello World!
```

### DO (browse the web application on Docker)
```bash
curl http://localhost:80 | json_pp
```
```bash
    # >> Result
	{
	   "error" : "Not Found",
	   "message" : "",
	   "path" : "/",
	   "status" : 404,
	   "timestamp" : "2021-01-20T14:38:47.595+00:00"
	}
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