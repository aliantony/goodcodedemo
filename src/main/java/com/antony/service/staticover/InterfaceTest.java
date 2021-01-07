package com.antony.service.staticover;
/**
 * @program goodcodedemo
 * @description 
 * @author wq
 * created on 2021-01-07
 * @version  1.0.0
 */
public class InterfaceTest {
    public static void main(String[] args) {
        InterfaceA a = new InterfaceAImpl();
        //接口中public static final定义的成员变量可以被子类重写
        System.out.println(a.method1());
        InterfaceAImpl b = new InterfaceAImpl();
        System.out.println(b.method1());
        b.str = "hello";
        System.out.println(b.method1());

        InterfaceA c = new InterfaceBImpl();
        System.out.println(c.method1());

        InterfaceBImpl d = new InterfaceBImpl();
        System.out.println(d.method1());
        d.str = "卡哇伊";
        System.out.println(d.method1());
    }
}
