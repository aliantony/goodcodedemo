package com.antony.service.ifelse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PayService4 implements ApplicationContextAware, InitializingBean {

     private ApplicationContext applicationContext;
     private List<IPay> payList = null;

     @Override
     public void afterPropertiesSet() throws Exception {  
         if (payList == null) {  
             payList = new ArrayList<>();
             Map<String, IPay> beansOfType = applicationContext.getBeansOfType(IPay.class);
 
             beansOfType.forEach((key, value) -> payList.add(value));  
         }  
     }  
 
     @Override
     public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;  
     }

    /**
     * 通过模板方法模式消除if else
     * @param code
     */
     public void toPay(String code) {  
         for (IPay iPay : payList) {  
             if (iPay.support(code)) {  
                iPay.pay();  
             }  
         }  
     }  
}