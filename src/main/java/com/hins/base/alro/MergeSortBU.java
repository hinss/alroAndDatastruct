package com.hins.base.alro;

import java.util.Arrays;

/**
 * @Description: 自底向上的归并算法
 * @Author:Wyman
 * @Date:2019
 */
public class MergeSortBU {


    public static void sort(Comparable[] arr) {

        int n = arr.length;

        //自底向上的归并,第一层循环循环每次归并的元素个数 第一次1 第二次2 第三次4 第四次8 以此类推...
        for (int sz = 1; sz < n; sz += sz) {

            for (int i = 0; i + sz < n; i += sz + sz) {

                //注意遍历到最后边元素的边界问题
                merge(arr, i, i + sz - 1, i + sz + sz - 1 > n - 1 ? i + sz + sz - 1 : n - 1);

            }

        }


    }


    //归并操作
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        //通过复制数组来替换原有数组保持顺序
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        //i 是左边元素的起点下标  j是右边元素的起点下标
        int i = l, j = mid + 1;

        //k是用于记录原数组的位置的下标，用于替换
        for (int k = l; k <= r; k++) {

            //判断左边是否排好序
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                //右边排好序
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                //左边元素较小
                arr[k] = aux[i - l];
                i++;
            } else {
                //右边元素较小
                arr[k] = aux[j - l];
                j++;
            }

        }
    }
}
