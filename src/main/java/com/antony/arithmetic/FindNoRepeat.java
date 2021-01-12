package com.antony.arithmetic;
/**
 * @program goodcodedemo
 * @description 找出没有重复的数
 * @author wangqian
 * created on 2021-01-09
 * @version  1.0.0
 */
public class FindNoRepeat {
    /**
     * 二进制同0异1
     * 任何数异或上自己是0，任何数异或0等于自己
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 4, 2, 3};
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        System.out.println(result);
    }
}
