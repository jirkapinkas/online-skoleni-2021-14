package cz.gopas.eshopweb.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController
public class EmailController3 {

    @Lazy
    @Autowired
    private EmailController3 self;

    @Async
    @GetMapping("/sendEmails3") // tohle by melo spravne byt @PostMapping !!!
    public void sendEmails() {
        log.info("start  sending emails ...");
        List<Future<Integer>> futures = IntStream.range(0, 100)
                .mapToObj(self::sendEmail)
                .collect(Collectors.toList());
        futures.forEach(this::getFuture); // blokujici operace
        log.info("finish sending emails ...");
    }

    @Async
    @SneakyThrows // prosim nepouzivat ;-)
    public Future<Integer> sendEmail(int i) {
        Thread.sleep(100);
        log.info("sending email ... {}", i);
        return new AsyncResult<>(i);
    }

    @SneakyThrows
    public <T> T getFuture(Future<T> future) {
        return future.get();
    }
}
