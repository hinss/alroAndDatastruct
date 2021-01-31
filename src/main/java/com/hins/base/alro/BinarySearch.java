package com.hins.base.alro;

/**
 * @Description: 二分查找算法
 * @Author:Wyman
 * @Date:2019/11/24
 */
public class BinarySearch {

    /**
     * 算法类不允许产生任何实例
     */
    private BinarySearch(){

    }

    /**
     * 二分查找法,在有序数组arr中,查找target
     * 如果找到target,返回相应的索引index
     * 如果没有找到target 返回index
     */
    public static int binarySearch(Comparable[] sortedArr,Comparable target){

        //arr[l...r]之中查找target
        int l = 0,r = sortedArr.length - 1;
        while(l <= r){

            // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
            int mid = l + (r-l)/2;
            if(sortedArr[mid].compareTo(target) == 0){
                return mid;
            }

            if(sortedArr[mid].compareTo(target) > 0){
                r = mid - 1;
            }else{
                l = mid + 1;
            }

        }

        return -1;

    }
}
