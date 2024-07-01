# Imagen base: Java 17 con Alpine (minimizada)
FROM openjdk:17-jdk-alpine

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos el archivo JAR de la aplicación
COPY target/FactuPlus-0.0.1-SNAPSHOT.jar FactuPlus.jar

# Copiamos el archivo de configuración
#COPY ./application.properties /app/config/application.properties

# Exponemos el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación con el archivo de configuración externo
#, "--spring.config.location=/app/config/application.properties"
ENTRYPOINT ["java", "-jar", "FactuPlus.jar"]

# Etiquetas: nombre y versión
LABEL name="FactuPlus_img"
LABEL version="latest"
