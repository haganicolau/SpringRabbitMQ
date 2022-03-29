FROM alpine:latest
#FROM alpine:latest as packager

RUN apk --no-cache add openjdk11-jdk openjdk11-jmods

ENV JAVA_MINIMAL="/opt/java-minimal"

# build minimal JRE
RUN /usr/lib/jvm/java-11-openjdk/bin/jlink \
    --verbose \
    --add-modules \
        java.base,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument \
    --compress 2 --strip-debug --no-header-files --no-man-pages \
    --release-info="add:IMPLEMENTOR=radistao:IMPLEMENTOR_VERSION=radistao_JRE" \
    --output "$JAVA_MINIMAL"

ARG MAVEN_VERSION=3.8.5
ARG USER_HOME_DIR="/root"
ARG MAVEN_SHA=89ab8ece99292476447ef6a6800d9842bbb60787b9b8a45c103aa61d2f205a971d8c3ddfb8b03e514455b4173602bd015e82958c0b3ddc1728a57126f773c743
ARG MAVEN_BASE_URL=https://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries

SHELL ["/bin/ash", "-eo", "pipefail", "-c"]

RUN apk -U update \
  && apk add --no-cache \
    curl \
  && mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${MAVEN_BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && echo "${MAVEN_SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
ENV LOG_PATH="/tmp/logs"

WORKDIR /build
COPY . /build

RUN mvn clean package -f libDataDtoChangelle/pom.xml
RUN mvn clean install
RUN mvn clean package

EXPOSE 8081
VOLUME /tmp
RUN chmod +x ./restModule/target/restModule-0.0.1-SNAPSHOT.jar
RUN cp ./restModule/target/restModule-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]