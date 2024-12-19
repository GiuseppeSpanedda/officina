# Usa una immagine con Maven e OpenJDK
FROM maven:3.9.0 AS build

# Imposta la directory di lavoro
WORKDIR /app

# Copia il pom.xml e scarica le dipendenze
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia il codice sorgente e costruisce il JAR
COPY src /app/src
RUN mvn clean package -DskipTests

# Usa un'immagine base leggera per eseguire l'applicazione
FROM openjdk:17-jdk-slim

# Imposta la directory di lavoro
WORKDIR /app

# Copia il JAR generato dalla fase di build
COPY --from=build /app/target/officina-0.0.1-SNAPSHOT.jar /app/officina-0.0.1-SNAPSHOT.jar

# Imposta il comando per avviare l'applicazione
CMD ["java", "-jar", "officina-0.0.1-SNAPSHOT.jar"]

# Esponi la porta 8080 per il servizio web
EXPOSE 8080
