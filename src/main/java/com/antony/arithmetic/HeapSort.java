package com.antony.arithmetic;

import java.util.Arrays;

/**
 * @program goodcodedemo
 * @description 堆排序
 * n/2 -1 = 最后一个非叶节点
 * 2*i+1 2*i+2 父节点的左右节点位置。
 * 任意父节点大于子节点的是大顶堆
 * 任意父节点小于子节点的是小顶堆
 * 最好最坏情况都能保持nlogn的时间复杂度
 * 快排最坏情况下是n平方，平均是nlogn
 * 快排最坏的情况是所有节点只有左节点或只有右节点，
 * 这时分区函数每次分出来都是1个元素和其他元素两部分。
 * 这时是n平方的时间复杂度
 * 堆排序空间复杂度O(1)
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * @author wangqian
 * created on 2021-01-10
 * @version  1.0.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[])
    {
        int n = arr.length;
        // Build heap (rearrange array)
        //从最后一个非叶子节点开始，从左至右边，从下至上
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            //把堆顶和最后一个元素交换位置，最后一个是最大的元素了。
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            //除了最后一个最大的元素外，剩余的元素继续做堆排序。
            //0代表从根节点开始递归调整堆
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int arr[], int n, int i)
    {
        // Initialize largest as root
        int largest = i;
        // left = 2*i + 1
        int l = 2 * i + 1;
        // right = 2*i + 2
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            /**
             * 当把非叶子节点和它的父节点交换位置后，可能子树不满足父节点大于左右子节点
             * 所以递归对子树做堆化调整。
             */
            heapify(arr, n, largest);
        }
    }
}
