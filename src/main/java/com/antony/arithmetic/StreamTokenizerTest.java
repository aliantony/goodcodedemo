package com.antony.arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @program goodcodedemo
 * @description 基于流读取字符串拆分
 * @author wangqian
 * created on 2021-03-13
 * @version  1.0.0
 */
public class StreamTokenizerTest {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        // 分隔符
        st.nextToken();
        // 强转
        int n = (int) st.nval;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            st.nextToken();
            int key = (int) st.nval;
            st.nextToken();
            int value = (int) st.nval;
            arr[key] = arr[key] + value;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] != 0){
                sb.append(i).append(" ").append(arr[i]).append("\n");
            }
        }
        System.out.println(sb.toString());

    }
}
