# https://hub.docker.com/_/gradle
FROM gradle:6.7.1-jdk11 AS gradle_build
WORKDIR /home/gradle/src
RUN wget https://jcenter.bintray.com/de/iotoi/basic_120/0.120.1/basic_120-0.120.1.war -O _gradle_java.war
RUN ls -al /home/gradle/src

# https://hub.docker.com/_/jetty
FROM jetty:9.4.35-jre11
MAINTAINER Gudao Luo

# USER root
# RUN apt-get update && apt install wget

# USER jetty
# RUN cat /etc/*-release
# RUN java -version

COPY --from=gradle_build /home/gradle/src/_gradle_java.war  /var/lib/jetty/webapps/ROOT.war

EXPOSE 8080
