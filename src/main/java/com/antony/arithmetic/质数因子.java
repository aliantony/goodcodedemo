package com.antony.arithmetic;

import java.util.Scanner;

/**
 * @program goodcodedemo
 * @description 质数因子
 * @author wangqian
 * created on 2021-03-13
 * @version  1.0.0
 */
public class 质数因子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int i = 2;
        StringBuilder builder = new StringBuilder();
        while(num >= 2) {
            if (num % i == 0) {
                builder.append(i + " ");
                num = num / i;
            } else {
                i++;
            }
        }
        System.out.println(builder.toString());
    }
}
