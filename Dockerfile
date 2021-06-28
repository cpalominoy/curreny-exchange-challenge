FROM adoptopenjdk:11.0.11_9-jdk-hotspot
COPY "./target/curreny-exchange-challenge-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 9092
ENTRYPOINT ["java","-jar","app.jar"]