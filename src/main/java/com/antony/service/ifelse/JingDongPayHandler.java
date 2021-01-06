package com.antony.service.ifelse;

import org.springframework.stereotype.Service;

@Service
public class JingDongPayHandler extends PayHandler {


    @Override
    public void pay(String code) {
        if ("jingdong".equals(code)) {
            System.out.println("===发起京东支付===");
        } else {
            getNext().pay(code);
        }
    }
}