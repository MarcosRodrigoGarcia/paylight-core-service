# Imagen base ligera con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Crea una carpeta para la app
WORKDIR /app

# Copia el jar compilado (usa el nombre real del .jar generado por Maven)
COPY target/paylight-core-service.jar app.jar

# Expone el puerto interno
EXPOSE 8085

# Comando para arrancar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
