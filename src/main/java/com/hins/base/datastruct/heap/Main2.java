package com.hins.base.datastruct.heap;

import java.util.Random;

/**
 * @Description:堆测试类 最大堆排序基本原理测试
 * @Author:Wyman
 * @Date:2019/11/22
 */
public class Main2 {

    public static void main(String[] args) {

        int n = 10;

        MaxHeap<Integer> heap = new MaxHeap(n);
        Random random = new Random();

        //往堆中增加100W个随机数(无序的)
        for(int i = 0; i < n; i++){
            heap.add(random.nextInt(20));
        }

        //每次拿出堆中的最大值存到数组中
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = heap.extractMax();
        }

        //判断是否有序
        for(int i = 1; i < arr.length; i++){

            if((arr[i-1] - arr[i]) < 0){
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MaxHeap Completed!");

    }
}
