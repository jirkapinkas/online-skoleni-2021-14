package cz.gopas.eshopweb.controller;

import cz.gopas.eshopweb.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EmailController2 {

    @Lazy
    @Autowired
    private EmailController2 self;

    @GetMapping("/sendEmails2") // tohle by melo spravne byt @PostMapping !!!
    public void sendEmails() {
        for (int i = 0; i < 100; i++) {
            self.sendEmail(i);
        }
    }

    @Async
    @SneakyThrows // prosim nepouzivat ;-)
    public void sendEmail(int i) {
        Thread.sleep(100);
        log.info("sending email ... {}", i);
    }
}
