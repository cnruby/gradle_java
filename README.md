<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IEAD Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![jetty-(9.4.35)](https://img.shields.io/github/v/release/eclipse/jetty.project?logo=jetty&style=plastic)](https://github.com/eclipse/jetty.project)
[![gretty-(2.0.0)](https://img.shields.io/github/v/tag/akhikhl/gretty?label=gretty&logo=gretty&style=plastic)](https://github.com/akhikhl/gretty)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_111.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_111)



basic_111
<h1>Lesson 111: Hello Jetty!</h1>

- Develop A Web Application with Web Server `Jetty`


---


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java Application from GitHub.com](#create-a-java-application-from-githubcom)
- [Add a Docker build file `Dockerfile`](#add-a-docker-build-file-dockerfile)
- [Create and Start a Container with Java Application](#create-and-start-a-container-with-java-application)
- [Develop the Web Application on Project](#develop-the-web-application-on-project)
  - [IF ( need to get help )](#if--need-to-get-help-)
  - [ELSE ( start the application )](#else--start-the-application-)
  - [Show Web Application Result](#show-web-application-result)
- [Develop the Web Application on Local](#develop-the-web-application-on-local)
  - [IF ( need to get help )](#if--need-to-get-help--1)
  - [ELSE ( start the web application )](#else--start-the-web-application-)
  - [Show Web Application Result](#show-web-application-result-1)
- [Develop the Web Application on Docker](#develop-the-web-application-on-docker)
  - [IF ( need to get help )](#if--need-to-get-help--2)
  - [ELSE ( start the application )](#else--start-the-application--1)
  - [Show Web Application Result](#show-web-application-result-2)
- [Working Processes](#working-processes)
- [Use jetty docker image with different port](#use-jetty-docker-image-with-different-port)
  - [IF access the jetty server port 8080](#if-access-the-jetty-server-port-8080)
  - [ELSEIF access the jetty server port 80](#elseif-access-the-jetty-server-port-80)
- [Main's References](#mains-references)
- [References](#references)



## Keywords
- Gretty jetty tomcat `Web Application` `web-app` `gradle plugin` `web server`
- Ubuntu Java Gradle tutorial example
- `Continuous Integration` CI `Continuous Deployment` CD CircleCI



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [CircleCI Account](https://circleci.com/vcs-authorize/)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)




## Create a Java Application from GitHub.com

```bash
# DO (open a new terminal)
EXISTING_APP_ID=109 && NEW_APP_ID=111 && \
git clone -b basic_${EXISTING_APP_ID} \
https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java && \
cd ${NEW_APP_ID}_gradle_java
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
    FROM jetty
    ADD /build/libs/_gradle_java.war /usr/local/jetty/webapps/root.war
    EXPOSE 8080
```



## Create and Start a Container with Java Application

```bash
# DO (build the web application)
./gradlew clean build
```

```bash
# DO (create a docker image)
docker build --tag=111_gradle_java .
docker run -p 8080:8080 111_gradle_java
```



## Develop the Web Application on Project

### IF ( need to get help )
```bash
    ./gradlew tasks | grep appRun
```
### ELSE ( start the application )
```bash
    # DO (change any code)    
    ./gradlew appRun
    # DO (Press any key to stop the server) IF stop the server
# ENDIF
```

### Show Web Application Result
```bash
    # DO (open a new terminal)
    curl http://localhost:8080/
        # >> Result
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Hello Jetty!</title>
        </head>
        <body>
        <center>
            <h1>Hello Jetty!</h1>
        </center>
        </body>
        </html>
    curl -L http://localhost:8080/hello
        # >> Result
        [8,3,2,1,8]
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
            <title>Hello Jetty!</title>
        </head>
        <body>
        <center>
            <h1>Hello Jetty!</h1>
        </center>
        </body>
        </html>
    # DO (access the Java Servlet)
    curl -L http://localhost:8080/hello
        # >> Result
        [8,3,2,1,8]
```



## Develop the Web Application on Docker

### IF ( need to get help )
```bash
    ./gradlew tasks
```
### ELSE ( start the application )
```bash
    # DO (change any code)
    ./gradlew clean build

    docker build --tag=111_gradle_java .
    docker run -p 80:8080 111_gradle_java
    # IF stop the server
        # DO (Press Ctrl+C to stop the server) 
    # ENDIF
        # >> Result
        2020-12-18 11:33:40.121:INFO::main: Logging initialized @415ms to org.eclipse.jetty.util.log.StdErrLog
        2020-12-18 11:33:40.798:INFO:oejs.Server:main: jetty-9.4.35.v20201120; built: 2020-11-20T21:17:03.964Z; git: bdc54f03a5e0a7e280fab27f55c3c75ee8da89fb; jvm 11.0.9.1+1
        2020-12-18 11:33:40.863:INFO:oejdp.ScanningAppProvider:main: Deployment monitor [file:///var/lib/jetty/webapps/] at interval 1
        2020-12-18 11:33:42.071:INFO:oeja.AnnotationConfiguration:main: Scanning elapsed time=572ms
        2020-12-18 11:33:42.463:INFO:oejs.session:main: DefaultSessionIdManager workerName=node0
        2020-12-18 11:33:42.463:INFO:oejs.session:main: No SessionScavenger set, using defaults
        2020-12-18 11:33:42.466:INFO:oejs.session:main: node0 Scavenging every 600000ms
        2020-12-18 11:33:42.556:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@6fd83fc1{ROOT,/,file:///tmp/jetty/jetty-0_0_0_0-8080-ROOT_war-_-any-6326391873217820744/webapp/,AVAILABLE}{/var/lib/jetty/webapps/ROOT.war}
        2020-12-18 11:33:42.646:INFO:oejs.AbstractConnector:main: Started ServerConnector@6b98a075{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
        2020-12-18 11:33:42.649:INFO:oejs.Server:main: Started @2969ms
# ENDIF
```

### Show Web Application Result
```bash
    # DO (open a new terminal)
    google-chrome http://localhost:80/
        # >> Result
        Hello Jetty!
    google-chrome http://localhost:80/hello
        # >> Result
        [8,3,2,1,8]
```



## Working Processes

```bash
# FOR loop
    # DO (change any code )
    # IF use Gretty jetty to develop the web application on project
        # GOTO [Develop the Web Application on Project]
    # ENDIF
    # IF use Gretty jetty to develop the web application on local system
        # GOTO [Develop the Web Application on Local]
    # ENDIF
    # IF use jetty Docker to develop the web application
        # GOTO [Develop the Web Application on Docker]
    # ENDIF
# ENDFOR
```



## Use jetty docker image with different port

### IF access the jetty server port 8080
```bash
    docker run -p 8080:8080 111_gradle_java
    # IF ( need to show result )
        # DO (open a new terminal)
        curl http://localhost:8080/
            # >> Hello Jetty! from index.html.
        curl -L http://localhost:8080/hello
            # >> [4,6,1,4,3]
    # ENDIF
```

### ELSEIF access the jetty server port 80
```bash
    # !! we use this version
    docker run -p 80:8080 111_gradle_java
    # IF ( need to show result )
        # DO (open a new terminal)
        curl http://localhost:80/
            # >> Result
            # Hello Jetty! from index.html.
        curl -L http://localhost:80/hello
            # >> Result
            [6,5,5,8,9]
    # ENDIF
# ENDIF
```



## Main's References
- https://dkbalachandar.wordpress.com/2016/04/18/dockerfile-to-deploy-a-war-file-on-jetty/
- https://github.com/GoogleCloudPlatform/jetty-runtime

## References
- https://hub.docker.com/_/jetty
- https://docs.gradle.org/current/userguide/building_java_projects.html#sec:building_java_webapps
- https://unix.stackexchange.com/questions/35183/how-do-i-identify-which-linux-distro-is-running
- https://nickjanetakis.com/blog/docker-tip-2-the-difference-between-copy-and-add-in-a-dockerile

```
