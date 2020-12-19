<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IEAD Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_109.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_109)


---


basic_109
<h1>Lesson 109: Hello Servlet!</h1>

- Develop A Web Application with Servlet



- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Project with Gradle](#create-a-new-project-with-gradle)
- [Develop the Project](#develop-the-project)
- [Use the Project](#use-the-project)
  - [IF ( need to get help )](#if--need-to-get-help-)
  - [ELSE ( start the application )](#else--start-the-application-)
- [Working Processes](#working-processes)
- [Analyse the Url Route](#analyse-the-url-route)
  - [IF using ( `<url-pattern>/</url-pattern>` ) in the file 'web.xml'](#if-using--url-patternurl-pattern--in-the-file-webxml)
  - [ELSEIF using `(<url-pattern>/hello</url-pattern>)` in the file 'web.xml'](#elseif-using-url-patternhellourl-pattern-in-the-file-webxml)
- [Download and Use This complete Project](#download-and-use-this-complete-project)
- [Tip What is it? Deprecated Gradle features were used in this build](#tip-what-is-it-deprecated-gradle-features-were-used-in-this-build)
  - [Warning](#warning)
  - [Solution](#solution)
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
git clone -b basic_108 https://github.com/cnruby/gradle_java.git 109_gradle_java
cd 109_gradle_java
```

## Develop the Project

```bash
# DO (assembles and tests this project.)
./gradlew clean build
```

```bash
#DO (edit the build file `build.gradle`)
vi build.gradle

    # FILE (build.gradle)
    ...

    dependencies {
        implementation group: 'javax.servlet', name: 'javax.servlet-api', version: '3.1.0'
        implementation 'com.google.code.gson:gson:2.8.6'
    ...
```

```bash
# DO (assembles and tests this project again.)
./gradlew clean build
```

```bash
#DO (create a java servlet file)
touch src/main/java/de/iotoi/HelloWorldServlet.java
#DO (edit a java servlet file)
vi src/main/java/de/iotoi/HelloWorldServlet.java
```

```bash
# DO (assembles and tests this project.)
./gradlew clean build
```



## Use the Project

### IF ( need to get help )
```bash
    ./gradlew tasks
```
### ELSE ( start the application )
```bash
    ./gradlew appRun
    # Press any key to stop the server IF stop the server

    # IF ( need to show result )
        # DO (open a new terminal)
        curl http://localhost:8080/
            # >> Result
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Hello Servlet!</title>
            </head>
            <body>
            <center>
                <h1>Hello Servlet!</h1>
            </center>
            </body>
            </html>            
        curl -L http://localhost:8080/hello
            # >> Result
            [8,3,2,1,8]
    # ENDIF
# ENDIF
```



## Working Processes

```bash
# FOR loop
    # DO (change any code )
    ./gradlew appRun
    # Press any key to stop the server IF stop the server
# ENDFOR
```



## Analyse the Url Route

### IF using ( `<url-pattern>/</url-pattern>` ) in the file 'web.xml'
```bash
    # IF using ( contextPath = '/' ) in the file 'build.gradle'
        curl -L http://localhost:8080/
            # >> Result 
            [1,4,8,3,7]
    # ELSEIF using ( contextPath = '/goto_web_xml' )
        curl -L http://localhost:8080/
            # >> error
        curl -L http://localhost:8080/goto_web_xml
            # >> Result
            [2,4,9,3,7]
    # ElSE ... ENDIF
```

### ELSEIF using `(<url-pattern>/hello</url-pattern>)` in the file 'web.xml'
```bash
    # DO (open a terminal)
    # IF using ( contextPath = '/' )
        # !! We use this version
        curl -L http://localhost:8080/
        curl -L http://localhost:8080/index.html
            # >> Result
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Hello Servlet!</title>
            </head>
            <body>
            <center>
                <h1>Hello Servlet!</h1>
            </center>
            </body>
        curl -L http://localhost:8080/hello
            # >> Result
            [8,3,2,1,7]
    # ELSE using ( contextPath = '/goto_web_xml' )
        curl -L http://localhost:8080/
        curl -L http://localhost:8080/index.html
        curl -L http://localhost:8080/hello
            # >> error
        curl -L http://localhost:8080/goto_web_xml
            # >> Result
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Hello Servlet!</title>
            </head>
            <body>
            <center>
                <h1>Hello Servlet!</h1>
            </center>
            </body>
        curl -L http://localhost:8080/goto_web_xml/hello
            # >> Result
            [5,4,2,1,9] 
    # ElSE ... ENDIF
# ElSE ... ENDIF
```



## Download and Use This complete Project

```bash
# DO (download the whole project)
APP_ID=109 && git clone -b basic_${APP_ID}  \
https://github.com/cnruby/gradle_java.git basic_${APP_ID} \
cd basic_${APP_ID}
```

```bash
# DO (execute the application)
./gradlew appRun
```

```bash
# DO (use the application)
google-chrome http://localhost:8080/
    # >> Result
    Hello Servlet!

google-chrome http://localhost:8080/hello
    # >> Result
    [4,1,5,9,3]
```



## Tip What is it? Deprecated Gradle features were used in this build

### Warning
```bash
The compile configuration has been deprecated for dependency declaration. This will fail with an error in Gradle 7.0. Please use the implementation or api configuration instead. 
```

### Solution
```bash
#compile group: 'javax.servlet', name: 'javax.servlet-api', version: '3.1.0'
implementation group: 'javax.servlet', name: 'javax.servlet-api', version: '3.1.0'
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
- 