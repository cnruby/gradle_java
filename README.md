<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>


[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![GitHub release (latest by date)](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_123.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_123)
[![Release--basic_123](https://github.com/cnruby/gradle_java/workflows/Release--basic_123/badge.svg?branch=basic_123)](https://github.com/cnruby/gradle_java/actions)


---

basic_123 Hello Multi-Project
<h1>Lesson 123: Hello Multi-Project!</h1>

- Develop a multi-project with Java Application and Java Library


---


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Map for the project](#map-for-the-project)
- [Create a Multi-Project from GitHub.com](#create-a-multi-project-from-githubcom)
  - [](#)
- [The gradle build files for the multi-project](#the-gradle-build-files-for-the-multi-project)
  - [Add the gradle build file for the root project](#add-the-gradle-build-file-for-the-root-project)
  - [change the gradle build file for the sub-project `app`](#change-the-gradle-build-file-for-the-sub-project-app)
  - [change the gradle build file for the sub-project `lib`](#change-the-gradle-build-file-for-the-sub-project-lib)
  - [Check the multi-project](#check-the-multi-project)
  - [view the structure of a multi-project](#view-the-structure-of-a-multi-project)
  - [change the setting file `settings.gradle`](#change-the-setting-file-settingsgradle)
  - [Tree for the Version](#tree-for-the-version)
- [Multi-Project Version 1.0](#multi-project-version-10)
  - [Develop this Version 1.0](#develop-this-version-10)
  - [Tree for The Version 1.0](#tree-for-the-version-10)
- [Multi-Project Version 2.0](#multi-project-version-20)
  - [Develop this Version 2.0](#develop-this-version-20)
  - [Tree for The Version 2.0](#tree-for-the-version-20)
- [Multi-Project Version 2.1](#multi-project-version-21)
  - [Develop this Version 2.1](#develop-this-version-21)
  - [Tree for The Version 2.1](#tree-for-the-version-21)
- [Download and Use This complete Project](#download-and-use-this-complete-project)
- [References](#references)




## Keywords
- `Java Multi-Project` `gradle projects` `java library`
- Ubuntu Java Gradle gradlew tutorial example library



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)



## Map for the project
![]()



## Create a Multi-Project from GitHub.com

### 
```bash
# DO (open a new terminal)
EXISTING_APP_ID=111 && NEW_APP_ID=123 \
&& git clone -b basic_${EXISTING_APP_ID}  \
    https://github.com/cnruby/gradle_java.git ${NEW_APP_ID}_gradle_java \
&& cd ${NEW_APP_ID}_gradle_java
```

```bash
# DO (check the project)
./gradlew -q check
    # >> Result: nothing
./gradlew -q app:run
    # >> Result
    Hello world.
```



## The gradle build files for the multi-project

### Add the gradle build file for the root project

```bash
touch ./build.gradle
nano ./build.gradle
    # FILE (./build.gradle)
    plugins {
        id 'java'
    }

    sourceCompatibility = JavaVersion.VERSION_11
    description = 'This is a multi-project'

    repositories {
        mavenCentral()
        jcenter()
    }
```

### change the gradle build file for the sub-project `app`

```bash
touch ./app/build.gradle
nano ./app/build.gradle
    # FILE (./app/build.gradle)
    plugins {
        id 'application'
    }

    startScripts {
        applicationName = 'basic_115'
        group = 'de.iotoi'
    } 
    description = 'The main application for the project'

    dependencies { implementation project(':lib') }
    application { mainClass = "de.iotoi.App" }
    test {}
```

### change the gradle build file for the sub-project `lib`

```bash
touch ./lib/build.gradle
nano ./lib/build.gradle
    # FILE (./lib/build.gradle)
    plugins {
        id 'java-library'
    }

    description = 'The library application for the project'

    dependencies { }
```

### Check the multi-project
```bash
# DO (check the project)
./gradlew -q check
    # >> Result: nothing

# DO (run the application)
./gradlew -q app:run
    # >> Result
    Hello world.
```

### view the structure of a multi-project

```bash
# DO (check the multi-project)
./gradlew -q projects

    # >> Result
    ------------------------------------------------------------
    Root project - This is a multi-project
    ------------------------------------------------------------

    Root project '_gradle_java' - This is a multi-project
    +--- Project ':app' - The main application for the project
    \--- Project ':lib' - The library application for the project

    To see a list of the tasks of a project, run gradlew <project-path>:tasks
    For example, try running gradlew :app:tasks
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


### Tree for the Version

```
.
├── app
│  ├── build.gradle
│  └── src
├── build.gradle
├── lib
│  ├── build.gradle
│  └── src
└── settings.gradle
```



## Multi-Project Version 1.0

### Develop this Version 1.0
```bash
# DO (make a folder for many sub-projects)
mkdir codename

# DO (move the sub-project 'lib' to the folder 'codename')
mv ./lib/ ./codename

# DO (change the gradle settings file 'settings.gradle')
cp ./settings.gradle.v0 ./settings.gradle
    # FILE (./settings.gradle.v0)
    rootProject.name = '_gradle_java'
    include ("app", "lib")
```

```bash
# DO (run the application)
./gradlew app:run
    # Result
    FAILURE: Build failed with an exception.

    * What went wrong:
    Could not determine the dependencies of task ':app:run'.
    > Could not resolve all task dependencies for configuration ':app:runtimeClasspath'.
    > Could not resolve project :lib.
        Required by:
            project :app
        > No matching configuration of project :lib was found. The consumer was configured to find a runtime of a library compatible with Java 11, packaged as a jar, and its dependencies declared externally but:
            - None of the consumable configurations have attributes.

    * Try:
    Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.

    * Get more help at https://help.gradle.org

    BUILD FAILED in 1s
```

```bash
# DO (change the gradle settings file 'settings.gradle')
cp ./settings.gradle.v1 ./settings.gradle
    # FILE (./settings.gradle.v1)
    rootProject.name = '_gradle_java'
    include ("app", "lib")

    for (project in rootProject.children) {
        project.projectDir = file("codename/${project.name}")
    }
```

```bash
# DO (run the application)
./gradlew app:run
    # Result
    FAILURE: Build failed with an exception.

    * What went wrong:
    Task 'run' not found in project ':app'.

    * Try:
    Run gradlew tasks to get a list of available tasks. Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.

    * Get more help at https://help.gradle.org

    BUILD FAILED in 1s
```

```bash
# DO (change the gradle settings file 'settings.gradle')
cp ./settings.gradle.v2 ./settings.gradle
    # FILE (./settings.gradle.v2)
    rootProject.name = '_gradle_java'
    include ("lib")

    for (project in rootProject.children) {
        project.projectDir = file("codename/${project.name}")
    }

    include ("app")

# DO (run the application)
./gradlew -q app:run
    # Result
    Hello world.
```

### Tree for The Version 1.0

```
.
├── app
│  ├── build.gradle
│  └── src
│     ├── main
│     └── test
├── build.gradle
├── codename
│  └── lib
│     ├── build.gradle
│     └── src
└── settings.gradle
```



## Multi-Project Version 2.0

### Develop this Version 2.0
```bash
# DO (move the sub-project 'app' to the folder 'codename')
mv ./app/ ./codename

# DO (run the application)
./gradlew -q app:run
    # Result
    FAILURE: Build failed with an exception.

    * What went wrong:
    Task 'run' not found in project ':app'.

    * Try:
    Run gradlew tasks to get a list of available tasks. Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.

    * Get more help at https://help.gradle.org

    BUILD FAILED in 1s    
```

```bash
# DO (change the gradle settings file 'settings.gradle')
cp ./settings.gradle.v3 ./settings.gradle
    # FILE (./settings.gradle.v3)
    rootProject.name = '_gradle_java'
    include ("app", "lib")

    for (project in rootProject.children) {
        project.projectDir = file("codename/${project.name}")
    }

# DO (run the application)
./gradlew -q app:run
    # Result
    Hello world.
```

### Tree for The Version 2.0

```
.
├── build.gradle
├── codename
│  ├── app
│  │  ├── build.gradle
│  │  └── src
│  └── lib
│     ├── build.gradle
│     └── src
└── settings.gradle
```

## Multi-Project Version 2.1

### Develop this Version 2.1
```bash
mv ./codename/app/build.gradle ./codename/app/app.gradle
mv ./codename/lib/build.gradle ./codename/lib/lib.gradle
mv ./build.gradle ./root.gradle

# DO (change the gradle settings file 'settings.gradle')
cp ./settings.gradle.v4 ./settings.gradle
    # FILE (./settings.gradle.v4)
    rootProject.name = '_gradle_java'
    rootProject.buildFileName = "root.gradle"

    include ("app", "lib")
    for (project in rootProject.children) {
        project.projectDir = file("codename/${project.name}")    
        project.buildFileName = project.name + '.gradle'
    }

./gradlew -q app:run
    # Result
    Hello world.
```

### Tree for The Version 2.1

```
.
├── codename
│  ├── app
│  │  ├── app.gradle
│  │  └── src
│  └── lib
│     ├── lib.gradle
│     └── src
├── root.gradle
└── settings.gradle
```



## Download and Use This complete Project

```bash
# Download
git clone -b basic_123 https://github.com/cnruby/gradle_java.git basic_123
```

```bash
# Usage for the project
google-chrome https://github.com/cnruby/gradle_java/releases/tag/v0.123.1
```



## References
- https://docs.gradle.org/current/samples/sample_building_java_applications_multi_project.html
- https://www.iditect.com/how-to/52532455.html
- https://docs.gradle.org/current/userguide/intro_multi_project_builds.html
- https://github.com/bndtools/bnd/issues/2984
- 
   
