package com.hins.base.alro;

/**
 * @Description: 冒泡排序Java实现 该版本是为了优化内层循环
 * @Author:Wyman
 * @Date:2019
 */
public class BubbleSort {

    public static void sort(Comparable[] arr){

        int n = arr.length;
        int k = n-1, sortBorder = n-1;

        for(int i = 0; i < n-1; i++){

            //有序标志，防止已经在中间某次排好序了，冒泡排序还继续进行下去
            boolean isSorted = true;
            //无序标记，每次比较比到这里为止
            for(int j = 0; j < k; j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                   swap(arr,j,j+1);

                   isSorted = false;

                    sortBorder = j;
                }
            }

            k = sortBorder;

            if(isSorted){
                break;
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {

//        int N = 20000;
        Integer[] arr = new Integer[]{3,5,38,15,44,47};
        BubbleSort.sort(arr);

        System.out.println(SortTestHelper.isSorted(arr));

    }
}
