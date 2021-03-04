package com.antony.arithmetic;

/**
 * @author wq -2147483648 - 2147483647
 * created on 2021-03-04
 * @version 1.0.0
 * @program goodcodedemo
 * @description 有符号整数反转，如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 */
public class IntegerReverse {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(compute(-324));
    }

    public static int compute(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x = x / 10;
        }
        return res;
    }
}
