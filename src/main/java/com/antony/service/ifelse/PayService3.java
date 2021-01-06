package com.antony.service.ifelse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class PayService3 implements ApplicationContextAware {
     private ApplicationContext applicationContext;
     private static final String SUFFIX = "Pay";  

     @Override
     public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;  
     }  

     public void toPay(String payCode) {  
         ((IPay) applicationContext.getBean(getBeanName(payCode))).pay();  
     }

    /**
     * 动态拼接beanName优化if else
     * @param payCode
     * @return
     */
     public String getBeanName(String payCode) {  
         return payCode + SUFFIX;  
     }  
}