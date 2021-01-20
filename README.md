<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IDEA Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_203.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_203)



---

Lesson 203: Hello devtools!
<h1>Lesson 203: Hello devtools!</h1>

- How to HotSwap code without an IDE in a Spring-Boot project
- How to HotSwap code in Intellij in a Spring-Boot project

---


<h1>Table of Contents</h1>

- [DO (stop the web server)](#do-stop-the-web-server)
  - [HotCode without IDE](#hotcode-without-ide)
    - [DO (open a new terminal to assemble an executable jar archive)](#do-open-a-new-terminal-to-assemble-an-executable-jar-archive)
    - [DO (open a new terminal to run this project)](#do-open-a-new-terminal-to-run-this-project)
    - [DO (open a new terminal to browse the website)](#do-open-a-new-terminal-to-browse-the-website-1)
    - [DO (change the java file)](#do-change-the-java-file)
    - [DO (waiting until the command `./gradlew -q bootJar --continuous` comes)](#do-waiting-until-the-command-gradlew--q-bootjar---continuous-comes)
    - [DO (browse the website again)](#do-browse-the-website-again)
  - [HotCode in IntelliJ](#hotcode-in-intellij)
    - [DO (change the code)](#do-change-the-code)
  - [References](#references)
  - [References for tools](#references-for-tools)




## Keywords
- HotCode restart devtools `Spring Boot`
- `Java JDK` `IntelliJ CE` CircleCI CI
- tutorial example install Java Ubuntu Gradle jabba JDK Java JVM




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)




## Create A New Java Web App

### DO (create a new project)
```bash
NEW_APP_ID=203 && \
mkdir ${NEW_APP_ID}_gradle_java && cd ${NEW_APP_ID}_gradle_java 
curl https://start.spring.io/starter.zip -d language=java \
  -d dependencies=web,devtools \
  -d packageName=de.iotoi \
  -d artifactId=_gradle_java \
  -d groupId=de.iotoi \
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
	2021-01-20 21:16:52.762  INFO 8425 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
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
package de.iotoi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @RequestMapping("/api")
    public String helloJava() {
        return "Hello @devtools!\n";
    }
}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result
    2021-01-20 21:19:14.604  INFO 8672 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
```

### DO (run The Application with Gradle)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    2021-01-20 21:22:29.679  INFO 9425 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
    2021-01-20 21:22:29.685  INFO 9425 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
    2021-01-20 21:22:30.838  INFO 9425 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
    2021-01-20 21:22:30.853  INFO 9425 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
    2021-01-20 21:22:30.853  INFO 9425 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
    2021-01-20 21:22:30.922  INFO 9425 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
    2021-01-20 21:22:30.922  INFO 9425 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1236 ms
    2021-01-20 21:22:31.169  INFO 9425 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
    2021-01-20 21:22:31.355  INFO 9425 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
    2021-01-20 21:22:31.388  INFO 9425 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    <==========---> 80% EXECUTING [17s]
    > :bootRun
```

### DO (open a new terminal to browse the website)
```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello devtools!
```

# DO (stop the web server)
```bash
# !!! (Ctrl+C)
```




## HotCode without IDE

### DO (open a new terminal to assemble an executable jar archive)
```bash
./gradlew -q bootJar --continuous
```
```bash
    # >> Result
    Waiting for changes to input files of tasks... (ctrl-d to exit)
    <-------------> 0% WAITING
    > IDLE
```

### DO (open a new terminal to run this project)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    2021-01-20 21:25:44.125  INFO 10017 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
    2021-01-20 21:25:44.141  INFO 10017 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
    2021-01-20 21:25:45.217  INFO 10017 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
    2021-01-20 21:25:45.235  INFO 10017 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
    2021-01-20 21:25:45.235  INFO 10017 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
    2021-01-20 21:25:45.308  INFO 10017 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
    2021-01-20 21:25:45.309  INFO 10017 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1166 ms
    2021-01-20 21:25:45.538  INFO 10017 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
    2021-01-20 21:25:45.735  INFO 10017 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
    2021-01-20 21:25:45.770  INFO 10017 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    <==========---> 80% EXECUTING [22s]
    > :bootRun
```

### DO (open a new terminal to browse the website)
```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello devtools!
```

### DO (change the java file)
```bash
nano src/main/java/de/iotoi/HelloRestController.java
```
```bash
    # FILE (HelloRestController.java)
    ...
    return "Hello devtools!!!\n"
    ...
```

### DO (waiting until the command `./gradlew -q bootJar --continuous` comes)
```bash
    Waiting for changes to input files of tasks... (ctrl-d to exit)
    <-------------> 0% WAITING
    > IDLE
```

### DO (browse the website again)
```bash
curl http://localhost:8080/api
```
```bash
    # DO (waiting)
    # >> Result
    Hello devtools!!!
```




## HotCode in IntelliJ
```bash
# DO (Change the IntelliJ)
# !!! In Menu File >> Setting >> Build, Execution, Deployment >> Compiler >> [x] Build project automatically
# !!! Ctrl+Shift+A >> Enter "Registry" >> Click "Registry..." >> [x] complier.automake.allow.when.app.running
```

```bash
./gradlew -q bootRun
```

```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello devtools!!!
```

### DO (change the code)
```bash
nano ./src/main/java/de/iotoi/HelloRestController.java
```
```bash
    # FILE (HelloRestController.java)
    ...
    return "Hello devtools!\n"
    ...
```
```bash
### DO (Click the Menu Item)
# !!! In Menu >> Build >> Build Project (CTRL + F9)
```

```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello devtools!
```




## References
- https://stackoverflow.com/questions/54937518/visual-studio-code-spring-boot-reload-static-content/55370810
- https://mkyong.com/spring-boot/intellij-idea-spring-boot-template-reload-is-not-working/
- https://gist.github.com/IMRFeng/eed589de6a6362ef23bc189fb135fdea
- https://www.vojtechruzicka.com/spring-boot-devtools/
- https://stackoverflow.com/questions/33349456/how-to-make-auto-reload-with-spring-boot-on-idea-intellij
- https://stackoverflow.com/questions/54556072/hot-to-hotswap-code-in-intellij-in-a-spring-boot-project
- https://www.nexsoftsys.com/articles/hot-swapping-in-spring-boot-applications.html
 



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)