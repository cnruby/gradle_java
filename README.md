<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language%20with%20Gradle-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>



[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![CI--basic_116](https://github.com/cnruby/gradle_java/workflows/CI--basic_116/badge.svg?branch=basic_116)](https://github.com/cnruby/gradle_java/actions?query=workflow%3ACI--basic_116)
[![Release--basic_116](https://github.com/cnruby/gradle_java/workflows/Release--basic_116/badge.svg?branch=basic_116)](https://github.com/cnruby/gradle_java/actions?query=workflow%3ARelease--basic_116)


---


basic_116 Hello Gradle Properties!
<h1>Lesson 116: Hello Gradle Properties!</h1>

---


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Method 1: From System File](#method-1-from-system-file)
  - [add properties to system file `~/.bashrc`](#add-properties-to-system-file-bashrc)
  - [add a gradle task `propertiesSystem`](#add-a-gradle-task-propertiessystem)
  - [Use the properties from system file](#use-the-properties-from-system-file)
- [Method 2: From Gradle Properties File](#method-2-from-gradle-properties-file)
  - [add properties to gradle properties file `gradle.properties`](#add-properties-to-gradle-properties-file-gradleproperties)
  - [add a gradle task `propertiesGradle`](#add-a-gradle-task-propertiesgradle)
  - [Use the properties from gradle properties file](#use-the-properties-from-gradle-properties-file)
- [Method 3: From Groovy File](#method-3-from-groovy-file)
  - [add properties to groovy file `jcenter.properties`](#add-properties-to-groovy-file-jcenterproperties)
  - [add a gradle task `propertiesGroovy`](#add-a-gradle-task-propertiesgroovy)
  - [Use the properties from groovy file](#use-the-properties-from-groovy-file)
- [Use the properties for `./build.gradle`](#use-the-properties-for-buildgradle)
  - [Use the system properties for `./build.gradle`](#use-the-system-properties-for-buildgradle)
  - [Use the gradle properties for `./build.gradle`](#use-the-gradle-properties-for-buildgradle)
  - [Use the groovy properties for `./build.gradle`](#use-the-groovy-properties-for-buildgradle)
- [Tip: Use Gradle Tasks](#tip-use-gradle-tasks)


---

## Keywords
- `gradle properties` Gradle gradlew `gradle projects` groovy `system variable` 
- Ubuntu Java tutorial example



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)



## Method 1: From System File
- change real value for the follow commands

### add properties to system file `~/.bashrc`
```bash
# DO (add system variables to file "~/.bashrc")
echo "" >> ~/.bashrc
echo "# BINTRAY.com" >> ~/.bashrc
echo "export BINTRAY_USER=username" >> ~/.bashrc
echo "export BINTRAY_API_KEY=1234567890qwertyuiopasdfghjklzxcvbnm1234" >> ~/.bashrc
echo "export GPG_PASSPHRASE=password" >> ~/.bashrc
cat ~/.bashrc
    # >> Result
```

![bashrc](doc/image/basic_116-bashrc.png)

### add a gradle task `propertiesSystem`

```bash
# DO (edit the file "./build.gradle")
nano ./build.gradle
    # FILE (./build.gradle)
    ...
    task propertiesSystem {
        group = 'de.iotoi'
        description = 'Get Properties from system file'
        doLast {
            def sysBintrayUser = System.getenv("BINTRAY_USER")
            def sysBintrayApiKey = System.getenv('BINTRAY_API_KEY')
            def sysGpgPassphrase = System.getenv('GPG_PASSPHRASE')
            println "sysBintrayUser = " + sysBintrayUser
            println "sysBintrayApiKey = " + sysBintrayApiKey
            println "sysGpgPassphrase = " + sysGpgPassphrase
        }
    }
```

### Use the properties from system file
```bash
# DO (enable the system variables)
. ~/.bashrc

# DO (run all checks)
./gradlew -q check
    # >> Result: nothing
# DO (get properties from system file)
./gradlew -q propertiesSystem
    # >> Result:
    sysBintrayUser = username
    sysBintrayApiKey = 1234567890qwertyuiopasdfghjklzxcvbnm1234
    sysGpgPassphrase = password
```



## Method 2: From Gradle Properties File
- !!! WARNING: The `password` and `API Key` etc SHOULD NOT BE SAVED IN the file `gradle.properties`, please use the method 1 or 3.
- The gradle properties file name must be `gradle.properties` and in project's root folder
- change real value for the follow commands

### add properties to gradle properties file `gradle.properties`
```bash
# DO (create a gradle properties file)
touch ./gradle.properties
# DO (edit a gradle properties file)
nano ./gradle.properties

    # FILE (./gradle.properties)
    version="0.116.1"
```

### add a gradle task `propertiesGradle`
```bash
# DO (edit the file "./build.gradle")
nano ./build.gradle
    # FILE (./build.gradle)
    ...
    task propertiesGradle {
        group = 'de.iotoi'
        description = 'Get Properties from gradle properties file'

        doLast {
            def projectVersion = project.findProperty("version")

            println "projectVersion = " + projectVersion
        }
    }
```

### Use the properties from gradle properties file
```bash
# DO (run all checks)
./gradlew -q check
    # >> Result: nothing
# DO (get properties from gradle properties file)
./gradlew propertiesGradle
    # >> Result
    > Configure project :
    version = "0.116.1"

    > Task :propertiesGradle
    projectVersion = "0.116.1"

    BUILD SUCCESSFUL in 1s
    1 actionable task: 1 executed
```



## Method 3: From Groovy File
- !!! WARNING: The file `jcenter.properties` SHOULD NOT BE SAVED IN THIS PROJECT
- The groovy file name can be any ONE and saved in any FOLDER
- change real value for the follow commands 

### add properties to groovy file `jcenter.properties`
```bash
# DO (create a groovy file)
touch ../jcenter.properties
# DO (edit a groovy file)
nano ../jcenter.properties

    # FILE (./jcenter.properties)
    ext {
        bintrayUser = "username"
        bintrayApiKey = "1234567890qwertyuiopasdfghjklzxcvbnm1234"
        gpgPassphrase = "password"
    }
```

### add a gradle task `propertiesGroovy`
```bash
# DO (edit the file "./build.gradle")
nano ./build.gradle
    # FILE (./build.gradle)
    ...
    task propertiesGroovy {
        group = 'de.iotoi'
        description = 'Get Properties from groovy file'

        doLast {
            apply from: "../jcenter.properties" 
            def groovyBintrayUser = project.findProperty("bintrayUser")
            def groovyBintrayApiKey = project.findProperty("bintrayApiKey")
            def groovyGpgPassphrase = project.findProperty("gpgPassphrase")
            
            println "groovyBintrayUser = " + groovyBintrayUser
            println "groovyBintrayApiKey = " + groovyBintrayApiKey
            println "groovyGpgPassphrase = " + groovyGpgPassphrase
        }
    }
```

### Use the properties from groovy file
```bash
# DO (run all checks)
./gradlew -q check
    # >> Result: nothing
# DO (get properties from groovy file)
./gradlew -q propertiesGroovy
    # >> Result
    groovyBintrayUser = username_groovy
    groovyBintrayApiKey = 1234567890qwertyuiopasdfghjklzxcvbnm1234
    groovyGpgPassphrase = password_groovy
```



## Use the properties for `./build.gradle`
- The above tasks are ONLY used to how to use the properties
- The follow codes are used for develop the code.

### Use the system properties for `./build.gradle`
```bash
# DO (edit the file "./build.gradle")
nano ./build.gradle

    # FILE (./build.gradle)
    ...
    def sysBintrayUser = System.getenv("BINTRAY_USER")
    def sysBintrayApiKey = System.getenv('BINTRAY_API_KEY')
    def sysGpgPassphrase = System.getenv('GPG_PASSPHRASE')
    repositories {
        jcenter()
    }
    ...
```

### Use the gradle properties for `./build.gradle`
- !!! WARNING: The `password` and `API Key` etc SHOULD NOT BE SAVED IN THE file `gradle.properties`

```bash
# DO (edit the file "./build.gradle")
nano ./build.gradle

    # FILE (./build.gradle)
    ...
    group = "your_group"
    version = project.findProperty("version")
    ...
```

### Use the groovy properties for `./build.gradle`
- !!! WARNING: The any groovy properties file like `jcenter.properties` with `password` etc. SHOULD NOT BE IN THIS PROJECT

```bash
# DO (edit the file "./build.gradle")
nano ./build.gradle

    # FILE (./build.gradle)
    ...
    apply from: "../jcenter.properties" 
    def groovyBintrayUser = project.findProperty("bintrayUser")
    def groovyBintrayApiKey = project.findProperty("bintrayApiKey")
    def groovyGpgPassphrase = project.findProperty("gpgPassphrase")
    repositories {
        jcenter()
    }
    ...
```



## Tip: Use Gradle Tasks

```bash
./gradlew tasks

    # >> Result
    ...
    De.iotoi tasks
    --------------
    propertiesGradle - Get Properties from gradle properties file
    propertiesGroovy - Get Properties from groovy file
    propertiesSystem - Get Properties from system file
    ...
```
