<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>


[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_104.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_104)
[![Release--basic_104](https://github.com/cnruby/gradle_java/workflows/Release--basic_104/badge.svg?branch=basic_104)](https://github.com/cnruby/gradle_java/actions)


---

basic_104 Hello Single Project!
<h1>Lesson 104: Hello Single Project!</h1>

- Delevop a Single Java Appliction with Gradle


---

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java application with Gradle](#create-a-java-application-with-gradle)
  - [create project folder](#create-project-folder)
  - [create a Java application with `gradle init`](#create-a-java-application-with-gradle-init)
  - [check the project's Gradle version](#check-the-projects-gradle-version)
- [Develop the Java application](#develop-the-java-application)
  - [change the build file `build.gradle`](#change-the-build-file-buildgradle)
  - [compile the Java application](#compile-the-java-application)
  - [run the Java application](#run-the-java-application)
  - [test the Java application](#test-the-java-application)
- [Package the Java Application](#package-the-java-application)
  - [build the Java application](#build-the-java-application)
  - [run the Java application on different OS System:](#run-the-java-application-on-different-os-system)
- [Download and Use This complete Project](#download-and-use-this-complete-project)



## Keywords
- `Single Java Project` `gradle init` package Groovy
- Ubuntu Java Gradle gradlew tutorial example



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)



## Create a Java application with Gradle

### create project folder

```bash
mkdir 104_gradle_java/ && cd 104_gradle_java/
```

### create a Java application with `gradle init`

```bash
gradle init
```

Result:

```bash
Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Swift
Enter selection (default: Java) [1..5] 3

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Groovy) [1..2] 1

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit 4) [1..4] 4

Project name (default: 104_gradle_java): _gradle_java
Source package (default: gradle_java): de.iotoi

> Task :init
Get more help with your project: https://docs.gradle.org/6.6.1/userguide/tutorial_java_projects.html

BUILD SUCCESSFUL in 28s
2 actionable tasks: 2 executed
```

### check the project's Gradle version

```bash
./gradlew
#./gradlew help
```

Result:

```bash
Welcome to Gradle 6.6.1.

To run a build, run gradlew <task> ...

To see a list of available tasks, run gradlew tasks

To see a list of command-line options, run gradlew --help

To see more detail about a task, run gradlew help --task <task>

For troubleshooting, visit https://help.gradle.org
```



## Develop the Java application

### change the build file `build.gradle`

```bash
# build.gradle
...
startScripts {
    applicationName = 'basic_104'
    group = 'de.iotoi'
    # version = '1.0.4'
    sourceCompatibility = 11
}
...
```

### compile the Java application

```bash
./gradlew compileJava
#./gradlew :compileJava
```

### run the Java application

```bash
./gradlew run
#./gradlew :run
```

Result:

```bash
> Task :run
Hello world.

BUILD SUCCESSFUL in 422ms
2 actionable tasks: 2 executed
```

### test the Java application

```bash
./gradlew test
#./gradlew :test
```



## Package the Java Application

### build the Java application
 
```bash
./gradlew clean build
```

### run the Java application on different OS System:

```bash
unzip build/distributions/_gradle_java.zip
./_gradle_java/bin/basic_104
```

Result:

```bash
Hello world.
```



## Download and Use This complete Project

```bash
# Download
git clone -b basic_104 https://github.com/cnruby/gradle_java.git basic_104
```

```bash
# 1. Usage for the project

# DO (build and run the application `App`)
./gradlew run

# 2. Usage for OS

# DO (Install the project as a distribution as-is)
./gradlew installDist

# DO (run the application `App` for Ubuntu OS)
./build/install/_gradle_java/bin/basic_104

# DO (run the application `App` for Winsows OS)
./build/install/_gradle_java/bin/basic_104.bat
