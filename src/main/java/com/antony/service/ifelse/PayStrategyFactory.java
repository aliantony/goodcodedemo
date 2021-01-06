package com.antony.service.ifelse;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略+工厂模式消除if else
 */
public class PayStrategyFactory {

    private static Map<String, IPay> PAY_REGISTERS = new HashMap<>();


    public static void register(String code, IPay iPay) {
        if (null != code && !"".equals(code)) {
            PAY_REGISTERS.put(code, iPay);
        }
    }


    public static IPay get(String code) {
        return PAY_REGISTERS.get(code);
    }
}