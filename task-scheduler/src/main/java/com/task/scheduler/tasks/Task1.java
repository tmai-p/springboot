package com.task.scheduler.tasks;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.LocalDateTime;

@Component
@Log
public class Task1 {

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run() {
        log.info("1. Current time is :: " + LocalDateTime.now());
    }

    @Scheduled(fixedRate = 10000)
    @Async
    public void taskWithConcurrentExecutions() {
        log.info("2. Current time is :: " + LocalDateTime.now());
    }
}
