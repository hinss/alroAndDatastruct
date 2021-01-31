package com.hins.base.alro;

import java.util.Arrays;

/**
 * @Description: 归并排序算法Java实现
 * @Author:Wyman
 * @Date:2019
 */
public class MergeSort2 {

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr,0,n-1);
    }

    //递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        //递归终止条件，到最下层每个都是一个元素独立
        if(r - l <= 15){
            //调用插入算法 insertionSort(arr,l,r);
            return ;
        }


        int mid = (l + r) / 2;

        //对左边的元素进行排序
        sort(arr,l,mid);
        //对右边的元素进行排序
        sort(arr,mid+1,r);

        if(arr[mid].compareTo(arr[mid + 1]) < 0) {
            //归并
            merge(arr, l, mid, r);
        }

    }

    //归并操作
    private static void merge(Comparable[] arr,int l,int mid,int r){

        //通过复制数组来替换原有数组保持顺序
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        //i 是左边元素的起点下标  j是右边元素的起点下标
        int i = l,j = mid+1;

        //k是用于记录原数组的位置的下标，用于替换
        for(int k = l; k <= r; k++){

            //判断左边是否排好序
            if(i > mid){
                arr[k] = aux[j-l];
                j++;
            }else if(j > r){
                //右边排好序
                arr[k] = aux[i-l];
                i++;
            }else if(aux[i-l].compareTo(aux[j-l]) < 0){
                //左边元素较小
                arr[k] = aux[i - l];
                i++;
            }else{
                //右边元素较小
                arr[k] = aux[j - l];
                j++;
            }

        }




    }


    public static void main(String[] args) {

        int N = 20000;

        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] arr2 = SortTestHelper.copyArr(arr);

        SortTestHelper.testSort("com.hins.base.alro.MergeSortBU",arr);
        SortTestHelper.testSort("com.hins.base.alro.MergeSort2",arr2);

    }

}
