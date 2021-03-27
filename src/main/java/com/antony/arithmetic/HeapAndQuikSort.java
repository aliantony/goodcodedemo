package com.antony.arithmetic;
/**
 * @program goodcodedemo
 * @description 
 * @author wangqian
 * created on 2021-03-16
 * @version  1.0.0
 */
public class HeapAndQuikSort {

    public static void main(String[] args) {
        int[] arr = {8,22,98,78,68,32,15,8,7,5,6,102,1};
        /*int n = arr.length;
        for (int i = n/2-1; i >= 0; i--) {
           heapfiy(arr, n, i);
        }
        for (int i = n-1; i > 0; i--) {
            int last = arr[i];
            arr[i] = arr[0];
            arr[0]= last;
            heapfiy(arr, i, 0);
        }*/
        // quik sort
        quik(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 调整堆
     * n 堆大小
     * i 最后一个非叶子节点索引
     */
    public static void heapfiy(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            //调整子节点
            heapfiy(arr, n, largest);
        }

    }

    public static void quik(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low > high) {
            return;
        }
        int key = arr[low];
        int l = low;
        int r = high;
        while(l != r) {
            while(arr[r] >= key && l < r) {
                r--;
            }
            while(arr[l] <= key && l < r) {
                l++;
            }
            //右边找到小于key的元素，左边找到大于key的元素交换
            if (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }
        arr[low] = arr[l];
        arr[l] = key;
        quik(arr, low, l-1);
        quik(arr, l+1, high);
    }
}
