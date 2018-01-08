FROM maven:3.5.2-jdk-8

COPY google_checks.xml /
COPY pom.xml /
RUN mvn install
RUN mvn checkstyle:checkstyle
ENTRYPOINT mvn checkstyle:checkstyle
