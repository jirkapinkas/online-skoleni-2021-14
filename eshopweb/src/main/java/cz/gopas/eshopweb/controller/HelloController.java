package cz.gopas.eshopweb.controller;

import cz.gopas.eshopweb.pojo.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // http://localhost:8080/message
    @GetMapping("/message")
    public Message message() {
        return new Message("Spring Boot Rocks :-)");
    }

}
