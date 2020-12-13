<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>


[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![GitHub release (latest by date)](https://img.shields.io/badge/Gradle-v6.6.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![GitHub release (latest by date)](https://img.shields.io/badge/Groovy-v3.0.7-black?style=flat&logo=groovy)](https://groovy.apache.org/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_106.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_106)



basic_106
<h1>Lesson 106: Hello Package!</h1>

- Develop a Java application with Third Package

---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java Application with Gradle](#create-a-java-application-with-gradle)
- [Develop the build file `build.gradle`](#develop-the-build-file-buildgradle)
  - [Add the third Package `Gson` to the Gradle build file `build.gradle`](#add-the-third-package-gson-to-the-gradle-build-file-buildgradle)
  - [build the file `build.gradle`](#build-the-file-buildgradle)
- [Develop the Java application with the Third Package `Gson`](#develop-the-java-application-with-the-third-package-gson)
  - [change the Java Code](#change-the-java-code)
  - [run the Java application on project](#run-the-java-application-on-project)
- [Package the Java application](#package-the-java-application)
  - [build the project](#build-the-project)
  - [run the Java application on different OS System](#run-the-java-application-on-different-os-system)
- [Download and Use This compelete Project](#download-and-use-this-compelete-project)
- [Tip 1: About `applicationName` and `rootProject.name`](#tip-1-about-applicationname-and-rootprojectname)
- [Tip 2: About `mvnrepository.com`](#tip-2-about-mvnrepositorycom)
- [References](#references)



## Keywords
- Third Package Library
- Ubuntu Java Gradle tutorial example `Continuous Integration` CI `Continuous Deployment` CD CircleCI



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create a Java Application with Gradle

```bash
git clone -b basic_105 https://github.com/cnruby/gradle_java.git 106_gradle_java
cd 106_gradle_java
sed -i 's/basic_105/basic_106/g' build.gradle
sed -i 's/'1.0.5'/'1.0.6'/g' build.gradle
```



## Develop the build file `build.gradle`

### Add the third Package `Gson` to the Gradle build file `build.gradle`


vi ./build.gradle
```

```bash
# FILE (./build.gradle)
...
dependencies {
  implementation 'org.json:json:20201115'
...
```

### build the file `build.gradle`

```bash
./gradlew
```



## Develop the Java application with the Third Package `Gson`

### change the Java Code

```bash
vi src/main/java/basic_106/App.java
```

```bash
# FILE (src/main/java/basic_106/App.java)
...
        System.out.println(new App().getGreeting());

        LongStream obj = new Random().longs(5,0,10);
        String json = new Gson().toJson(obj.toArray());

        System.out.println("json = " + json);
...
```

### run the Java application on project

```bash
./gradlew run
```

Result:

```bash
> Task :run
Hello world.
json = [3,5,7,6,7]

BUILD SUCCESSFUL in 467ms
2 actionable tasks: 2 executed
```



## Package the Java application
 
### build the project 
```bash
./gradlew clean build
```

### run the Java application on different OS System

```bash
unzip build/distributions/_gradle_java.zip 
./_gradle_java/bin/basic_106
```

Result:

```bash
Hello world.
json = [2,3,9,8,6]
```



## Download and Use This compelete Project

```bash
# Download
git clone -b basic_106 https://github.com/cnruby/gradle_java.git basic_106
```

```bash
# Use
cd basic_106
./gradlew run
```



## Tip 1: About `applicationName` and `rootProject.name`
- About the `applicationName` in the `build.gradle`
- About the `rootProject.name` in the `settings.gradle`

![basic_106](doc/image/basic_106.png)



## Tip 2: About `mvnrepository.com`
- The Package Information come from https://mvnrepository.com/

![basic_106_1](doc/image/basic_106-2020-12-13_11-31.png)
![basic_106_2](doc/image/basic_106-2020-12-13_12-31.png)
![basic_106_3](doc/image/basic_106-2020-12-13_13-31.png)



## References
- https://github.com/johnrengelman/shadow