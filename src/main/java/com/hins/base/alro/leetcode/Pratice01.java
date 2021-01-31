package com.hins.base.alro.leetcode;

import com.hins.base.alro.QuickSort;

/**
 * @Description: 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * @Author:Wyman
 * @Date:2019
 */
public class Pratice01 {

    public static Comparable find(Comparable[] arr) throws Exception{

        int n = arr.length;

        //首先先排序
        QuickSort.sort(arr);

        for(int i = 0; i < n; i += 2){
            if(arr[i].compareTo(arr[i+1]) != 0){
                return arr[i];
            }

            if(i == n-1-2){
                return arr[n-1];
            }
        }

        throw new Exception("数组不符合规范!");
    }


    public static void main(String[] args) throws Exception{

//        Integer[] arr = new Integer[]{4,1,2,1,2,6,6,5,5,7,9,78,69,56,645,78,69,56,645,7,4};
//        Comparable c = Test01.find(arr);
//        System.out.println(c);

        int i1 = 6,i2 = 2;
        System.out.println(i1 ^ i2);

        int[] arr = new int[]{4,1,2,1,2,6,6,5,5,7,9,78,69,56,645,78,69,56,645,7,4};

        int ans = arr[0];

        if(arr.length > 1){
            for(int i = 1; i < arr.length; i++){
                ans = ans ^ arr[i];
            }
        }

        System.out.println(ans);
    }
}
