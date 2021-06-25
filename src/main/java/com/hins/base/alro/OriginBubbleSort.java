package com.hins.base.alro;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: hins
 * @created: 2021-06-23 01:32
 * @desc: 最原始的冒泡排序
 **/
public class OriginBubbleSort {

    private OriginBubbleSort(){}

    /**
     * 冒泡排序实际上每一轮都会将一个最大的数交换到数组的最右边
     * @param arr
     */
    public static void sort(Comparable[] arr) {

        // 外层循环决定需要多少轮完成所有数的冒泡，最大轮数为数组长度-1
        int len = arr.length;

        for(int i=1; i<len; i++) {

            // 内层循环，循环的是交换的次数
            // 每次最大交换次数为: len - i
            int n = len-i;
            for(int j=0; j<n; j++) {

                if(arr[j].compareTo(arr[j+1]) > 0) {
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object obj = arr[i];
        arr[i] = arr[j];
        arr[j] = obj;

    }


    public static void main(String[] args) {

//        String dataStr = "3,44,38,5,47,15,36,26,27,2,46,4,19,50,48";
////        String dataStr = "3,44,38,5,47";
//        String[] strArr = dataStr.split(",");
//        Integer[] intArr = Arrays.asList(strArr)
//                .stream()
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .toArray(Integer[]::new);
//        System.out.println(intArr);
//        sort(intArr);
//        System.out.println(intArr);

        Collections.sort(Arrays.asList(3,44,38,5,47,15));

    }

}
