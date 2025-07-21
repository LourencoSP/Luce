# Estágio de Build: Usa uma imagem Maven para compilar o projeto
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio de Execução: Usa uma imagem Java leve para rodar a aplicação
FROM openjdk:17-slim
WORKDIR /app
# Copia o .jar compilado do estágio de build
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]