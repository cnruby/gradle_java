# https://hub.docker.com/_/gradle
FROM gradle:6.7.1-jdk11 AS gradle_build
RUN git clone -b basic_110 https://github.com/cnruby/gradle_java.git /home/gradle/src/
RUN chown -R gradle:gradle /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build installDist --no-daemon
RUN rm -rf /home/gradle/src/_gradle_java-0.121.1
RUN ls -al /home/gradle/src/build/distributions
RUN unzip /home/gradle/src/build/distributions/_gradle_java.zip


FROM azul/zulu-openjdk-alpine:11.0.7
RUN apk update && apk add bash
WORKDIR /app
COPY --from=gradle_build /home/gradle/src/_gradle_java/ /app/
RUN ls -al /app/bin
RUN pwd
CMD ["./bin/basic_110"]
