FROM gradle:jdk17 AS build

WORKDIR /app
COPY . .
COPY gradle /app/gradle

RUN ./gradlew clean build -x test

# Optional: Package the built application (e.g., as a JAR) for deployment
FROM openjdk:17-jdk-slim as runner
WORKDIR /app
COPY --from=build /app/build/libs/Banking_v1.jar /app/Banking_v1.jar

# Command to run your application
CMD ["java", "-jar", "/Banking_v1.jar"]


#
#FROM openjdk:17-jdk-slim
#COPY
#ENTRYPOINT ["java", "-jar", "/Banking_v1.jar"]