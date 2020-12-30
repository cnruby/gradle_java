# https://hub.docker.com/_/gradle
FROM gradle:6.7.1-jdk11 AS gradle_build
RUN git clone -b basic_111 https://github.com/cnruby/gradle_java.git /home/gradle/src/
RUN chown -R gradle:gradle /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build --no-daemon

# https://hub.docker.com/_/jetty
FROM jetty:9.4.35-jre11
MAINTAINER Gudao Luo

COPY --from=gradle_build /home/gradle/src/build/libs/_gradle_java.war  /var/lib/jetty/webapps/ROOT.war

# USER root
# RUN apt-get update

# USER jetty
# RUN cat /etc/*-release
# RUN java -version

EXPOSE 8080
