package com.hins.base.alro;

/**
 * @author: hins
 * @created: 2021-06-25 08:36
 * @desc: 学习希尔排序，第一个O(nlog2 n)的算法
 * 本质上是一种分组，然后做插入排序的算法；当gap=0时结束; 当gap分到1时，整个数组基本上是前一半都小于后一半
 *
 * sample: [8,9,1,7,2,3,5,4,6,0]
 *
 * gap为:5
 * 3 9 1 7 2 8 5 4 6 0
 * 3 5 1 7 2 8 9 4 6 0
 * 3 5 1 7 2 8 9 4 6 0
 * 3 5 1 6 2 8 9 4 7 0
 * 3 5 1 6 0 8 9 4 7 2
 * gap为:2
 * 1 5 3 6 0 8 9 4 7 2
 * 1 5 3 6 0 8 9 4 7 2
 * 0 5 1 6 3 8 9 4 7 2
 * 0 5 1 6 3 8 9 4 7 2
 * 0 5 1 6 3 8 9 4 7 2
 * 0 4 1 5 3 6 9 8 7 2
 * 0 4 1 5 3 6 7 8 9 2
 * 0 2 1 4 3 5 7 6 9 8
 * gap为:1
 * 0 2 1 4 3 5 7 6 9 8
 * 0 1 2 4 3 5 7 6 9 8
 * 0 1 2 4 3 5 7 6 9 8
 * 0 1 2 3 4 5 7 6 9 8
 * 0 1 2 3 4 5 7 6 9 8
 * 0 1 2 3 4 5 7 6 9 8
 * 0 1 2 3 4 5 6 7 9 8
 * 0 1 2 3 4 5 6 7 9 8
 * 0 1 2 3 4 5 6 7 8 9
 **/
public class ShellSort {

    private ShellSort(){}

    public static void sort(Comparable[] arr){

        int len = arr.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = (Integer) arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && (Integer)arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;

            }
            gap /= 2;
        }

    }

    public static void main(String[] args) {

//        Integer[] datas = SortTestHelper.generateRandomArray(10, 0, 100);
        Integer[] datas = new Integer[]{8,9,1,7,2,3,5,4,6,0};

        sort(datas);

    }
}
