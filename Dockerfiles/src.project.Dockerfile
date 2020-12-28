# https://hub.docker.com/_/gradle
FROM gradle:6.7.1-jdk11 AS gradle_build
COPY --chown=gradle:gradle . /home/gradle/src
COPY --chown=gradle:gradle ./jcenter.properties.sample /root/jcenter.properties
WORKDIR /home/gradle/src
RUN gradle -q check --no-daemon


# https://hub.docker.com/r/azul/zulu-openjdk-alpine
FROM azul/zulu-openjdk-alpine:11.0.7
RUN apk update && apk add bash
WORKDIR /app
COPY --from=gradle_build /home/gradle/src/. /app/.
COPY --from=gradle_build /root/jcenter.properties /root/jcenter.properties
RUN ls -al /app
CMD ["./gradlew", "run"]
