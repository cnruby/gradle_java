<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>


[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_107.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_107)



basic_107 Hello Gradle Task!
<h1>Lesson 107: Hello Gradle Task!</h1>

- Develop a Gradle Task with Groovy

---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java Application with Gradle](#create-a-java-application-with-gradle)
- [Develop Gradle Task `releaseRun` for Java Application](#develop-gradle-task-releaserun-for-java-application)
  - [add new task for the file `./build.gradle`](#add-new-task-for-the-file-buildgradle)
  - [execute the Gradle task](#execute-the-gradle-task)
- [Download and Use This complete Project](#download-and-use-this-complete-project)
- [References](#references)



## Keywords
- `Grade Task` Grovvy
- Ubuntu Java Gradle tutorial example
- `Continuous Integration` CI `Continuous Deployment` CD CircleCI



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create a Java Application with Gradle

```bash
# DO (Get the initial Project from GitHub.com)
EXISTING_APP_ID=105 && NEW_APP_ID=107 && \
git clone -b basic_$EXISTING_APP_ID      \
https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
cd ${NEW_APP_ID}_gradle_java

# DO (change the project id to new project id)
./change_app_id.sh $NEW_APP_ID
```



## Develop Gradle Task `releaseRun` for Java Application

### add new task for the file `./build.gradle`

```bash
# DO (edit the build file `./build.gradle`)
vi ./build.gradle

    # FILE (./build.gradle)
    ...
    task releaseRun {
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

### execute the Gradle task


```bash
# DO (check the gradle task)
./gradlew help --task releaseRun


    # >> Result
    > Task :help
    Detailed task information for releaseRun

    Path
        :releaseRun

    Type
        Task (org.gradle.api.Task)

    Description
        Unzip release version and run the application

    Group
        de.iotoi

    BUILD SUCCESSFUL in 1s
    1 actionable task: 1 executed
```

```bash
# DO (run the new gradle task `releaseRun`)
./gradlew releaseRun

    # >> Result
    > Task :releaseRun
    Hello world.

    BUILD SUCCESSFUL in 1s
    1 actionable task: 1 executed
```



## Download and Use This complete Project

```bash
# DO (download the whole project)
APP_ID=107 && git clone -b basic_${APP_ID}  \
https://github.com/cnruby/gradle_java.git basic_${APP_ID} \
cd basic_${APP_ID}
```

```bash
# Do (execute the application with two methods)
./gradlew run

./gradlew clean build
./gradlew releaseRun
```



## References
- https://www.unix.com/shell-programming-and-scripting/179833-getting-first-two-characters-variable.html
- https://stackoverflow.com/questions/159148/groovy-executing-shell-commands
- https://stackoverflow.com/questions/30020286/how-can-i-specify-a-category-for-a-gradle-task
- https://www.cyberciti.biz/faq/how-to-use-sed-to-find-and-replace-text-in-files-in-linux-unix-shell/