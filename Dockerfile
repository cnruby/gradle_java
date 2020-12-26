# https://hub.docker.com/_/jetty
FROM jetty:9.4.35-jre11
# https://github.com/plantuml/plantuml-server/blob/master/Dockerfile.jetty
# XXTODO
# FROM jetty
# FROM jetty:11.0.0-jre11
MAINTAINER G.Luo

# https://nickjanetakis.com/blog/docker-tip-2-the-difference-between-copy-and-add-in-a-dockerile
#ADD /build/libs/_gradle_java.war /var/lib/jetty/webapps/ROOT.war
# ADD /build/libs/_gradle_java.war /var/lib/jetty/webapps/root.war
#COPY /build/libs/_gradle_java.war /var/lib/jetty/webapps/ROOT.war
#COPY /build/libs/_gradle_java.war /var/lib/jetty/webapps/root.war

# FROM Maven Local
ADD /_gradle_java.war /var/lib/jetty/webapps/ROOT.war

USER root
RUN apt-get update

USER jetty
RUN cat /etc/*-release
RUN java -version

# Make port 8080 available to the world outside this container
EXPOSE 8080
