package com.antony.arithmetic;
/**
 * @program goodcodedemo
 * @description 
 * @author wangqian
 * created on 2021-01-09
 * @version  1.0.0
 */
public class ToBinary {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(80));
        int a = 80;
        System.out.println(Integer.toBinaryString(a - 1));
        System.out.println(a & (a - 1));
        //判断一个数是否是2的整数次幂
        System.out.println(is2Power(1));
        System.out.println(is2Power(2));
        System.out.println(is2Power(4));
        System.out.println(is2Power(8));
        System.out.println(is2Power(16));
        System.out.println(is2Power(32));
        System.out.println(is2Power(80));

    }

    public static boolean is2Power(int a) {
        return (a & (a-1)) == 0;
    }
}
