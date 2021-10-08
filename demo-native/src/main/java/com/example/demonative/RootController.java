package com.example.demonative;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public Message root() {
        return new Message("Spring Native Works!");
    }

}
