<h1>Lesson 104: Hello Single Project!</h1>

- delevop a Single Java Appliction with `gradlew`


---

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java application with Gradle](#create-a-java-application-with-gradle)
  - [create project folder](#create-project-folder)
  - [create a Java application with `gradle init`](#create-a-java-application-with-gradle-init)
  - [check the project Gradle version](#check-the-project-gradle-version)
- [programm the Java application](#programm-the-java-application)
  - [change the build file `build.gradle`](#change-the-build-file-buildgradle)
  - [compile the Java application](#compile-the-java-application)
  - [run the Java application](#run-the-java-application)
  - [test the Java application](#test-the-java-application)
  - [build the Java application](#build-the-java-application)
  - [run the Java application with Jar:](#run-the-java-application-with-jar)


## Keywords
- `Single Java Project` `gradle init` package
- Groovy
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

Project name (default: 104_gradle_java): gradle_java
Source package (default: gradle_java): basic_104

> Task :init
Get more help with your project: https://docs.gradle.org/6.6.1/userguide/tutorial_java_projects.html

BUILD SUCCESSFUL in 28s
2 actionable tasks: 2 executed
```

### check the project Gradle version

```bash
./gradlew -w
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

## programm the Java application

### change the build file `build.gradle`

```bash
# build.gradle
...
ext {
    javaMain = "basic_104.App"
}

application {
    // Define the main class for the application.
    mainClassName = javaMain
}

jar {
    manifest {
        attributes(
                "Main-Class": javaMain
        )
    }
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

### build the Java application
 
```bash
./gradlew clean build
```

### run the Java application with Jar:

```bash
java -jar build/libs/gradle_java.jar
```

Result:

```bash
Hello world.
```


