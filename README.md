<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IEAD Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_108.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_108)



basic_108
<h1>Lesson 108: Hello Gretty!</h1>

- Gretty: Advanced gradle plugin for running web-apps on jetty and tomcat.
- Develop A Web Application with Gretty

---



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Project with Gradle](#create-a-new-project-with-gradle)
- [Develop the Project](#develop-the-project)
- [Use the Project](#use-the-project)
  - [IF need (get help)](#if-need-get-help)
  - [ELSE ( start the application )](#else--start-the-application-)
- [Working Processes](#working-processes)
- [Problems](#problems)
  - [IF Exception(Address already in use)](#if-exceptionaddress-already-in-use)
- [Download and Use This complete Project](#download-and-use-this-complete-project)
- [Main's References](#mains-references)
- [References](#references)



## Keywords
- Gretty jetty tomcat `Web Application` `web-app` `gradle plugin` `web server`
- Ubuntu Java Gradle tutorial example
- `Continuous Integration` CI `Continuous Deployment` CD CircleCI



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [CircleCI Account](https://circleci.com/vcs-authorize/)


## Create A New Project with Gradle

```bash
# DO (open a new terminal)
mkdir 108_gradle_java 
cd 108_gradle_java
gradle init --type java-library
```



## Develop the Project

```bash
./gradlew clean build
```

```bash
mkdir -p src/main/webapp/WEB-INF
touch src/main/webapp/WEB-INF/web.xml
vi src/main/webapp/WEB-INF/web.xml
```

```bash
touch src/main/webapp/index.html
vi src/main/webapp/index.html
```

```bash
# DO (edit the build file)
vi build.gradle

    # FILE (build.gradle)
    ...
    apply plugin: 'war'
    apply from: 'https://raw.github.com/gretty-gradle-plugin/gretty/master/pluginScripts/gretty.plugin'

    ...
    gretty {
        httpPort = 8080
        contextPath = '/'
    }
```

```bash
# DO (create a package for the project)
./gradlew clean build
```



## Use the Project

### IF need (get help)
```bash
# DO (get the gralde help)
./gradlew tasks
```
### ELSE ( start the application )
```bash
    # DO (start webserver with web app)
    ./gradlew appRun
    # DO (Press any key to stop the server) IF need to stop the server

    # IF need (show result)
        # DO (open a new terminal)
        curl http://localhost:8080/
            # >> RESULT
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Hello Gretty!</title>
            </head>
            <body>
            <center>
                <h1>Hello Gretty!</h1>
            </center>
            </body>
            </html>
    # ENDIF IF Web Server is running.
# ENDIF
```



## Working Processes

```bash
# FOR loop
    # DO (change any code)
    ./gradlew appRun
    # Press any key to stop the server IF stop the server
# ENDFOR
```



## Problems

### IF Exception(Address already in use)
```bash
netstat -tapn | grep "8080"
sudo kill -9 <PROCESS_ID>
```



## Download and Use This complete Project

```bash
# DO (download the whole project)
APP_ID=108 && git clone -b basic_${APP_ID}  \
https://github.com/cnruby/gradle_java.git basic_${APP_ID} \
cd basic_${APP_ID}
```

```bash
# Do (execute the application)
./gradlew appRun
```



## Main's References
- https://jp.twilio.com/docs/usage/tutorials/how-to-set-up-your-java-and-servlets-development-environment

## References
- https://github.com/akhikhl/gretty
- https://medium.com/@kasunpdh/sample-java-web-application-using-servlets-and-jsp-5621cad2f582
- https://www.medien.ifi.lmu.de/lehre/ws1213/mmn/vorlesung/mmn3.pdf
- https://reqbin.com/req/c-dwjszac0/curl-post-json-example
- https://stackoverflow.com/questions/23640831/jetty-9-stop-port-and-key-in-command-line-arguments
- https://curl.se/docs/httpscripting.html
- https://reqbin.com/req/c-dwjszac0/curl-post-json-example
- https://www.deadcoderising.com/how-to-generate-a-stream-of-random-numbers-in-java/
- https://stackoverflow.com/questions/29475426/which-is-better-to-use-in-professionally-web-xmldeployment-descriptor-or-web
- https://backstage.forgerock.com/knowledge/kb/article/a15048811
- https://stackoverflow.com/questions/8164664/running-a-command-as-a-background-process-service