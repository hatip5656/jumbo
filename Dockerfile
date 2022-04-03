FROM adoptopenjdk/openjdk11:latest
EXPOSE 8080
ENV JAR_FILE=/target/supermatten-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} .
CMD java -jar ${JAR_FILE}
