<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>



[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![GitHub release (latest by date)](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_103.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_103)



<h1>Lesson 103: Hello `gradlew` and Java!</h1>

- develop Java application with `gradlew`
- upgrade a project-wide gradle version to the another


---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java application with `gradlew`](#create-a-java-application-with-gradlew)
- [The Version-based project with Gradle `wrapper`](#the-version-based-project-with-gradle-wrapper)
  - [show the Gradle version 6.6.1 on the local system](#show-the-gradle-version-661-on-the-local-system)
  - [add the fixed-version Gradle to the project](#add-the-fixed-version-gradle-to-the-project)
  - [show the project's Gradle version with the command `./gradlew`](#show-the-projects-gradle-version-with-the-command-gradlew)
- [change the fiexd-version project from current Gradle version 6.6.1 to 6.7.1](#change-the-fiexd-version-project-from-current-gradle-version-661-to-671)
  - [change the project Gradle version](#change-the-project-gradle-version)
  - [update the project's Gradle version](#update-the-projects-gradle-version)
  - [check System's Gradle version and Project's Gradle version](#check-systems-gradle-version-and-projects-gradle-version)
- [Develop the Java Application](#develop-the-java-application)
  - [compile the Java application](#compile-the-java-application)
  - [run the Java application](#run-the-java-application)
  - [test the Java application](#test-the-java-application)
- [Package the Java Application](#package-the-java-application)
  - [build the Java application](#build-the-java-application)
  - [run the Java application on different OS System:](#run-the-java-application-on-different-os-system)
- [Download and Use This compelete Project](#download-and-use-this-compelete-project)
- [Help: What is it? "Deprecated Gradle features were used in this build"](#help-what-is-it-deprecated-gradle-features-were-used-in-this-build)
- [Tips](#tips)
- [References](#references)
- [References for Tips](#references-for-tips)



## Keywords
- gradlew wrapper `Project Gradle version` `Environment System version` 
- Ubuntu Java Gradle tutorial example



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)



## Create a Java application with `gradlew`

```bash
git clone -b basic_102 https://github.com/cnruby/gradle_java.git basic_103
cd basic_103
```



## The Version-based project with Gradle `wrapper`

### show the Gradle version 6.6.1 on the local system

```bash
gradle -v
```

Result:

```bash
------------------------------------------------------------
Gradle 6.6.1
------------------------------------------------------------

Build time:   2020-08-25 16:29:12 UTC
Revision:     f2d1fb54a951d8b11d25748e4711bec8d128d7e3

Kotlin:       1.3.72
Groovy:       2.5.12
Ant:          Apache Ant(TM) version 1.10.8 compiled on May 10 2020
JVM:          1.8.0_265 (Private Build 25.265-b01)
OS:           Linux 5.8.0-29-generic amd64
```

### add the fixed-version Gradle to the project
```bash
gradle wrapper
```

Result:

```bash
BUILD SUCCESSFUL in 404ms
1 actionable task: 1 executed
```

### show the project's Gradle version with the command `./gradlew`
```bash
./gradlew -v
```

Result:

```bash
------------------------------------------------------------
Gradle 6.6.1
------------------------------------------------------------

Build time:   2020-08-25 16:29:12 UTC
Revision:     f2d1fb54a951d8b11d25748e4711bec8d128d7e3

Kotlin:       1.3.72
Groovy:       2.5.12
Ant:          Apache Ant(TM) version 1.10.8 compiled on May 10 2020
JVM:          1.8.0_265 (Private Build 25.265-b01)
OS:           Linux 5.8.0-29-generic amd64
```



## change the fiexd-version project from current Gradle version 6.6.1 to 6.7.1

### change the project Gradle version
```bash
vi gradle/wrapper/gradle-wrapper.properties
```

```bash
# gradle-wrapper.properties
...
distributionUrl=https\://services.gradle.org/distributions/gradle-6.7.1-bin.zip
...
```

### update the project's Gradle version
```bash
./gradlew
```

Result:

```bash
Downloading https://services.gradle.org/distributions/gradle-6.7.1-bin.zip
.........10%..........20%..........30%..........40%..........50%.........60%..........70%..........80%..........90%..........100%

Welcome to Gradle 6.7.1!

Here are the highlights of this release:
 - File system watching is ready for production use
 - Declare the version of Java your build requires
 - Java 15 support

For more details see https://docs.gradle.org/6.7.1/release-notes.html

Starting a Gradle Daemon (subsequent builds will be faster)

> Task :help

Welcome to Gradle 6.7.1.

To run a build, run gradlew <task> ...

To see a list of available tasks, run gradlew tasks

To see a list of command-line options, run gradlew --help

To see more detail about a task, run gradlew help --task <task>

For troubleshooting, visit https://help.gradle.org

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.7.1/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 1m 10s
1 actionable task: 1 executed
```

### check System's Gradle version and Project's Gradle version


```bash
# system's Gradle version
gradle -v
```

Result:

```bash
------------------------------------------------------------
Gradle 6.6.1
------------------------------------------------------------

Build time:   2020-08-25 16:29:12 UTC
Revision:     f2d1fb54a951d8b11d25748e4711bec8d128d7e3

Kotlin:       1.3.72
Groovy:       2.5.12
Ant:          Apache Ant(TM) version 1.10.8 compiled on May 10 2020
JVM:          1.8.0_265 (Private Build 25.265-b01)
OS:           Linux 5.8.0-29-generic amd64
```


```bash
# project's Gradle version
./gradlew -v
```

Result:

```bash
------------------------------------------------------------
Gradle 6.7.1
------------------------------------------------------------

Build time:   2020-11-16 17:09:24 UTC
Revision:     2972ff02f3210d2ceed2f1ea880f026acfbab5c0

Kotlin:       1.3.72
Groovy:       2.5.12
Ant:          Apache Ant(TM) version 1.10.8 compiled on May 10 2020
JVM:          11.0.9 (Azul Systems, Inc. 11.0.9+11-LTS)
OS:           Linux 5.8.0-29-generic amd64
```



## Develop the Java Application

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
./_gradle_java/bin/basic_103
```

Result:

```bash
Hello world.
```



## Download and Use This compelete Project

```bash
# Download
git clone -b basic_103 https://github.com/cnruby/gradle_java.git basic_103
```

```bash
# Use
cd basic_103
./gradlew run
```



## Help: What is it? "Deprecated Gradle features were used in this build"
- "Deprecated Gradle features" in the future Gradle version can exists in the file `build.gradle`

- Step 1: Download this project

- Step 2: comment Line 35 in the file `build.gradle`, and uncommit Line 36 in the file `build.gradle`

- Step 3: run the follow command

```bash
./gradlew
```

Result:

```bash
Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
```

- Step 4: Use the follow command to show the individual deprecation warnings:

```bash
./gradlew --warning-mode all
```

```bash
> Configure project :
The JavaApplication.setMainClassName(String) method has been deprecated. This is scheduled to be removed in Gradle 8.0. Use #getMainClass().set(...) instead. See https://docs.gradle.org/6.7.1/dsl/org.gradle.api.plugins.JavaApplication.html#org.gradle.api.plugins.JavaApplication:mainClass for more details.
        at build_dnxp4g90y74x2jrhwpp2kkyff$_run_closure4.doCall(/home/gudao/dev/java-ws/gradle-ws/103_gradle_java/build.gradle:36)
        (Run with --stacktrace to get the full stack trace of this deprecation warning.)
```

- Step 5: from this information we can comment Line 36 in the file `build.gradle`, and uncommit Line 35 in the file `build.gradle`

- Step 6: run the follow command

```bash
./gradlew
```

- Result exists NOT this message with "Deprecated Gradle features"! 
- The code "mainClassName"(i.e JavaApplication.setMainClassName(String)) were used in this build file `build.gradle`. This is a "Deprecated Gradle feature for the future Gradle version".
- Now The code "mainClass"(i.e JavaApplication.setMainClass(String)) is used in this build file. 




## Tips
- ALWAYS use the project's Gradle version to develop application. Use the system's Gradle to add wrapper to a project or create a new project etc.



## References
- https://snapcraft.io/install/gradle/mint#install
- https://gradle.org/install/
- https://spring.io/guides/gs/gradle/
- https://docs.gradle.org/current/userguide/build_init_plugin.html
- https://docs.gradle.org/current/samples/sample_building_java_applications.html
- https://services.gradle.org/distributions/

## References for Tips
- https://blog.mrhaki.com/2014/10/gradle-goodness-changing-name-of.html
- https://stackoverflow.com/questions/37512772/change-output-directory-of-generated-code-in-gradle
- https://docs.gradle.org/6.7.1/userguide/gradle_wrapper.html#sec:adding_wrapper
- https://www.baeldung.com/gradle-run-java-main
- https://newfivefour.com/gradle-run-jar-file.html
