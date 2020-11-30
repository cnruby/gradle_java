<h1>Lesson 2: Hello Gradle and Java!</h1>

- install JDK on Ubuntu 20.04
- install Gradle on Ubuntu 20.04
- develop Java application with Gradle

---

- [Step 1: Prerequisites](#step-1-prerequisites)
- [Step 2: install Gradle on Ubuntu](#step-2-install-gradle-on-ubuntu)
- [Step 3: develop a Java application with Gradle](#step-3-develop-a-java-application-with-gradle)
  - [create a project with Gradle](#create-a-project-with-gradle)
  - [run Gradle command](#run-gradle-command)
  - [add the Java code](#add-the-java-code)
  - [compile the Java application](#compile-the-java-application)
  - [run the Java application](#run-the-java-application)
  - [test the Java application](#test-the-java-application)
  - [build the Java application](#build-the-java-application)
  - [check the the file 'MANIFEST.MF'](#check-the-the-file-manifestmf)
  - [run the Java application with Jar:](#run-the-java-application-with-jar)
- [Error](#error)
  - [Error Information from Gradle](#error-information-from-gradle)
  - [Solution](#solution)
- [References](#references)
- [References for Tips](#references-for-tips)

## Step 1: Prerequisites
- [install JDK](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)

## Step 2: install Gradle on Ubuntu

```bash
sudo snap install gradle --classic
gradle -v
```

## Step 3: develop a Java application with Gradle

### create a project with Gradle

```bash
touch settings.gradle
vi settings.gradle
touch build.gradle
vi build.gradle
```

### run Gradle command

```bash
gradle
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

### run the Java application

```bash
gradle run
# gradle :run
```

Result:

```bash
> Task :run
Hello world.

BUILD SUCCESSFUL in 356ms
2 actionable tasks: 1 executed, 1 up-to-date
```

### test the Java application

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

### build the Java application
 
```bash
./gradlew clean build
```

### check the the file 'MANIFEST.MF'

```bash
cat build/tmp/jar/MANIFEST.MF
```

Result from the file 'MANIFEST.MF':

```bash
Manifest-Version: 1.0
Main-Class: App
```


### run the Java application with Jar:

```bash
java -jar build/libs/basic_102.jar
```

Result:

```bash
Hello world.
```



## Error

### Error Information from Gradle

```bash
no main manifest attribute, in .../basic_102.jar
```

### Solution

```bash
# build.gradle
...
jar {
    manifest {
        attributes(
                "Main-Class": 'App'
        )
    }
}
...
``` 


## References
- https://snapcraft.io/install/gradle/mint#install
- https://gradle.org/install/
- https://spring.io/guides/gs/gradle/
- https://docs.gradle.org/current/userguide/build_init_plugin.html
- https://docs.gradle.org/current/samples/sample_building_java_applications.html
- https://docs.gradle.org/current/samples/#java

## References for Tips
- https://blog.mrhaki.com/2014/10/gradle-goodness-changing-name-of.html
- https://stackoverflow.com/questions/37512772/change-output-directory-of-generated-code-in-gradle
- https://docs.gradle.org/6.7.1/userguide/gradle_wrapper.html#sec:adding_wrapper
- https://www.baeldung.com/gradle-run-java-main
- https://newfivefour.com/gradle-run-jar-file.html

