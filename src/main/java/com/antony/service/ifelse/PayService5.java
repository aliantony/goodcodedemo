package com.antony.service.ifelse;

import org.springframework.stereotype.Service;

/**
 * @program goodcodedemo
 * @description 策略+工厂模式消除if else
 * @author wq
 * created on 2021-01-06
 * @version  1.0.0
 */
@Service
public class PayService5 {
    public void toPay(String code) {
        PayStrategyFactory.get(code).pay();
    }
}
