package com.antony.service.ifelse;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@PayCode(value = "alia", name = "支付宝支付")
@Service
public class AliaPay implements IPay {

    @PostConstruct
    public void init() {
        PayStrategyFactory.register("aliaPay", this);
    }

    @Override
    public boolean support(String code) {
        return"alia".equals(code);
    }

    @Override
     public void pay() {  
        System.out.println("===发起支付宝支付===");  
     }  
}  