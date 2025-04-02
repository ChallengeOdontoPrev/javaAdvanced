# Usando a imagem base do OpenJDK
FROM openjdk:21-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o container
COPY target/challenge-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que a aplicação vai usar
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]