package com.antony.service.ifelse;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@PayCode(value = "weixin", name = "微信支付")
@Service
public class WeixinPay implements IPay {

    @PostConstruct
    public void init() {
        PayStrategyFactory.register("weixin", this);
    }

    @Override
    public boolean support(String code) {
        return"weixin".equals(code);
    }

    @Override
     public void pay() {  
         System.out.println("===发起微信支付===");  
     }  
} 