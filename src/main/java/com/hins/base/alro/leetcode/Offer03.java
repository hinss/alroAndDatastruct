package com.hins.base.alro.leetcode;

import sun.jvm.hotspot.utilities.Assert;

/**
 * @author: hins
 * @created: 2021-06-28 08:10
 * @desc:
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 一个萝卜一个坑，使用原地置换算法
 *
 **/
public class Offer03 {

    private Offer03(){}

    public int findRepeatNumber(int[] nums) {
        int swap = 0;
        for(int i=0; i<nums.length; i++){
            // 判断当前在这个坑的数字是否属于这个坑
            while(nums[i] != i) {
                // while 循环直到该坑占的数字被换过来
                if(nums[i] == nums[nums[i]]){
                    // 如果当前坑上的数字所对应的坑已经被占了，证明有重复
                    return nums[i];
                }else{
                    // 交换
                    swap = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = swap;
                }

            }
            // 坑上的数字属于这个坑，则移到下一个
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int res = new Offer03().findRepeatNumber(nums);

        Assert.that(res == 2 || res == 3, "测试不通过");

    }

}
