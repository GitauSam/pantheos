FROM openjdk:17-alpine AS jumia_backend
MAINTAINER phosphor.com
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY **.jar app.jar
COPY ./sample.db .
EXPOSE 7600
ENTRYPOINT ["java", "-jar", "app.jar"]
