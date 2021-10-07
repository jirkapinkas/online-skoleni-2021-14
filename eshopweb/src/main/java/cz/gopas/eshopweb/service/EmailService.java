package cz.gopas.eshopweb.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    @Async
    @SneakyThrows // prosim nepouzivat ;-)
    public void sendEmail(int i) {
        Thread.sleep(100);
        log.info("sending email ... {}", i);
    }

}
