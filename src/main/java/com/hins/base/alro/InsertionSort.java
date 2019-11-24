package com.hins.base.alro;

/**
 * @Description: 插入排序算法Java实现
 * @Author:Wyman
 * @Date:2019
 */
public class InsertionSort {

    private InsertionSort(){}

    public static void sort2(Comparable[] arr){

        int n = arr.length;

        for(int i = 1; i < n; i++){

            // 寻找元素arr[i]合适的位置插入

            for(int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--){
                    swap(arr,j,j-1);
            }
        }

    }

    //优化版的插入排序，减少交换次数，改为赋值模式
    public static void sort(Comparable[] arr){

        int n = arr.length;

        for(int i = 1; i < n; i++){

            // 寻找元素arr[i]合适的位置插入
            int e = (Integer) arr[i];
            int j;
            for( j = i; j > 0 && arr[j-1].compareTo(e) > 0 ; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }

    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {

        int N = 30000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,10000);
        Integer[] arr2 = SortTestHelper.copyArr(arr);

        //初步比较插入排序和选择排序算法性能
        SortTestHelper.testSort("com.hins.algorithm.SelectionSort",arr);
        SortTestHelper.testSort("com.hins.algorithm.InsertionSort",arr2);

        //没有经过优化前，即使插入排序会减少循环的次数，但是由于交换次数增多，时间会比选择排序还要长！

    }
}
