package com.hins.base.alro;

/**
 * @Description: 插入排序算法Java实现
 * 优化版的插入排序，减少交换次数，改为赋值模式
 * 算法时间复杂度:O(n^2)
 * @Author:Wyman
 * @Date:2019/11/25
 */
public class InsertionSort {



    private InsertionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;

        for(int i = 1; i < n; i++){

            // 寻找元素arr[i]合适的位置插入
            int e = (Integer) arr[i];
            int j;
            int swap = i;
            for( j = i; j > 0 ; j--){
                if(arr[j-1].compareTo(e) > 0){
                    arr[j] = arr[j-1];
                    swap--;
                }
            }
            arr[swap] = e;
        }


    }

    public static void main(String[] args) {

//        Integer[] nums = SortTestHelper.generateRandomArray(10, 0, 100);
        Integer[] datas = new Integer[]{8,9,1,7,2,3,5,4,6,0};
//        SortTestHelper.printArray(datas);
        sort(datas);

//        SortTestHelper.printArray(datas);

    }
}
