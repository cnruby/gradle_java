<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>


[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![GitHub release (latest by date)](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_118.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_118)
[![Release--basic_118](https://github.com/cnruby/gradle_java/workflows/Release--basic_118/badge.svg?branch=basic_118)](https://github.com/cnruby/gradle_java/actions)


---

!!! TODO basic_118 Hello Publishing Library!
<h1>Lesson 118: Hello Publishing Library!</h1>

- Delevop a multi-project with Java Appliction and Own Java Library
- Develop a multi-project from a project with single application


---


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java Project from GitHub.com](#create-a-java-project-from-githubcom)
- [Develop the Gradle build file](#develop-the-gradle-build-file)
  - [add a gralde properties file `gradle.properties`](#add-a-gralde-properties-file-gradleproperties)
- [Develop the subproject `lib`](#develop-the-subproject-lib)
  - [change the gradle build file `lib/build.gradle`](#change-the-gradle-build-file-libbuildgradle)
- [Develop the subproject `app`](#develop-the-subproject-app)
  - [change the gradle build file `app/build.gradle`](#change-the-gradle-build-file-appbuildgradle)
- [check, build and run the main Java application](#check-build-and-run-the-main-java-application)
- [Publish the Library](#publish-the-library)
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
EXISTING_APP_ID=115 && NEW_APP_ID=118 \
&& git clone -b basic_${EXISTING_APP_ID}  \
    https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

```bash
# DO (check the project)
./gradlew check
```



## Develop the Gradle build file

### add a gralde properties file `gradle.properties`

```bash
# DO (create a file ./gradle.properties)
touch ./gradle.properties

# DO (edit the file ./gradle.properties)
nano ./gradle.properties

    # FILE (./gradle.properties)
    applicationName=basic_118
    group=de.iotoi
    description=Hello Publishing Library!
    version=0.118.1
```



## Develop the subproject `lib`

### change the gradle build file `lib/build.gradle`

```bash
nano lib/build.gradle

    # FILE (lib/build.gradle)
    plugins {
        id 'java'
        id 'java-library'
        id 'com.jfrog.bintray' version '1.8.5'
        id 'maven-publish'
    }

    sourceCompatibility = JavaVersion.VERSION_11
    apply from: System.getenv("HOME") + "/jcenter.properties"

    repositories { jcenter() }
    dependencies {}
    test {}

    task sourcesJar(type: Jar, dependsOn: classes){
        classifier = 'sources'
        from sourceSets.main.allSource
    }

    artifacts{
        archives sourcesJar
    }

    publishing{
        publications{
            "$project.name"(MavenPublication){
                from components.java
                groupId project.findProperty("group")
                artifactId archivesBaseName
                version project.findProperty("version")
                artifact sourcesJar
            }
        }
    }

    bintray{
        user = project.findProperty("bintrayUser")
        key = project.findProperty("bintrayApiKey")
        publications = ["$project.name"]
        publish = true // !!!
        pkg{
            repo = 'gradle_java_jcenter'
            name = project.findProperty("applicationName")
            desc = project.findProperty("description")
            licenses = ['Apache-2.0']
            vcsUrl = 'https://github.com/cnruby/gradle_java'
            labels = ['java, demo, jcenter, library, gradle, bintray, publish']
            version {
                name = project.findProperty("version")
                released = new Date()
            }
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

    repositories { jcenter() }

    dependencies {
        implementation project(':lib')
    }

    application {
        mainClass = "de.iotoi.App"
    }

    test {}
```



## check, build and run the main Java application

```bash
# DO (build subproject `app` and `lib`)
./gradlew -q check
    # >> Result: nothing
```

```bash
# DO (build subproject `app` and `lib`)
./gradlew clean app:build
```

```bash
# DO (run the java application for the subproject `app` )
./gradlew -q app:run
    # >> Result:
    Hello world.
```


## Publish the Library

```bash
# DO (check)
./gradlew check
    # >> Result: nothing

# DO (build and publsih the java library)
./gradlew clean build bintrayPublish
    # >> Result
    > Task :lib:bintrayUpload
    Uploading to https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_118/0.118.1/de/iotoi/lib/0.118.1/lib-0.118.1-sources.jar...
    Uploaded to 'https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_118/0.118.1/de/iotoi/lib/0.118.1/lib-0.118.1-sources.jar'.
    Uploading to https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_118/0.118.1/de/iotoi/lib/0.118.1/lib-0.118.1.jar...
    Uploaded to 'https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_118/0.118.1/de/iotoi/lib/0.118.1/lib-0.118.1.jar'.
    Uploading to https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_118/0.118.1/de/iotoi/lib/0.118.1/lib-0.118.1.pom...
    Uploaded to 'https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_118/0.118.1/de/iotoi/lib/0.118.1/lib-0.118.1.pom'.

    Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
    Use '--warning-mode all' to show the individual deprecation warnings.
    See https://docs.gradle.org/6.7.1/userguide/command_line_interface.html#sec:command_line_warnings

    BUILD SUCCESSFUL in 8s
    8 actionable tasks: 5 executed, 3 up-to-date
```



## Download and Use This complete Project

```bash
# Download
git clone -b basic_118 https://github.com/cnruby/gradle_java.git basic_118
```

```bash
# Usage for the project
google-chrome https://github.com/cnruby/gradle_java/releases/tag/v0.118.1
```



## Referenecs
- https://docs.github.com/en/free-pro-team@latest/actions/learn-github-actions/introduction-to-github-actions
- https://medium.com/@shanemyrick/publishing-to-github-packages-with-gradle-and-github-actions-4ad842634c4e
- https://www.flowsquad.io/blog/2020-05-29-devops-mit-github-teil-1-github-packages-mit-gradle/
- https://docs.github.com/en/free-pro-team@latest/packages/guides/configuring-gradle-for-use-with-github-packages
- https://docs.github.com/en/free-pro-team@latest/actions/guides/publishing-java-packages-with-gradle
   