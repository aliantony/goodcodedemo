package com.antony.arithmetic;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @program goodcodedemo
 * @description  输入多组数据去重排序，每组第一位先输入个数，再输入等于个数的随机数
 * @author wangqian
 * created on 2021-03-13
 * @version  1.0.0
 */
public class MyTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            //获取个数
            int num = sc.nextInt();
            //创建TreeSet进行去重排序
            TreeSet set = new TreeSet();
            //输入
            for(int i =0 ; i < num ;i++){
                set.add(sc.nextInt());
            }

            //输出
            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
}
