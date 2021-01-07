package com.antony.service.staticover;

public class A { //父类
    public static final String staticStr = "A静态属性";
    public final String nonStaticStr = "A非静态属性";
    public  static void staticMethod(){
        System.out.println("A静态方法");  
    }  
    public void nonStaticMethod(){
        System.out.println("A非静态方法");  
    }  
}