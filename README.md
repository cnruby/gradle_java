<a href = "https://openjdk.java.net/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Java-Programming%20Language-black?style=flat&logo=java" alt = "The Java Programming Language">
</a>

[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![IntelliJ IEAD Community Version](https://img.shields.io/badge/IntelliJ%20IEAD%20Community%20Version-blue?style=flat)](https://www.jetbrains.com/de-de/idea/download/#section=linux)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_java/tree/basic_002.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_java?branch=basic_002)

---


basic_002
<h1>Hello Docker!</h1>


- [Step 1: Create local Docker Image](#step-1-create-local-docker-image)
  - [IF (local Docker Image from existing 'Docker Name')](#if-local-docker-image-from-existing-docker-name)
  - [ELSIF (local Docker Image from the file `Dockerfile`)](#elsif-local-docker-image-from-the-file-dockerfile)
- [Step 2: Docker Container](#step-2-docker-container)
  - [Create, Start and Use A Container](#create-start-and-use-a-container)
  - [IF (Create, Start and Use the Container with random 'Container Name')](#if-create-start-and-use-the-container-with-random-container-name)
  - [ELSEIF (Create, Start and Use the Container with custum 'Container Name')](#elseif-create-start-and-use-the-container-with-custum-container-name)
  - [Start and Use An Existing Container](#start-and-use-an-existing-container)
- [Step 3: Working Processes](#step-3-working-processes)
  - [Use custum defined container name](#use-custum-defined-container-name)
  - [Use random container name](#use-random-container-name)
  - [Use commands `docker run` and `docker stop`](#use-commands-docker-run-and-docker-stop)
- [Remove local Image and local Container](#remove-local-image-and-local-container)
- [Download This compelete Project](#download-this-compelete-project)



## Step 1: Create local Docker Image

### IF (local Docker Image from existing 'Docker Name')
```bash
    # DO (create a docker image with docker name `alpine`)
    docker pull alpine

    # DO (show all docker image)
    docker images

        # >> result:
        alpine                     latest                 d6e46aa2470d        6 weeks ago         5.57MB
```

### ELSIF (local Docker Image from the file `Dockerfile`)
```bash
    # Step 1: create and edit a file `Dockerfile`
    # DO( create the file `Dockerfile`)
    touch Dockerfile
    # DO( edit the file `Dockerfile`)
    vi Dockerfile

    # !!! this is code for the file ./Dockerfile:
    # (FILE) ./Dockerfile
    FROM alpine

    # Step 2: build an image from this file `Dockerfile`
    # DO (create an image from this file `Dockerfile`)
    docker build --tag=image_alpine .

        # >> result for Step 2:
        Sending build context to Docker daemon  3.584kB
        Step 1/1 : FROM alpine
        ---> d6e46aa2470d
        Successfully built d6e46aa2470d
        Successfully tagged image_alpine:latest

    # DO (show all docker images)
    docker images

        # >> result:
        REPOSITORY                 TAG                    IMAGE ID            CREATED             SIZE
        alpine                     latest                 d6e46aa2470d        6 weeks ago         5.57MB
        image_alpine               latest                 d6e46aa2470d        6 weeks ago         5.57MB

# ELSE ... ENDIF
```



## Step 2: Docker Container

### Create, Start and Use A Container

### IF (Create, Start and Use the Container with random 'Container Name')
```bash
    # DO (create, start and use a container)
    docker run -i -t alpine
        # !!! go to the linux alpine system
        # !!! the follow prompt `/ #` from os system
        # DO (list directory)
        / # ls
        # >> result
        bin    dev    etc    home   lib    media  mnt    opt    proc   root   run    sbin   srv    sys    tmp    usr    var
        # DO (exit os alpine system)
        / # exit

    # DO (show all containers)
    docker container ls -a

        # >> result
        CONTAINER ID        IMAGE                 COMMAND                  CREATED             STATUS                         PORTS               NAMES
        bf7673b3cce6        alpine                "/bin/sh"                19 seconds ago      Exited (0) 12 seconds ago                          loving_hertz
```

### ELSEIF (Create, Start and Use the Container with custum 'Container Name')
```bash
    # DO (create, start and use a container with the name 'container_alpine')
    docker run --name container_alpine -i -t alpine
        # !!! go to the linux alpine system
        # !!! the follow prompt `/ #` from os system
        # DO (list directory)
        / # ls
        # >> result
        bin    dev    etc    home   lib    media  mnt    opt    proc   root   run    sbin   srv    sys    tmp    usr    var
        # DO (exit os alpine system)
        / # exit

    # DO (show all containers)
    docker container ls -a

        # >> result
        CONTAINER ID        IMAGE                 COMMAND                  CREATED             STATUS                         PORTS               NAMES
        75bf19fdc449        alpine                "/bin/sh"                10 seconds ago      Exited (0) 5 seconds ago                           container_alpine
        bf7673b3cce6        alpine                "/bin/sh"                4 minutes ago       Exited (0) 4 minutes ago                           loving_hertz
# ELSE ... ENDIF
```

### Start and Use An Existing Container

```bash
# DO (start a container with name 'container_alpine')
docker start container_alpine

# DO (use the container)
docker exec -i -t container_alpine /bin/sh

# DO (stop the container)
docker stop container_alpine

```



## Step 3: Working Processes

### Use custum defined container name

```bash
# !!! run once
docker pull alpine # if `alpine` exists not.
# !!! run only once with the container name `container_alpine`
docker run --name container_alpine -i -t alpine
    # !!! go to the linux alpine system
    # !!! the follow prompt `/ #` from os system
    # DO (exit os alpine system)
    / # exit

# FOR LOOP
    docker start container_alpine
    # FOR LOOP
        docker exec -i -t container_alpine /bin/sh
            # !!! go to the linux alpine system
            # !!! the follow prompt `/ #` from os system
            # DO (Things)
            / # 
            # DO (exit os alpine system)
            / # exit
    # ENDFOR IF you need to go to the alpine system
    docker stop container_alpine
# ENDFOR IF you use the alpine system
```

### Use random container name

```bash
touch Dockerfile
vi Dockerfile
# FOR LOOP
    vi Dockerfile # IF you need
    docker build --tag=<REPOSITORY> .
    docker run <REPOSITORY>
        # KEY (Ctrl+C or other exit)
# ENDFOR
```

### Use commands `docker run` and `docker stop`

```bash
# !!! run once
docker pull alpine # IF `alpine` exists not.
# !!! run only once with the container name `container_alpine_2`
docker run --name container_alpine_2 -i -t alpine
    # !!! go to the linux alpine system
    # !!! the follow prompt `/ #` from os system
    # DO (thing)
    / #
# DO (open a new terminal)
docker stop container_alpine_2
```



## Remove local Image and local Container

```bash
# remove an image or more iamges
docker image rm <REPOSITORY NAME>
docker image rm <IMAGE ID>
docker image rm alpine 
docker image rm d6e46aa2470d
docker image rm d6e46aa2470d alpine

# remove container
docker container rm <CONTAINER ID>
docker container rm <CONTAINER Name>
docker container rm container_alpine bf7673b3cce6

# remove Image and Container
#  - all stopped containers
#  - all networks not used by at least one container
#  - all dangling images
#  - all dangling build cache
docker system prune
```



## Download This compelete Project

```bash
# DO (Download)
git clone -b basic_002 https://github.com/cnruby/gradle_java.git 002_gradle_java
```
