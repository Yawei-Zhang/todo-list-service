FROM openjdk:8-jdk-alpine

ENV APP_HOME=/usr/app/
ENV PORT=10000

WORKDIR $APP_HOME

EXPOSE $PORT
COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
RUN ./gradlew build || return 0

COPY . .

RUN ./gradlew build

CMD ./gradlew bootRun
