package com.antony.service.staticover;
/**
 * @program goodcodedemo
 * @description 
 * @author wq
 * created on 2021-01-07
 * @version  1.0.0
 */
public class InterfaceBImpl implements InterfaceB{
    String str = "InterfaceAImplB的字符串";
    @Override
    public String method1() {
        return str;
    }
}
