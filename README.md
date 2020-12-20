<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>


[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![GitHub release (latest by date)](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_114.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_114)
[![Release--basic_114](https://github.com/cnruby/gradle_java/workflows/Release--basic_114/badge.svg?branch=basic_114)](https://github.com/cnruby/gradle_java/actions)


---

basic_114
<h1>Lesson 114: Hello Simple Multi-Project!</h1>

- Delevop a multi-project with two completely independent Java Applictions
- Develop a multi-project from a project with single application


---


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java Project from GitHub.com](#create-a-java-project-from-githubcom)
- [Develop the Java multi-project](#develop-the-java-multi-project)
  - [view the structure of a multi-project](#view-the-structure-of-a-multi-project)
  - [change the setting file `settings.gradle`](#change-the-setting-file-settingsgradle)
- [add two subprojects to this project](#add-two-subprojects-to-this-project)
- [Develop the multi-project](#develop-the-multi-project)
  - [change the Java file for subproject `example`](#change-the-java-file-for-subproject-example)
  - [build the Java applications](#build-the-java-applications)
  - [run the java application for the subproject `app`](#run-the-java-application-for-the-subproject-app)
  - [run the java application for the subproject `example`](#run-the-java-application-for-the-subproject-example)
- [Download and Use This complete Project](#download-and-use-this-complete-project)
- [Referenecs](#referenecs)




## Keywords
- `Java Multi-Project` `gradle projects` `two applications`
- Ubuntu Java Gradle gradlew tutorial example



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)



## Create a Java Project from GitHub.com

```bash
# DO (open a new terminal)
EXISTING_APP_ID=104 && NEW_APP_ID=114 \
&& git clone -b basic_${EXISTING_APP_ID}  \
    https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

```bash
# DO (check the project)
./gradlew
```



## Develop the Java multi-project

### view the structure of a multi-project

```bash
# DO (check the multi-project)
./gradlew -q projects

    # >> Result
    ------------------------------------------------------------
    Root project
    ------------------------------------------------------------

    Root project '_gradle_java'
    No sub-projects
```

### change the setting file `settings.gradle`

```bash
# DO (edit the file "./settings.gradle")
nano ./settings.gradle

    # FILE (./settings.gradle)
    rootProject.name = '_gradle_java'
    include ("app", "example")


# DO (check the multi-project again)
./gradlew -q projects

    # >> Result
    ------------------------------------------------------------
    Root project
    ------------------------------------------------------------

    Root project '_gradle_java'
    +--- Project ':app'
    \--- Project ':example'
```


## add two subprojects to this project

```bash
# DO (make two subproject folders)
mkdir app example

# DO (copy the current project build file `build.gradle` to subprojects root folder)
xargs -n 1 cp -v build.gradle <<< "./app/ ./example/"

# DO (copy the current project `src` folder to subprojects root folder)
xargs -n 1 cp -vr src <<< "./app/ ./example/"

# DO (remvoe the the current project build file `build.gradle` and folder `src`)
rm build.gradle
rm -rf src
```

```bash
# DO (add description to subproject `app`)
nano app/build.gradle

    # FILE (app/build.gradle)
    ...
    description = 'The main application for the project'
    ...
```

```bash
# DO (add description to subproject `example`)
nano example/build.gradle

    # FILE (example/build.gradle)
    ...
    description = 'The example application for the subproject `app`'
    ...
```

```bash
# DO (check the multi-project again)
./gradlew -q projects

    # >> Result
    ------------------------------------------------------------
    Root project
    ------------------------------------------------------------

    Root project '_gradle_java'
    +--- Project ':app' - The main application for the project
    \--- Project ':example' - The example application for the subproject `app`
```



## Develop the multi-project

### change the Java file for subproject `example`

```bash
# DO (change the java file `example/src/main/java/de/iotoi/App.java`)
nano example/src/main/java/de/iotoi/App.java

    # FILE (example/src/main/java/de/iotoi/App.java)
    ...
    // return "Hello world.";
    return "Hallo Welt!";
    ...
```

### build the Java applications

```bash
# DO (build subproject `app` and `example`)
./gradlew clean app:build example:build

# DO (build all subprojects)
./gradlew clean build build
```

### run the java application for the subproject `app` 

```bash
./gradlew -q app:run

    # >> Result:
    Hello world.
```


### run the java application for the subproject `example`

```bash
./gradlew -q example:run

    # >> Result:
    Hallo Welt!
```



## Download and Use This complete Project

```bash
# Download
git clone -b basic_114 https://github.com/cnruby/gradle_java.git basic_114
```

```bash
# Usage for the project
google-chrome https://github.com/cnruby/gradle_java/releases/tag/v0.114.1
```



## Referenecs
- https://docs.github.com/en/free-pro-team@latest/actions/learn-github-actions/introduction-to-github-actions
- https://medium.com/@shanemyrick/publishing-to-github-packages-with-gradle-and-github-actions-4ad842634c4e
- https://www.flowsquad.io/blog/2020-05-29-devops-mit-github-teil-1-github-packages-mit-gradle/
- https://docs.github.com/en/free-pro-team@latest/packages/guides/configuring-gradle-for-use-with-github-packages
- https://docs.github.com/en/free-pro-team@latest/actions/guides/publishing-java-packages-with-gradle
- 