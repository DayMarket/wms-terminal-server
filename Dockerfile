FROM openjdk:17
# Copying first jar file in target dir
ADD infrastructure/target/*.jar app.jar

EXPOSE 8080
EXPOSE 8849

ENTRYPOINT java \
    $JAVA_OPTS \
    -Djava.security.egd=file:/dev/./urandom \
    -Djava.awt.headless=true \
    -XX:+UseG1GC \
    -jar /app.jar
