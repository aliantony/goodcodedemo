package com.antony.arithmetic;

import org.springframework.util.StopWatch;

import java.util.Random;

/**
 * @program goodcodedemo
 * @description 快速排序
 * 主要使用递归的思想
 * left right key数组的左边和右边下标 key开始等于left
 * l r 用于左右移动的指针,一开始l=left r=right
 * 条件是l要小于r
 *先移动右边的指针r，当遇到元素小于key时停下
 *再移动左边的指针l, 当遇到元素大于key时停下，交换该元素和右边元素的位置
 * 当l=r时，交换该元素和key的位置，此轮结束下来key左边的元素小于key,右边的元素大于key
 * 再用左边的子数组和右边的子数组递归调用本方法
 * 时间复杂度是nlogn log16=4 2的4次方等于16. n代表元素个数
 * 空间复杂度O(n)，最差n次递归调用。
 * @author wangqian
 * created on 2021-01-08
 * @version  1.0.0
 */
public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = {3, 2, 6, 8, 9, 11, 24, 89, 13, 74, 63};
        int[] arr2 = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            arr2[i] = rand.nextInt(100) + 1;
        }
        StopWatch watch = new StopWatch();
        watch.start();
        quick(arr2, 0, arr2.length -1);
        watch.stop();
        System.out.println("快排总耗时:" + watch.getTotalTimeMillis());
        for (int i : arr2) {
            System.out.println(i);
        }
    }

    public static void quick(int[] arr,int left, int right) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (left > right) {
            return;
        }
        int key = arr[left];
        int l = left;
        int r = right;
        while(l != r) {
            //先移动右边，找到比key小的停下，l必须小于r
            while(arr[r] >= key && l < r) {
                r--;
            }
            //移动左边，找到比key大的停下, l必须小于r
            //必须有等于，不然会提早交换了key的位置
            while(arr[l] <= key && l < r) {
                l++;
            }
            //交换l和r的位置
            if (l < r) {
               int temp = arr[l];
               arr[l] = arr[r];
               arr[r] = temp;
            }
        }
        // l=r 交换key和l位置的元素
        arr[left] = arr[l];
        arr[l] = key;
        //对key左边的子数组排序
        quick(arr,left,l - 1);
        //对key右边的子数组排序
        quick(arr, l + 1, right);
    }
}
