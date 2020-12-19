# https://hub.docker.com/_/tomcat
FROM tomcat:9.0.41-jdk11

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT.war"]
COPY /build/libs/_gradle_java.war /usr/local/tomcat/webapps/ROOT.war

RUN cat /etc/*-release
RUN java -version
RUN sh /usr/local/tomcat/bin/version.sh

# Make port 8080 available to the world outside this container
EXPOSE 8080
