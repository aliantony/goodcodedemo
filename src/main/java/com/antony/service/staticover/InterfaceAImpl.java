package com.antony.service.staticover;
/**
 * @program goodcodedemo
 * @description 
 * @author wq
 * created on 2021-01-07
 * @version  1.0.0
 */
public class InterfaceAImpl implements InterfaceA{
    String str = "InterfaceAImpl的字符串";
    @Override
    public String method1() {
        return str;
    }
}
