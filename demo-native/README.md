mvn spring-boot:build-image
docker run --rm -it -p 8080:8080 demo-native:0.0.1-SNAPSHOT
