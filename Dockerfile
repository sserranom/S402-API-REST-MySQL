
FROM eclipse-temurin:23.0.1_11-jdk
WORKDIR /root
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root
COPY ./mvnw.cmd /root
RUN ./mvnw dependency:go-offline
COPY ./src /root/src
RUN ./mvnw clean install -DskipTests
ENTRYPOINT ["java", "-jar","/root/target/S04T02N02-0.0.1-SNAPSHOT.jar"]




