package com.hins.base.datastruct.leetcode;

/**
 * @Description: leetCode 编号242题
 *  有效的字母异位词
 *  给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *  输入: s = "anagram", t = "nagaram"
 *  输出: true
 *  输入: s = "rat", t = "car"
 *  输出: false
 *
 *  提示:你可以假设字符串只包含小写字母。
 * @Author:Wyman
 * @Date:2019
 */
public class Problem242 {

    public static boolean test(String str1,String str2){

        //初始化一个26个位置的char字符数组
        int[] arr = new int[26];

        //计算字符串中每一个字符在数组中存储的顺序位置
        int a = 'a';

        for(int i = 0; i < str1.length(); i++){
            char c2 = str1.charAt(i);
            int c = c2;
            //计算数组中的存储位置
            arr[c - a]++;
        }


        for(int i = 0; i < str2.length(); i++){
            char c2 = str2.charAt(i);
            int c = c2;
            //计算数组中的存储位置
            arr[c - a]--;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                return false;
            }
        }

        return true;

    }




    public static void main(String[] args) {

        String str1 = "rat";
        String str2 = "cat";

        boolean test = test(str1, str2);
        System.out.println("两个字符串是否字母异位词语: " + test);

    }
}
