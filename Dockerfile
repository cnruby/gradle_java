# https://hub.docker.com/_/jetty
FROM jetty

# https://nickjanetakis.com/blog/docker-tip-2-the-difference-between-copy-and-add-in-a-dockerile
ADD /build/libs/_gradle_java.war /var/lib/jetty/webapps/ROOT.war
# ADD /build/libs/_gradle_java.war /var/lib/jetty/webapps/root.war
#COPY /build/libs/_gradle_java.war /var/lib/jetty/webapps/ROOT.war
#COPY /build/libs/_gradle_java.war /var/lib/jetty/webapps/root.war

RUN cat /etc/*-release
RUN java -version

# Make port 8080 available to the world outside this container
EXPOSE 8080
