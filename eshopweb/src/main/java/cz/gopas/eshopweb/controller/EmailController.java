package cz.gopas.eshopweb.controller;

import cz.gopas.eshopweb.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EmailController {

//    private static final Logger log = LoggerFactory.getLogger(EmailController.class);

    private final EmailService emailService;

    @GetMapping("/sendEmails") // tohle by melo spravne byt @PostMapping !!!
    public void sendEmails() {
        for (int i = 0; i < 100; i++) {
            emailService.sendEmail(i);
        }
    }


}
