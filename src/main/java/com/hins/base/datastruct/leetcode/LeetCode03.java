package com.hins.base.datastruct.leetcode;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author:Wyman
 * @Date:
 * @Desc:
 *      给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LeetCode03 {

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> indexMap = new HashMap();
        int start = 0;
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            Integer lastOccrued = indexMap.get(c);
            if(lastOccrued == null || lastOccrued < start){
                maxLength = Math.max(maxLength, i - start + 1);
                indexMap.put(c, i);
            }else if(lastOccrued >= start && lastOccrued < i){
                start = lastOccrued + 1;
                maxLength = Math.max(maxLength, i - start + 1);
                indexMap.put(c, i);
            }

            System.out.println("start : " + start);
            System.out.println("maxLength: " + maxLength);
            System.out.println("-----------");

        }
        return maxLength;
    }

    public static void main(String[] args) {

//        String testStr = "abcabcbb";
        String testStr = "abcabcbb";
//        String testStr = " ";
//        String testStr = "";
//        String testStr = "aab";
//        String testStr = "abcd";
        int i = lengthOfLongestSubstring(testStr);
        System.out.println(i);

    }
}
