<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![IntelliJ IEAD Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![docker jetty-(9.4.35)](https://img.shields.io/github/v/release/eclipse/jetty.project?logo=jetty&style=plastic)](https://github.com/eclipse/jetty.project)
[![gretty-(2.0.0)](https://img.shields.io/github/v/tag/akhikhl/gretty?label=gretty&logo=gretty&style=plastic)](https://github.com/akhikhl/gretty)
[![CI--basic_120](https://github.com/cnruby/gradle_java/workflows/CI--basic_120/badge.svg?branch=basic_120)](https://github.com/cnruby/gradle_java/actions?query=workflow%3ACI--basic_120)
[![Release--basic_120](https://github.com/cnruby/gradle_java/workflows/Release--basic_120/badge.svg?branch=basic_120)](https://github.com/cnruby/gradle_java/actions)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_120.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_120)
[ ![Download](https://api.bintray.com/packages/cnruby/gradle_java_jcenter/basic_120/images/download.svg?version=0.120.1) ](https://bintray.com/cnruby/gradle_java_jcenter/basic_120/0.120.1/link)


--- 

!!! TODO basic_120 Hello Publishing Web App!
<h1>Lesson 120: Hello Publishing Web App!</h1>

- Publish A Web Application to Maven Local
- Publish A Web Application to JCenter


---


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create a Java Web Application from GitHub.com](#create-a-java-web-application-from-githubcom)
- [Use the Web Application from Maven Local](#use-the-web-application-from-maven-local)
  - [IF ( need to get help )](#if--need-to-get-help-)
  - [ELSE ( start the application )](#else--start-the-application-)
  - [Show Web Application Result](#show-web-application-result)
- [Publish Web Application to JCenter](#publish-web-application-to-jcenter)
  - [add bintray.com account](#add-bintraycom-account)
  - [change the build file `./build.gradle`](#change-the-build-file-buildgradle)
  - [publish web application](#publish-web-application)
- [Develop the Web Application on Project](#develop-the-web-application-on-project)
  - [IF ( need to get help )](#if--need-to-get-help--1)
  - [ELSE ( start the application )](#else--start-the-application--1)
  - [Show Web Application Result](#show-web-application-result-1)
- [Develop the Web Application on Local](#develop-the-web-application-on-local)
  - [IF ( need to get help )](#if--need-to-get-help--2)
  - [ELSE ( start the web application )](#else--start-the-web-application-)
  - [Show Web Application Result](#show-web-application-result-2)
- [Working Processes](#working-processes)
- [Download and Use This complete Project](#download-and-use-this-complete-project)
- [References](#references)



## Keywords
- bintray jcenter publish Gretty jetty `Web Application` `web-app` 
- Ubuntu Java Gradle tutorial example `gradle plugin` `web server`
- `Continuous Integration` CI `Continuous Deployment` CD CircleCI



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [CircleCI Account](https://circleci.com/vcs-authorize/)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- 



## Create a Java Web Application from GitHub.com

```bash
# DO (open a new terminal)
EXISTING_APP_ID=111 && NEW_APP_ID=120 \
&& git clone -b basic_${EXISTING_APP_ID} \
    https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

```bash
# DO (check)
./gradlew check
```



## Use the Web Application from Maven Local

```bash
# DO (publish war to maven local)
./gradlew clean build publishToMavenLocal

# DO (copy war file to project)
cp ~/.m2/repository/de/iotoi/basic_120/0.120.1/basic_120-0.120.1.war _gradle_java.war
```

```bash
# DO (edit the docker build file)
vi Dockerfile

    # FILE (./Dockerfile)
    FROM jetty

    # cp ~/.m2/repository/de/iotoi/basic_120/0.120.1/basic_120-0.120.1.war _gradle_java.war
    ADD /_gradle_java.war /var/lib/jetty/webapps/ROOT.war    
    EXPOSE 8080
```

### IF ( need to get help )
```bash
    ./gradlew tasks
```
### ELSE ( start the application )
```bash
    # DO (change any code)
    ./gradlew clean build

    docker build --tag=120_gradle_java .
    docker run -p 80:8080 120_gradle_java
    # IF stop the server
        # DO (Press Ctrl+C to stop the server) 
    # ENDIF
        # >> Result
        2020-12-18 11:33:40.121:INFO::main: Logging initialized @415ms to org.eclipse.jetty.util.log.StdErrLog
        2020-12-18 11:33:40.798:INFO:oejs.Server:main: jetty-9.4.35.v20201120; built: 2020-11-20T21:17:03.964Z; git: bdc54f03a5e0a7e280fab27f55c3c75ee8da89fb; jvm 11.0.9.1+1
        2020-12-18 11:33:40.863:INFO:oejdp.ScanningAppProvider:main: Deployment monitor [file:///var/lib/jetty/webapps/] at interval 1
        2020-12-18 11:33:42.071:INFO:oeja.AnnotationConfiguration:main: Scanning elapsed time=572ms
        2020-12-18 11:33:42.463:INFO:oejs.session:main: DefaultSessionIdManager workerName=node0
        2020-12-18 11:33:42.463:INFO:oejs.session:main: No SessionScavenger set, using defaults
        2020-12-18 11:33:42.466:INFO:oejs.session:main: node0 Scavenging every 600000ms
        2020-12-18 11:33:42.556:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@6fd83fc1{ROOT,/,file:///tmp/jetty/jetty-0_0_0_0-8080-ROOT_war-_-any-6326391873217820744/webapp/,AVAILABLE}{/var/lib/jetty/webapps/ROOT.war}
        2020-12-18 11:33:42.646:INFO:oejs.AbstractConnector:main: Started ServerConnector@6b98a075{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
        2020-12-18 11:33:42.649:INFO:oejs.Server:main: Started @2969ms
# ENDIF
```

### Show Web Application Result
```bash
    # DO (open a new terminal)
    google-chrome http://localhost:80/
        # >> Result
        Hello Publishing Web App!
    google-chrome http://localhost:80/hello
        # >> Result
        [8,3,2,1,8]
```



## Publish Web Application to JCenter


### add bintray.com account
```bash
# DO (copy a jcenter's username and password sample file)
cp ./jcenter.properties.sample ~/jcenter.properties

# DO (edit the real jcenter's username and password)
# !!! first sign in JCenter by jcenter's username and password              
nano ~/jcenter.properties

# DO (check the application `App`)
./gradlew -q check
    # >> Result: nothing
```

### change the build file `./build.gradle`
```bash
nano ./build.gradle
    # FILE (./build.gradle)
    plugins {
        id 'java-library'
        id 'com.jfrog.bintray' version '1.8.5'
        id 'maven-publish'
    }

    sourceCompatibility = JavaVersion.VERSION_11
    apply from: System.getenv("HOME") + "/jcenter.properties"
    apply plugin: 'war'
    apply from: 'https://raw.github.com/gretty-gradle-plugin/gretty/master/pluginScripts/gretty.plugin'

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        implementation group: 'javax.servlet', name: 'javax.servlet-api', version: '3.1.0'
        implementation 'com.google.code.gson:gson:2.8.6'
        implementation 'com.google.guava:guava:29.0-jre'
        testImplementation 'junit:junit:4.13'
    }

    gretty {
        httpPort = 8080
        contextPath = '/'
    }

    task sourcesJar(type: Jar, dependsOn: classes) {
        classifier = 'sources'
        from sourceSets.main.allSource
    }

    publishing{
        publications{
            "$project.name"(MavenPublication){
                from components.web
                groupId project.group
                artifactId project.applicationName
                version project.version
                artifact sourcesJar
            }
        }
    }

    bintray{
        user = project.bintrayUser
        key = project.bintrayApiKey
        publications = ["$project.name"]
        publish = true // !!!
        pkg{
            repo = project.bintrayRepo
            name = project.applicationName
            desc = project.description
            licenses = ['Apache-2.0']
            vcsUrl = project.vcsUrl
            labels = ['java, demo, jcenter, library, gradle, bintray, publish, example, tutorial']
            version {
                name = project.version
                released = new Date()
            }
        }
    }
```

### publish web application
```bash
# DO (Publish)
./gradlew clean build bintrayUpload

    # >> Result
    Task :bintrayUpload
    Uploading to https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_120/0.120.1/de/iotoi/basic_120/0.120.1/basic_120-0.120.1-sources.jar...
    Uploaded to 'https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_120/0.120.1/de/iotoi/basic_120/0.120.1/basic_120-0.120.1-sources.jar'.
    Uploading to https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_120/0.120.1/de/iotoi/basic_120/0.120.1/basic_120-0.120.1.war...
    Uploaded to 'https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_120/0.120.1/de/iotoi/basic_120/0.120.1/basic_120-0.120.1.war'.
    Uploading to https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_120/0.120.1/de/iotoi/basic_120/0.120.1/basic_120-0.120.1.pom...
    Uploaded to 'https://api.bintray.com/content/cnruby/gradle_java_jcenter/basic_120/0.120.1/de/iotoi/basic_120/0.120.1/basic_120-0.120.1.pom'.

    Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
    Use '--warning-mode all' to show the individual deprecation warnings.
    See https://docs.gradle.org/6.7.1/userguide/command_line_interface.html#sec:command_line_warnings

    BUILD SUCCESSFUL in 1m 23s
    8 actionable tasks: 6 executed, 2 up-to-date
```




## Develop the Web Application on Project

### IF ( need to get help )
```bash
    ./gradlew tasks | grep appRun
```
### ELSE ( start the application )
```bash
    # DO (change any code)    
    ./gradlew appRun
    # DO (Press any key to stop the server) IF stop the server
# ENDIF
```

### Show Web Application Result
```bash
    # DO (open a new terminal)
    curl http://localhost:8080/
        # >> Result
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Hello Publishing Web App!</title>
        </head>
        <body>
        <center>
            <h1>Hello Publishing Web App!</h1>
        </center>
        </body>
        </html>
    curl -L http://localhost:8080/hello
        # >> Result
        [8,3,2,1,8]
```



## Develop the Web Application on Local

### IF ( need to get help )
```bash
    ./gradlew tasks | grep archiveAllProducts
```
### ELSE ( start the web application )
```bash
    # DO (change any code)
    # DO (create a web application on local)
    ./gradlew archiveAllProducts
    # DO (start a web server with web application)
    ./build/output/_gradle_java/start.sh
    # IF stop the web server
        # DO (open a new terminal)
        # DO (stop the web server) 
        ./build/output/_gradle_java/stop.sh
    # ENDIF
# ENDIF
```

### Show Web Application Result
```bash
    # DO (open a new terminal)
    # DO (access the HTML file)
    curl http://localhost:8080/
        # >> Result
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Hello Publishing Web App!</title>
        </head>
        <body>
        <center>
            <h1>Hello Publishing Web App!</h1>
        </center>
        </body>
        </html>
    # DO (access the Java Servlet)
    curl -L http://localhost:8080/hello
        # >> Result
        [8,3,2,1,8]
```




## Working Processes

```bash
# FOR loop
    # DO (change any code )
    # IF use Gretty jetty to develop the web application on project
        # GOTO [Develop the Web Application on Project]
    # ENDIF
    # IF use Gretty jetty to develop the web application on local system
        # GOTO [Develop the Web Application on Local]
    # ENDIF
    # IF use jetty Docker to develop the web application
        # GOTO [Develop the Web Application on Docker]
    # ENDIF
# ENDFOR
```



## Download and Use This complete Project

```bash
# DO (download the whole project)
APP_ID=120 && git clone -b basic_${APP_ID}  \
    https://github.com/cnruby/gradle_java.git basic_${APP_ID} \
&& cd basic_${APP_ID}
```

```bash
# DO (Use the Project)
- [Project--"basic_120"--for--The--Release](https://github.com/cnruby/gradle_java/releases/tag/v0.120.1)
```



## References
- https://github.com/bintray/bintray-examples/blob/master/gradle-example/build.gradle