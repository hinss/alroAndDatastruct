package com.hins.base.alro.leetcode;


import sun.jvm.hotspot.utilities.Assert;


/**
 * @author: hins
 * @created: 2021-06-26 07:40
 * @desc:
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 摩尔投票算法: 核心思想，从一个数列里，每次找出两个不一样的数删除掉，最后剩下的一个数字或者几个相同的数字，
 * 就是出现次数大于总数一半的那个数。
 *
 * 时间复杂度O(n) 空间复杂度O(1) 其它我能想到的排序取中间索引跟查找集计数都不符合性能。
 *
 *
 **/
public class Leetcode169 {

    private Leetcode169(){}

    public int majorityElement(int[] nums) {

        // candidate的含义是暂时无法被抵消掉的数
        int candidate = 0;
        // count的含义是无法被抵消掉的数的个数
        int count = 0;
        for(int num : nums) {

            if(count == 0) {
                // 如果没有需要抵消的数，把当前数设置上去
                candidate = num;
            }
            if(num == candidate) {
                // 如果当前数与需要被抵消的数相同，无法抵消的数++
                count++;
            }
            else{
                // 不相等，实现抵消
                // 这里有两种情况:
                // 1) count为0，无抵消数
                // 2) count不为0,candidate还是目前出现次数最多的数
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

//        int[] nums = {3,2,3};
        int[] nums = {2,1,2,3,2,4,2};
        int res = new Leetcode169().majorityElement(nums);

        Assert.that(res == 2, "测试不通过");
    }


}
