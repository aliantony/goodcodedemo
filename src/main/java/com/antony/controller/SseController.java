package com.antony.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program goodcodedemo
 * @description 测试推送
 * @author wq
 * created on 2021-03-25
 * @version  1.0.0
 */
@RestController
@RequestMapping("/sse")
public class SseController {
    private Set<SseEmitter> emitters = new HashSet();

    private AtomicInteger index = new AtomicInteger();
    @GetMapping("/push")
    public SseEmitter pushClient(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/event-stream");
        response.addHeader("X-Accel-Buffering", "no");
        response.addHeader("Connection", "keep-alive");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");

        SseEmitter emitter = new SseEmitter(0L);
        emitter.onCompletion(() -> {
            synchronized (emitter) {
                System.out.println("推送完成，移除emitter");
                emitters.remove(emitter);
            }
        });
        emitter.onTimeout(() -> {
            System.out.println("推送超时！");
            emitter.complete();
        });
        emitters.add(emitter);
        try {
            emitter.send(index.incrementAndGet());
        } catch (IOException e) {
            emitter.complete();
            emitters.remove(emitter);
        }
        return emitter;
    }


    @Scheduled(cron = "*/2 * * * * ?")
    public void task() {
        emitters.forEach(emitter -> {
            if (null != emitter) {
                try {
                    //System.out.println(emitter.getTimeout());
                    emitter.send(index.incrementAndGet());
                } catch (IOException e) {
                    System.out.println("客户端token下线了");
                    emitter.complete();
                }
            }
        });
    }
}
