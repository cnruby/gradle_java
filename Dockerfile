# Use an official OpenJDK runtime as a parent image
FROM azul/zulu-openjdk-alpine:11.0.6-jre
# FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine
# https://hub.docker.com/search?q=openjdk&type=image

# set shell to bash
# source: https://stackoverflow.com/a/40944512/3128926
RUN apk update && apk add bash

# Set the working directory to /app
WORKDIR /app

# Copy the app into the container at /app
COPY /_gradle_java/ /app/

# Run jar file when the container launches
CMD ["./bin/basic_110"]