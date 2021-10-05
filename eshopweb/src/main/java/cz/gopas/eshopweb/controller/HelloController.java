package cz.gopas.eshopweb.controller;

import cz.gopas.eshopweb.pojo.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class HelloController {

    // http://localhost:8080/message
    @GetMapping("/message")
    public Message message() {
        return new Message("Spring Boot Rocks :-)");
    }

    // http://localhost:8080/dog
    @GetMapping(path = "/dog", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] dog() throws IOException {
        return Files.readAllBytes(Path.of("files", "dog.jpg"));
    }

    // http://localhost:8080/file?name=pom.xml
    // http://localhost:8080/file?name=dog.jpg
    @GetMapping("/file")
    public ResponseEntity<Object> file(@RequestParam String name) throws IOException {
        Path path = Path.of("files", name);
        if(!path.toFile().exists()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new Message("File '" + name + "' does not exist!"));
        }
        MediaType mediaType = MediaType.TEXT_HTML;
        if(name.endsWith(".xml")) {
            mediaType = MediaType.APPLICATION_XML;
        } else if(name.endsWith(".jpg")) {
            mediaType = MediaType.IMAGE_JPEG;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(mediaType)
                .body(Files.readAllBytes(path));
    }


}
