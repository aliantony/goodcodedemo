package com.antony.designpattern.singleton;

/**
 * @author wq
 * created on 2021-03-03
 * @version 1.0.0
 * @program goodcodedemo
 * @description
 */
public class Singleton {

    private static boolean flag = false;

    private Singleton() {
        if (flag == false) {
            flag = !flag;
        } else {
            throw new RuntimeException("单例模式被侵犯！");
        }
    }

    public static void main(String[] args) {

    }
}
