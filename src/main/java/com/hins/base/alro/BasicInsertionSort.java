package com.hins.base.alro;

/**
 * @author: hins
 * @created: 2021-06-25 07:07
 * @desc: 基本插入排序算法实现
 **/
public class BasicInsertionSort {

    private BasicInsertionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;

        // 外层循环从1开始，因为是往前比较
        for(int i=1; i<n; i++){

            for(int j=n-1;j>0; j--) {
                if(arr[j].compareTo(arr[j-1]) < 0){
                    swap(arr,j,j-1);
                }
            }

        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        Integer[] nums = SortTestHelper.generateRandomArray(10, 0, 100);
        SortTestHelper.printArray(nums);
        BasicInsertionSort.sort(nums);

        SortTestHelper.printArray(nums);
    }


}
