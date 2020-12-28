FROM azul/zulu-openjdk-alpine:11.0.7-jre
RUN apk update && apk add bash unzip wget
WORKDIR /app

RUN wget https://dl.bintray.com/cnruby/gradle_java_jcenter/de/iotoi/_gradle_java/0.117.1/_gradle_java-0.117.1.zip
RUN unzip _gradle_java-0.117.1.zip

CMD ["./_gradle_java-0.117.1/bin/basic_117"]
