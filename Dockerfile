FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY java-app/ .

RUN javac App.java

EXPOSE 80

CMD ["java", "App"]