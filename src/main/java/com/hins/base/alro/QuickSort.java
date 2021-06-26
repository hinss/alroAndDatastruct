package com.hins.base.alro;

/**
 * @Description: 快速排序基本实现
 * @Author:Wyman
 * @Date:2019/11/25
 */
public class QuickSort {



    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr,0,n-1);


    }

    /** 递归调用的快速排序过程 */
    private static void sort(Comparable[] arr, int l, int r){

        if(l >= r){
            return ;
        }

        //返回中位数的
        int p = partition(arr,l,r);
        //递归左边
        sort(arr,l,p-1);
        //递归右边
        sort(arr,p+1,r);

    }

    /** 分组函数 */
    private static int partition(Comparable[] arr, int l,int r){

        Comparable v = arr[l];

        int j = l;
        for(int i = l+1; i <= r; i++){

            if(arr[i].compareTo(v) > 0){
                j++;
                swap(arr,j,i);
            }
        }

        swap(arr,l,j);


        return j;
    }


    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {

//        Integer[] arr = new Integer[]{3,8,5,11,2,7,1,4,6,22};
//        QuickSort.sort(arr);
//
//        for(int i = 0; i < arr.length; i++){
//            System.out.print(arr[i]);
//            System.out.print(" ");
//        }

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = SortTestHelper.copyArr(arr);

        SortTestHelper.testSort("com.hins.base.alro.QuickSort",arr2);
//        SortTestHelper.testSort("com.hins.base.alro.BasicMergeSort",arr);

        return ;

    }
}
