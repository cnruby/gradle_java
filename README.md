<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>


[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![GitHub release (latest by date)](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_115.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_115)
[![Release--basic_115](https://github.com/cnruby/gradle_java/workflows/Release--basic_115/badge.svg?branch=basic_115)](https://github.com/cnruby/gradle_java/actions)


---

basic_115
<h1>Lesson 115: Hello Own Library!</h1>

- Delevop a multi-project with Java Appliction and Own Java Library
- Develop a multi-project from a project with single application


---


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java Project from GitHub.com](#create-a-java-project-from-githubcom)
- [Develop the Java multi-project](#develop-the-java-multi-project)
  - [view the structure of a multi-project](#view-the-structure-of-a-multi-project)
  - [change the setting file `settings.gradle`](#change-the-setting-file-settingsgradle)
- [add two subprojects to this project](#add-two-subprojects-to-this-project)
- [Develop the subproject `lib`](#develop-the-subproject-lib)
  - [change the gradle build file `lib/build.gradle`](#change-the-gradle-build-file-libbuildgradle)
  - [change the Java file for subproject `lib`](#change-the-java-file-for-subproject-lib)
- [Develop the subproject `app`](#develop-the-subproject-app)
  - [change the gradle build file `app/build.gradle`](#change-the-gradle-build-file-appbuildgradle)
  - [change the Java file for subproject `app`](#change-the-java-file-for-subproject-app)
  - [build the main Java application](#build-the-main-java-application)
  - [run the java application for the subproject `app`](#run-the-java-application-for-the-subproject-app)
- [Download and Use This complete Project](#download-and-use-this-complete-project)
- [Referenecs](#referenecs)




## Keywords
- `Java Multi-Project` `gradle projects` `own java library`
- Ubuntu Java Gradle gradlew tutorial example library



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)



## Create a Java Project from GitHub.com

```bash
# DO (open a new terminal)
EXISTING_APP_ID=104 && NEW_APP_ID=115 \
&& git clone -b basic_${EXISTING_APP_ID}  \
    https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

```bash
# DO (check the project)
./gradlew check
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
    include ("app", "lib")


# DO (check the multi-project again)
./gradlew -q projects

    # >> Result
    ------------------------------------------------------------
    Root project
    ------------------------------------------------------------

    Root project '_gradle_java'
    +--- Project ':app'
    \--- Project ':lib'
```


## add two subprojects to this project

```bash
# DO (make two subproject folders)
mkdir app lib

# DO (copy the current project build file `build.gradle` to subprojects root folder)
xargs -n 1 cp -v build.gradle <<< "./app/ ./lib/"

# DO (copy the current project `src` folder to subprojects root folder)
xargs -n 1 cp -vr src <<< "./app/ ./lib/"

# DO (remvoe the the current project build file `build.gradle` and folder `src`)
rm build.gradle && rm -rf src

# DO (remove the testing java file)
rm app/src/test/java/de/iotoi/AppTest.java lib/src/test/java/de/iotoi/AppTest.java
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
# DO (add description to subproject `lib`)
nano lib/build.gradle

    # FILE (lib/build.gradle)
    ...
    // id 'application'
    id 'java-library'
    ...
    description = 'The library for the subproject `app`'
    ...
    // application {
    //     // Define the main class for the application.
    //     mainClass = "de.iotoi.App"
    // }
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
    \--- Project ':lib' - The library for the subproject `app`
```



## Develop the subproject `lib`


### change the gradle build file `lib/build.gradle`

```bash
nano lib/build.gradle

    # FILE (lib/build.gradle)
    plugins {
        id 'java'
        id 'java-library'
    }

    group = 'de.iotoi'
    sourceCompatibility = JavaVersion.VERSION_11

    description = 'The library for the subproject `app`'

    repositories {
        jcenter()
    }
    dependencies {}
    test {}
```

### change the Java file for subproject `lib`

```bash
# DO (change the java file `lib/src/main/java/de/iotoi/App.java`)
mv lib/src/main/java/de/iotoi/App.java lib/src/main/java/de/iotoi/Lib.java

    # FILE (lib/src/main/java/de/iotoi/Lib.java)
    package de.iotoi;

    public class Lib {
        public String getGreeting() {
            return "Hello world.";
        }
    }
```



## Develop the subproject `app`

### change the gradle build file `app/build.gradle`

```bash
nano app/build.gradle

    # FILE (app/build.gradle)
    plugins {
        id 'java'
        id 'application'
    }

    startScripts {
        applicationName = 'basic_115'
        group = 'de.iotoi'
        // version = '1.1.5'
        sourceCompatibility = JavaVersion.VERSION_11
    }

    description = 'The main application for the project'

    repositories {
        jcenter()
    }

    dependencies {
        implementation project(':lib')
    }

    application {
        mainClass = "de.iotoi.App"
    }

    test {}
```

### change the Java file for subproject `app`

```bash
# DO (change the java file `app/src/main/java/de/iotoi/App.java`)
nano app/src/main/java/de/iotoi/App.java

    # FILE (app/src/main/java/de/iotoi/App.java)
    package de.iotoi;

    public class App {
        public static void main(String[] args) {
            System.out.println(new Lib().getGreeting());
        }
    }
```

### build the main Java application

```bash
# DO (build subproject `app` and `lib`)
./gradlew clean app:build
```

### run the java application for the subproject `app` 

```bash
./gradlew -q app:run

    # >> Result:
    Hello world.
```



## Download and Use This complete Project

```bash
# Download
git clone -b basic_115 https://github.com/cnruby/gradle_java.git basic_115
```

```bash
# Usage for the project
google-chrome https://github.com/cnruby/gradle_java/releases/tag/v0.115.1
```



## Referenecs
- https://docs.github.com/en/free-pro-team@latest/actions/learn-github-actions/introduction-to-github-actions
- https://medium.com/@shanemyrick/publishing-to-github-packages-with-gradle-and-github-actions-4ad842634c4e
- https://www.flowsquad.io/blog/2020-05-29-devops-mit-github-teil-1-github-packages-mit-gradle/
- https://docs.github.com/en/free-pro-team@latest/packages/guides/configuring-gradle-for-use-with-github-packages
- https://docs.github.com/en/free-pro-team@latest/actions/guides/publishing-java-packages-with-gradle
   