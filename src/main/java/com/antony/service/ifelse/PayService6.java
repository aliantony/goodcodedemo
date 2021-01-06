package com.antony.service.ifelse;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @program goodcodedemo
 * @description 枚举消除if else，三目运算符
 * @author wq
 * created on 2021-01-06
 * @version  1.0.0
 */
@Service
public class PayService6 {
    public String getMessage(int code) {
        MessageEnum messageEnum = MessageEnum.getMessageEnum(code);
        return messageEnum.getMessage();
    }

    public String getMessage2(int code) {
        return code == 1 ? "成功" : "失败";
    }

    public void save(Integer code, String name) throws Exception {
        if(code == null) {
            throw new Exception("code不能为空");
        } else {
            if(name == null) {
                throw new Exception("name不能为空");
            } else {
                System.out.println("doSave");
            }
        }
    }

    /**
     * 通过Assert检测参数
     * @param code
     * @param name
     * @return
     */
    public String save2(Integer code, String name) {
        Assert.notNull(code,"code不能为空");
        Assert.notNull(name,"name不能为空");
        System.out.println("doSave");
        return "";
    }
}
