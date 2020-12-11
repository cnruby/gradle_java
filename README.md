<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>


[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![GitHub release (latest by date)](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)



<h1>Lesson 102: Hello Gradle!</h1>

- install Gradle on Ubuntu 20.04
- develop Java application with Gradle

---


- [Keywords](#keywords)
- [Step 1: Prerequisites](#step-1-prerequisites)
- [Step 2: install Gradle on Ubuntu](#step-2-install-gradle-on-ubuntu)
- [Step 3: develop a Java application with Gradle](#step-3-develop-a-java-application-with-gradle)
  - [create a project with two Gradle files](#create-a-project-with-two-gradle-files)
  - [run Gradle `help` command](#run-gradle-help-command)
  - [add the Java code](#add-the-java-code)
  - [compile the Java application](#compile-the-java-application)
  - [Run the Java application on project](#run-the-java-application-on-project)
- [Package the Java application](#package-the-java-application)
  - [build the Java application](#build-the-java-application)
  - [run the Java application on different OS System:](#run-the-java-application-on-different-os-system)
- [Test the Java application](#test-the-java-application)
- [Download This Project](#download-this-project)
- [Tip:](#tip)
- [Main References](#main-references)
- [References](#references)
- [References for Tips](#references-for-tips)



## Keywords
- Gradle `Gradle Java Application` `Gradle tasks` 
- Ubuntu Java Testing Jar tutorial example



## Step 1: Prerequisites
- [install JDK](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)



## Step 2: install Gradle on Ubuntu

```bash
sudo snap install gradle --classic
gradle -v
```



## Step 3: develop a Java application with Gradle

### create a project with two Gradle files

```bash
touch settings.gradle
vi settings.gradle
touch build.gradle
vi build.gradle
```

### run Gradle `help` command

```bash
gradle
#gradle help
#gradle :help
```

### add the Java code

```bash
mkdir -p src/main/java/ src/test/java/
touch src/main/java/App.java
vi src/main/java/App.java
touch src/test/java/AppTest.java
vi src/test/java/AppTest.java
```

### compile the Java application

```bash
gradle compileJava
```

Result:

```bash
BUILD SUCCESSFUL in 305ms
1 actionable task: 1 up-to-date
```

### Run the Java application on project

```bash
gradle run
# gradle :run
```

Result:

```bash
Starting a Gradle Daemon, 2 incompatible and 1 stopped Daemons could not be reused, use --status for details

> Task :run
Hello world.

BUILD SUCCESSFUL in 356ms
2 actionable tasks: 1 executed, 1 up-to-date
```



## Package the Java application
 
### build the Java application

```bash
./gradlew clean build
```

### run the Java application on different OS System:

```bash
unzip build/distributions/_gradle_java.zip
./_gradle_java/bin/basic_102
```

Result:

```bash
Hello world.
```



## Test the Java application

```bash
gradle test
```

Result:

```bash
BUILD SUCCESSFUL in 710ms
3 actionable tasks: 3 executed
```

View Result for Test:

```bash
google-chrome build/reports/tests/test/index.html
```



## Download This Project

```bash
git clone -b basic_102 https://github.com/cnruby/gradle_java.git basic_102
```



## Tip:
- Do Not use the command `java -jar` to run the Java application.



## Main References
- https://stackoverflow.com/questions/20736537/gradle-application-plugin-building-multiple-start-scripts-dists-for-the-same
- https://docs.gradle.org/current/dsl/org.gradle.api.distribution.Distribution.html
- 

## References
- https://snapcraft.io/install/gradle/mint#install
- https://gradle.org/install/
- https://spring.io/guides/gs/gradle/
- https://docs.gradle.org/current/userguide/build_init_plugin.html
- https://docs.gradle.org/current/samples/sample_building_java_applications.html
- https://docs.gradle.org/current/samples/#java
- https://fossies.org/linux/kafka/build.gradle
- https://github.com/GoogleContainerTools/jib/blob/master/build.gradle
- https://github.com/elastic/elasticsearch/blob/master/settings.gradle

## References for Tips
- https://blog.mrhaki.com/2014/10/gradle-goodness-changing-name-of.html
- https://stackoverflow.com/questions/37512772/change-output-directory-of-generated-code-in-gradle
- https://docs.gradle.org/6.7.1/userguide/gradle_wrapper.html#sec:adding_wrapper
- https://www.baeldung.com/gradle-run-java-main
- https://newfivefour.com/gradle-run-jar-file.html

