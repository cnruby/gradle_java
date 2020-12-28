# # https://hub.docker.com/_/gradle
FROM gradle:6.7.1-jdk11 AS gradle_build
RUN git clone -b basic_110 https://github.com/cnruby/gradle_java.git /home/gradle/src/
RUN chown -R gradle:gradle /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build installDist --no-daemon


# https://hub.docker.com/r/azul/zulu-openjdk-alpine
FROM azul/zulu-openjdk-alpine:11.0.7
RUN apk update && apk add bash
WORKDIR /app
COPY --from=gradle_build /home/gradle/src/build/install/_gradle_java/ /app/
RUN ls -al /app/bin
CMD ["./bin/basic_110"]
