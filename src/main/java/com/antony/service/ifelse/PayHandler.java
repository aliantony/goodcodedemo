package com.antony.service.ifelse;

import lombok.Getter;
import lombok.Setter;

/**
 * 责任链模式消除if else
 * 责任链模式：将请求的处理对象像一条长链一般组合起来，形成一条对象链。
 * 请求并不知道具体执行请求的对象是哪一个，这样就实现了请求与处理对象之间的解耦。
 * 常用的filter、spring aop就是使用了责任链模式
 */
public abstract class PayHandler {

    @Getter
    @Setter
    protected PayHandler next;

    public abstract void pay(String pay);

}