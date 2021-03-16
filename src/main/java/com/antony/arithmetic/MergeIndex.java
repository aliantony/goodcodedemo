package com.antony.arithmetic;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @program goodcodedemo
 * @description 
 * @author wangqian
 * created on 2021-03-13
 * @version  1.0.0
 */
public class MergeIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Map<Integer,Integer> map = new TreeMap<>();
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        map.computeIfAbsent(Integer.valueOf(arr[0]), (k) -> Integer.valueOf(arr[1]));
        map.computeIfPresent(Integer.valueOf(arr[0]), (k, v) -> Integer.valueOf(arr[1]) + v);
        for(Map.Entry en:map.entrySet()) {
            System.out.println(en.getKey() + " " + en.getValue());
        }

    }
}
