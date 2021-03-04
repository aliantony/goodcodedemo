package com.antony.arithmetic;
/**
 * @program goodcodedemo
 * @description 
 * @author wq
 * created on 2021-03-04
 * @version  1.0.0
 */
public class CommonPrefix {
    public static void main(String[] args) {
        String[] arrs = {"flower", "flight", "fllowe"};
        String ans = arrs[0];
        for (int i = 1; i < arrs.length; i++) {
             int j = 0;
             for (;j<ans.length() && j < arrs[i].length(); j++) {
                 if (ans.charAt(j) != arrs[i].charAt(j)) {
                     break;
                 }
             }
             ans = ans.substring(0, j);
             if (ans.equals("")) {
                 System.out.println("");
                 return;
             }
        }
        System.out.println(ans);
    }
}
