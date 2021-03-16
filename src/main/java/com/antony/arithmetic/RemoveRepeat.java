package com.antony.arithmetic;

/**
 * @program goodcodedemo
 * @description 删除排序数组中重复的元素
 * @author wangqian
 * created on 2021-01-10
 * @version  1.0.0
 */
public class RemoveRepeat {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
               i++;
               arr[i] = arr[j];
            }
        }
    }
}
