package com.antony.service.ifelse;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@PayCode(value = "jingdong", name = "京东支付")
@Service
public class JingDongPay implements IPay {
    @PostConstruct
    public void init() {
        PayStrategyFactory.register("jingdongPay", this);
    }

    @Override
    public boolean support(String code) {
        return"jingdong".equals(code);
    }

    @Override
     public void pay() {  
        System.out.println("===发起京东支付===");  
     }  
}  