# https://hub.docker.com/_/gradle
FROM gradle:6.7.1-jdk11 AS gradle_build
COPY --chown=gradle:gradle . /home/gradle/src
COPY --chown=gradle:gradle ./jcenter.properties.sample /root/jcenter.properties
WORKDIR /home/gradle/src
RUN gradle clean build installDist --no-daemon


# https://hub.docker.com/r/azul/zulu-openjdk-alpine
FROM azul/zulu-openjdk-alpine:11.0.7-jre
RUN apk update && apk add bash
WORKDIR /app
COPY --from=gradle_build /home/gradle/src/build/install/_gradle_java/ /app/
CMD ["./bin/_gradle_java"]
