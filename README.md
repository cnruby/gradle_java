<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>


[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IEAD Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![gretty-(2.0.0)](https://img.shields.io/github/v/tag/akhikhl/gretty?label=gretty&logo=gretty&style=plastic)](https://github.com/akhikhl/gretty)
[![docker tomcat-(9.0)](https://img.shields.io/badge/docker%20tomcat-9.0-brightgreen)](https://hub.docker.com/_/tomcat)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_109.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_109)



basic_112 Hello Tomcat!
<h1>Lesson 112: Hello Tomcat!</h1>

- Develop A Web Application with Web Server `Tomcat`


---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java Web Application from GitHub.com](#create-a-java-web-application-from-githubcom)
- [Add a Docker build file `Dockerfile`](#add-a-docker-build-file-dockerfile)
- [Create and Start a Container with Web Java Application](#create-and-start-a-container-with-web-java-application)
- [Develop the Web Application on Project](#develop-the-web-application-on-project)
  - [IF ( need to get help )](#if--need-to-get-help-)
  - [ELSE ( start the application )](#else--start-the-application-)
  - [Show Web Application Result](#show-web-application-result)
- [Develop the Web Application on Local](#develop-the-web-application-on-local)
  - [IF ( need to get help )](#if--need-to-get-help--1)
  - [ELSE ( start the web application )](#else--start-the-web-application-)
  - [Show Web Application Result](#show-web-application-result-1)
- [Develop the Project on Docker](#develop-the-project-on-docker)
  - [IF ( need to get help )](#if--need-to-get-help--2)
  - [ELSE ( start the application )](#else--start-the-application--1)
  - [Show Web Application Result](#show-web-application-result-2)
- [Working Processes](#working-processes)
- [Download and Use This complete Project](#download-and-use-this-complete-project)
- [Main's References](#mains-references)
- [References](#references)



## Keywords
- Gretty tomcat `Web Application` `web-app` `gradle plugin` `web server`
- Ubuntu Java Gradle tutorial example
- `Continuous Integration` CI `Continuous Deployment` CD CircleCI



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create a Java Web Application from GitHub.com

```bash
# DO (open a new terminal)
EXISTING_APP_ID=109 && NEW_APP_ID=112 \
&& git clone -b basic_${EXISTING_APP_ID}  \
    https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

```bash
./gradlew clean build
```



## Add a Docker build file `Dockerfile`

```bash
# DO (create a docker build file)
touch Dockerfile
# DO (edit the docker build file)
vi Dockerfile

    # FILE (./Dockerfile)
    FROM tomcat:9.0-slim

    RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT.war"]
    COPY /build/libs/_gradle_java.war /usr/local/tomcat/webapps/ROOT.war

    EXPOSE 8080
```



## Create and Start a Container with Web Java Application

```bash
./gradlew clean build
```


```bash
docker build --tag=112_gradle_java .
docker run -p 8080:8080 112_gradle_java
```



## Develop the Web Application on Project

### IF ( need to get help )
```bash
    ./gradlew tasks
```
### ELSE ( start the application )
```bash
    # DO (change any code)
    ./gradlew appRun
    # Press any key to stop the server IF stop the server
# ENDIF
```

### Show Web Application Result
```bash
    # DO (open a new terminal)
    curl http://localhost:8080/
        # >> Result
        Hello Tomcat! from index.html.
    curl -L http://localhost:8080/hello
        # >> Result
        [0,7,0,4,3]
```



## Develop the Web Application on Local

### IF ( need to get help )
```bash
    ./gradlew tasks | grep archiveAllProducts
```
### ELSE ( start the web application )
```bash
    # DO (change any code)
    # DO (create a web application on local)
    ./gradlew archiveAllProducts
    # DO (start a web server with web application)
    ./build/output/_gradle_java/start.sh
    # IF stop the web server
        # DO (open a new terminal)
        # DO (stop the web server) 
        ./build/output/_gradle_java/stop.sh
    # ENDIF
# ENDIF
```

### Show Web Application Result
```bash
    # DO (open a new terminal)
    # DO (access the HTML file)
    curl http://localhost:8080/
        # >> Result
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Hello Tomcat!</title>
        </head>
        <body>
        <center>
            <h1>Hello Tomcat!</h1>
        </center>
        </body>
        </html>
    # DO (access the Java Servlet)
    curl -L http://localhost:8080/hello
        # >> Result
        [7,8,8,8,0]
```



## Develop the Project on Docker

### IF ( need to get help )
```bash
    ./gradlew tasks
```
### ELSE ( start the application )
```bash
    # DO (change any code)
    ./gradlew clean build

    docker build --tag=112_gradle_java .
    docker run -p 80:8080 112_gradle_java
    # IF stop the server
        # DO (Press Ctrl+C to stop the server) 
    # ENDIF
        # >> Result
        ...
        19-Dec-2020 22:56:08.617 INFO [main] org.apache.catalina.core.AprLifecycleListener.lifecycleEvent APR/OpenSSL configuration: useAprConnector [false], useOpenSSL [true]
        19-Dec-2020 22:56:08.673 INFO [main] org.apache.catalina.core.AprLifecycleListener.initializeSSL OpenSSL successfully initialized [OpenSSL 1.1.1d  10 Sep 2019]
        19-Dec-2020 22:56:09.518 INFO [main] org.apache.coyote.AbstractProtocol.init Initializing ProtocolHandler ["http-nio-8080"]
        19-Dec-2020 22:56:09.612 INFO [main] org.apache.catalina.startup.Catalina.load Server initialization in [1947] milliseconds
        19-Dec-2020 22:56:09.776 INFO [main] org.apache.catalina.core.StandardService.startInternal Starting service [Catalina]
        19-Dec-2020 22:56:09.777 INFO [main] org.apache.catalina.core.StandardEngine.startInternal Starting Servlet engine: [Apache Tomcat/9.0.41]
        19-Dec-2020 22:56:09.815 INFO [main] org.apache.catalina.startup.HostConfig.deployWAR Deploying web application archive [/usr/local/tomcat/webapps/ROOT.war]
        19-Dec-2020 22:56:10.826 INFO [main] org.apache.jasper.servlet.TldScanner.scanJars At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
        19-Dec-2020 22:56:10.927 INFO [main] org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [/usr/local/tomcat/webapps/ROOT.war] has finished in [1,112] ms
        19-Dec-2020 22:56:10.938 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
        19-Dec-2020 22:56:10.976 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in [1362] milliseconds
# ENDIF
```

### Show Web Application Result
```bash
    # DO (open a new terminal)
    curl http://localhost:80/
        # >> Result
        Hello Tomcat! from index.html.
    curl -L http://localhost:80/hello
        # >> Result
        [6,7,4,5,0]
```



## Working Processes

```bash
# FOR loop
    # DO (change any code )
    # IF use Gretty tomcat to develop the web application on project
        # GOTO [Develop the Web Application on Project]
    # ENDIF
    # IF use Gretty tomcat to develop the web application on local system
        # GOTO [Develop the Web Application on Local]
    # ENDIF
    # IF use tomcat Docker to develop the web application
        # GOTO [Develop the Web Application on Docker]
    # ENDIF
# ENDFOR
```



## Download and Use This complete Project

```bash
# DO (download the whole project)
APP_ID=112 && git clone -b basic_${APP_ID}  \
    https://github.com/cnruby/gradle_java.git basic_${APP_ID} \
&& cd basic_${APP_ID}
```

```bash
# DO (build the application)
./gradlew clean build

# DO (create a docker image)
docker build --tag=112_gradle_java .

# DO (run a docker container with Java Web App)
docker run -p 80:8080 112_gradle_java
```

```bash
# DO (use the application)
google-chrome http://localhost:80/
    # >> Result
    Hello Tomcat!

google-chrome http://localhost:80/hello
    # >> Result
    [7,7,7,7,0]
```



## Main's References
- 

## References
- https://hub.docker.com/_/tomcat
- https://docs.gradle.org/current/userguide/building_java_projects.html#sec:building_java_webapps
- https://unix.stackexchange.com/questions/35183/how-do-i-identify-which-linux-distro-is-running
- https://stackoverflow.com/questions/14925073/tomcat-how-to-find-out-running-tomcat-version
