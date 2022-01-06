package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncService {

    @Async // 비동기로 동작 - 별도의 Thread 동작
    public void hello() {

        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(2000);
                log.info("thread sleep ... ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
