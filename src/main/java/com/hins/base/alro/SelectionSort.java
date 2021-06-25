package com.hins.base.alro;

import java.util.Arrays;

/**
 * 选择排序
 * 算法时间复杂度:O(n^2)
 */
public class SelectionSort {

    /**
     *  我们的算法类不允许产生任何实例
     */
    private SelectionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        // 外层循环次数
        for(int i=0; i<n; i++) {
            int minIndex = i;
            // 内层循环遍历找出最小值的index
            for(int j=i+1; j<n; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 测试Integer
//        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
//        SelectionSort.sort(a);
//        for( int i = 0 ; i < a.length ; i ++ ){
//            System.out.print(a[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//
//        // 测试Double
//        Double[] b = {4.4, 3.3, 2.2, 1.1};
//        SelectionSort.sort(b);
//        for( int i = 0 ; i < b.length ; i ++ ){
//            System.out.print(b[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//
//        // 测试String
//        String[] c = {"D", "C", "B", "A"};
//        SelectionSort.sort(c);
//        for( int i = 0 ; i < c.length ; i ++ ){
//            System.out.print(c[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//
//        // 测试自定义的类 Student
//        Student[] d = new Student[4];
//        d[0] = new Student("D",90);
//        d[1] = new Student("C",100);
//        d[2] = new Student("B",95);
//        d[3] = new Student("A",95);
//        SelectionSort.sort(d);
//        for( int i = 0 ; i < d.length ; i ++ )
//            System.out.println(d[i]);
//


        // 测试排序算法辅助函数
//        int N = 200000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
//        SortTestHelper.testSort("com.hins.base.alro.SelectionSort", arr);
//        SortTestHelper.testSort("com.hins.base.alro.InhanceBubbleSort", arr);
//        assert false;
//
//        System.out.println( "过了assert断言");

//        Integer[] arr1 = new Integer[]{1,2,3,4};
//        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
//        arr1[0] = 8;
//        System.out.println(arr1[0]);
//        System.out.println(arr2[0]);



    }
}
