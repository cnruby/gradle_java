<h1>Lesson 103: Hello `gradlew` and Java!</h1>

- develop Java application with `gradlew`

---

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Develop a Java application with `gradlew`](#develop-a-java-application-with-gradlew)
  - [get initial project](#get-initial-project)
  - [change the project name to `basic_103`](#change-the-project-name-to-basic_103)
  - [add the project with `wrapper`](#add-the-project-with-wrapper)
  - [change the project Gradle version from 6.6.1 to 6.7.1](#change-the-project-gradle-version-from-661-to-671)
  - [check Environment Gradle and Project Gradle](#check-environment-gradle-and-project-gradle)
  - [compile the Java application](#compile-the-java-application)
  - [run the Java application](#run-the-java-application)
  - [test the Java application](#test-the-java-application)
  - [build the Java application](#build-the-java-application)
  - [run the Java application with Jar:](#run-the-java-application-with-jar)
- [References](#references)
- [References for Tips](#references-for-tips)


## Keywords
- gradlew wrapper `Project Gradle version` `Environment System version` 
- Ubuntu Java Gradle tutorial example

## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)

## Develop a Java application with `gradlew`

### get initial project

```bash
git clone https://github.com/cnruby/gradle_java.git basic_103
cd basic_103
git switch basic_102
```

### change the project name to `basic_103`

```bash
vi settings.gradle
```

### add the project with `wrapper`

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

```bash
gradle wrapper
```

Result:

```bash
BUILD SUCCESSFUL in 404ms
1 actionable task: 1 executed
```

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

### change the project Gradle version from 6.6.1 to 6.7.1

```bash
vi gradle/wrapper/gradle-wrapper.properties
```

```bash
# gradle-wrapper.properties
...
distributionUrl=https\://services.gradle.org/distributions/gradle-6.7.1-bin.zip
...
```

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

### check Environment Gradle and Project Gradle

```bash
# Environment Gradle version
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
# Project Gradle version
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

### build the Java application
 
```bash
./gradlew clean build
```

### run the Java application with Jar:

```bash
java -jar build/libs/basic_103.jar
```

Result:

```bash
Hello world.
```


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
