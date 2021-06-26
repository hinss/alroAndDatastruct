package com.hins.base.alro.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author: hins
 * @created: 2021-06-26 06:12
 * @desc: 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 使用归并算法可以解决 时间复杂度O(n) 但是对于这个场景多复制了一次。
 *
 * 2021-06-26 15:31 正向归并算法无法解决nums1:{0} m=0 nums2:{1} n=1 的场景
 *
 * 因为nums1是数组后面留有空间，所以用逆向双指针的方式比较好，从最大数开始赋值。
 **/
public class Leetcode88 {

    private Leetcode88(){}

    /**
     *
     * @param nums1
     * @param m nums1 元素数量
     * @param nums2
     * @param n nums2 元素数量
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        if(n == 0) {
            return ;
        }

        if(m==0) {
            for(int i=0;i<nums2.length;i++){
                nums1[i] = nums2[i];
            }
            return ;
        }

        // nums1要存放最终结果，所以aux[] copy出来代替nums1进行比较
        int[] aux = Arrays.copyOf(nums1, m+n);

        int l=0, r=m+n-1, mid= (l+r)/2;

        int i=l, j=mid+1;

        for(int k=0; k<=r; k++) {

            if(i>mid) {
                // 左边已经排好序的情况
                nums1[k] = nums2[j-m];
                j++;
            }
            else if(j>r) {
                // 右边排好序的情况
                nums1[k] = aux[i];
                i++;
            }
            // 下面两种都是左、右边还没有排好序的情况
            else if(aux[i] <= nums2[j-m]){
                // 左边数小,取左边的数
                nums1[k] = aux[i];
                i++;
            }
            else{
                // 右边数小，取右边的数
                nums1[k] = nums2[j-m];
                j++;
            }
        }
    }

    /**
     * 从后往前的下标移动方法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;

        for(int k=m+n-1; k>=0; k--) {

            if(i < 0) {
                nums1[k] = nums2[j];
                j--;
            }
            else if(j < 0){
                nums1[k] = nums1[i];
                i--;
            }
            else if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;

            }
        }
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};

        new Leetcode88().merge(nums1, 0,nums2,1);

        IntStream.of(nums1).forEach(System.out::println);



    }


}
