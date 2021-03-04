package com.antony.arithmetic;
/**
 * @program goodcodedemo
 * @description 回文数
 * @author wq
 * created on 2021-03-04
 * @version  1.0.0
 */
public class huiwenshu {
    public static void main(String[] args) {
        System.out.println(compute(12212));
    }

    public static boolean compute(int x) {
        if (x < 0) {
            return false;
        }
        int res = 0;
        int num = x;
        while (x != 0) {
            int tem = x % 10;
            res = res * 10 + tem;
            x = x / 10;
        }
        return num == res;
    }
}
