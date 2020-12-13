<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>


[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![GitHub release (latest by date)](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_105.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_105)



basic_105
<h1>Lesson 105: Hello CircleCI!</h1>

- Develop a Java application with Gradle and CI

---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java Application with Gradle](#create-a-java-application-with-gradle)
- [Use CircleCI.com](#use-circlecicom)
  - [Add the CI (CircleCI.com) configuration for the application](#add-the-ci-circlecicom-configuration-for-the-application)
  - [run CI on `CircleCI.com`](#run-ci-on-circlecicom)
- [Run the Java application on Local System](#run-the-java-application-on-local-system)
- [Package the Java apllication](#package-the-java-apllication)
  - [build the Java application](#build-the-java-application)
  - [run the Java application on different OS System:](#run-the-java-application-on-different-os-system)
- [Download and Use This compelete Project](#download-and-use-this-compelete-project)
- [Result on the CI Website `CircleCI.com`](#result-on-the-ci-website-circlecicom)
- [References](#references)



## Keywords
- `Continuous Integration` CI `Continuous Deployment` CD CircleCI
- Ubuntu Java Gradle tutorial example



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create a Java Application with Gradle

```bash
gradle init --project-name gradle_java --type java-application  \
--dsl groovy --test-framework 'junit-jupiter' --package basic_105
```



## Use CircleCI.com

### Add the CI (CircleCI.com) configuration for the application

```bash
# DO (create a folder for CircleCI.com configuration file)
mkdir .circleci
# DO (create a new configuration file)
touch .circleci/config.yml
# DO (edit a new configuration file)
vi .circleci/config.yml

    # FILE (.circleci/config.yml) 
    # Java Gradle CircleCI 2.0 configuration file
    #
    version: 2
    jobs:
      build:
        docker:
          # specify the version you desire here
          # - image: circleci/openjdk:11-jdk
          - image: azul/zulu-openjdk:11

          # - image: circleci/postgres:9.4

        working_directory: ~/repo

        environment:
          # Customize the JVM maximum heap limit
          JVM_OPTS: -Xmx3200m
          TERM: dumb

        steps:
          - checkout

          # Download and cache dependencies
          - restore_cache:
              keys:
                - v1-dependencies-{{ checksum "build.gradle" }}
                # fallback to using the latest cache if no exact match is found
                - v1-dependencies-

          # about Gradle
          - run: ./gradlew --version

          # project libraries
          - run: ./gradlew dependencies

          - save_cache:
              paths:
                - ~/.gradle
              key: v1-dependencies-{{ checksum "build.gradle" }}

          # compile application
          - run: ./gradlew compileJava

          # run application
          - run: ./gradlew run
          
          # run application tests
          - run: ./gradlew clean test

          # build application
          - run: ./gradlew clean build

          # unzip application to OS System
          - run: unzip build/distributions/_gradle_java.zip

          # run application on OS System
          - run: ./_gradle_java/bin/basic_105
```

### run CI on `CircleCI.com`
1. Add the Github Project on the Website [CircleCI Account](https://circleci.com/vcs-authorize/)
2. Commit the Project to GitHub.com
3. View the `CircleCI.com`



## Run the Java application on Local System

```bash
# DO (run the Java application)
./gradlew run

    # >> RESULT
    > Task :run
    Hello world.

    BUILD SUCCESSFUL in 422ms
    2 actionable tasks: 2 executed
    ```

    ### test the Java application

    ```bash
    ./gradlew clean test
```



## Package the Java apllication

### build the Java application
 
```bash
# DO (create a package for the project)
./gradlew clean build
```

### run the Java application on different OS System:

```bash
# DO (unzip release version package)
unzip build/distributions/_gradle_java.zip
# DO (run the application)
./_gradle_java/bin/basic_105

    # >> RESULT

    ```bash
    Hello world.
```



## Download and Use This compelete Project

```bash
# Download
git clone -b basic_105 https://github.com/cnruby/gradle_java.git basic_105
```

```bash
# Use
cd basic_105
./gradlew run
```



## Result on the CI Website `CircleCI.com`
- [CircleCI Account](https://circleci.com/vcs-authorize/)

![105_hello_circleci_com](docs/images/105_hello_circleci_com.png)
![105_hello_circleci_com_result](docs/images/105_hello_circleci_com_result.png)




## References
- https://circleci.com/
- https://circleci.com/docs/2.0/status-badges/
- https://github.com/wavesoftware/docker-circleci-zulujdk
- https://circleci.com/docs/2.0/language-java/