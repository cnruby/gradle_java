<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>



[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![GitHub release (latest by date)](https://img.shields.io/badge/Gradle-v6.6.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_110.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_110)



basic_110
<h1>Lesson 110: Hello App with Docker!</h1>

- Develop a Java application with Docker, Gradle and CI

---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java Application from GitHub.com](#create-a-java-application-from-githubcom)
- [Create Docker Image](#create-docker-image)
  - [Add the Docker build file `Dockerfile`](#add-the-docker-build-file-dockerfile)
  - [Build the Docker Image](#build-the-docker-image)
- [Develop the Java application](#develop-the-java-application)
  - [run the Java application on Local Project](#run-the-java-application-on-local-project)
  - [add a new tasks for the project](#add-a-new-tasks-for-the-project)
  - [check the new task `releaseRun`](#check-the-new-task-releaserun)
- [run the Java application on Docker](#run-the-java-application-on-docker)
- [Working Processes](#working-processes)
- [References](#references)



## Keywords
- `Java Application` Docker
- Ubuntu Gradle tutorial example `Continuous Integration` CI `Continuous Deployment` CD CircleCI



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [CircleCI Account](https://circleci.com/vcs-authorize/)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)



## Create a Java Application from GitHub.com

```bash
EXISTING_APP_ID=105 && NEW_APP_ID=110 && \
git clone -b basic_${EXISTING_APP_ID} \
https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java && \
cd ${NEW_APP_ID}_gradle_java
```



## Create Docker Image

### Add the Docker build file `Dockerfile`

```bash
# DO (create a new docker build file)
touch Dockerfile
# DO (edit the docker file ./Dockerfile)
vi Dockerfile

    # FILE (./Dockerfile)
    FROM azul/zulu-openjdk-alpine:11.0.6-jre

    RUN apk update && apk add bash
    WORKDIR /app
    COPY /_gradle_java/ /app/
    CMD ["./bin/basic_110"]
```

### Build the Docker Image
```bash
# DO (create a new docker image)
docker build --tag=110_gradle_java .
```



## Develop the Java application

### run the Java application on Local Project

```bash
# DO (run the application)
./gradlew run

    # >> Result:
    Starting a Gradle Daemon (subsequent builds will be faster)

    > Task :run
    Hello world.

    BUILD SUCCESSFUL in 2s
    2 actionable tasks: 2 execute
```

### add a new tasks for the project

```bash
# DO (edit the file ./build.gradde)
vi ./build.gradde

    # FILE (./build.gradde)
    ...
    task releaseRun {
        group = 'de.iotoi'
        description = 'Unzip release and run the application'
        doLast {
            // unzip app
            def cmdUnzip = 'unzip build/distributions/' + applicationName + '.zip'
            def procUnzip = cmdUnzip.execute()
            procUnzip.out.close()
            procUnzip.waitFor()

            // run app
            def cmdApp = './' + applicationName + '/bin/' + startScripts.applicationName
            def procApp = cmdApp.execute()
            println procApp.text
            procApp.out.close()
            procApp.waitFor()
        }
    }    
```

### check the new task `releaseRun`
```bash
./gradlew tasks | grep releaseRun

    # >> Result
    releaseRun - Unzip release and run the application
```



## run the Java application on Docker

```bash
# DO (clean, bundle, unzip and run the project as a distribution)
./gradlew clean build releaseRun

# DO (create a new docker image)
docker build --tag=110_gradle_java .

# DO (run the Java application on Docker)
docker run 110_gradle_java

    # >> Result:
    Hello world.
```



## Working Processes

```bash
# FOR
    # DO ( change any code ) IF need
    ./gradlew clean build
    # IF will check the apllication
        ./gradlew run
    # ENDIF
    # IF ( change any code ) 
        docker build --tag=110_gradle_java .
    # ENDIF
    docker run 110_gradle_java
# ENDFOR
```



## References
- https://www.digitalocean.com/community/tutorials/so-installieren-und-verwenden-sie-docker-auf-ubuntu-18-04-de
- https://docs.docker.com/engine/install/ubuntu/
- https://gretty-gradle-plugin.github.io/gretty-doc/Getting-started.html
