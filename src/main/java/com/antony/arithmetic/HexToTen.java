package com.antony.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program goodcodedemo
 * @description 16进制转10进制
 * @author wangqian 十六进制数从右到左乘以16的0次方，1次方....相加就是10进制
 * 10进制转16进制除以16直到商为0，从下到上的余数即可
 * created on 2021-03-13
 * @version  1.0.0
 */
public class HexToTen {
    public static Map<String, Integer> HEX_MAP = new HashMap<>();
    static {
        HEX_MAP.put("0", 0);
        HEX_MAP.put("1", 1);
        HEX_MAP.put("2", 2);
        HEX_MAP.put("3", 3);
        HEX_MAP.put("4", 4);
        HEX_MAP.put("5", 5);
        HEX_MAP.put("6", 6);
        HEX_MAP.put("7", 7);
        HEX_MAP.put("8", 8);
        HEX_MAP.put("9", 9);
        HEX_MAP.put("A", 10);
        HEX_MAP.put("B", 11);
        HEX_MAP.put("C", 12);
        HEX_MAP.put("D", 13);
        HEX_MAP.put("E", 14);
        HEX_MAP.put("F", 15);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
           String str = sc.nextLine();
            System.out.println(Integer.toBinaryString(10997));
            System.out.println("先用最简单的API输出结果:" + Integer.valueOf(str.substring(2), 16));
            String[] arr = str.substring(2).split("");
            int sum = 0;
            double pow = 0D;
            for (int i = arr.length -1 ; i >= 0; i--) {
                sum += HEX_MAP.get(arr[i]) * Math.pow(16D, pow);
                pow ++;
            }
            System.out.println(sum);
        }
    }
}
