package com.hins.base.datastruct.heap;

import com.hins.base.datastruct.arrays.Array;

/**
 * @Description: 最大堆(动态数组实现方式)
 * @Author:Wyman
 * @Date:2019/11/22
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    /**
     * 返回堆中的元素个数
     * @return
     */
    public int size(){
        return data.getSize();
    }

    /**
     * 判断堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，
     * 一个索引所表示的元素的父亲节点的索引(根节点为索引0开始)
     */
    private int parent(int index){

        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }

        return (index - 1) / 2;
    }

    /**
     * 获取左孩子的数组索引
     * @param index
     * @return
     */
    private int leftChild(int index){

        return index * 2 + 1;
    }

    /**
     * 获取右孩子的数组索引
     * @param index
     * @return
     */
    private int rightChild(int index){

        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     */
    public void add(E e){

        //向动态数组的末尾添加一个元素
        data.addLast(e);

        //上浮sift up操作
        siftUp(data.getSize()-1);

    }

    /**
     * 上浮元素
     * @param i
     */
    private void siftUp(int i) {

        //如果新添加的元素比父元素大，递归执行交换操作
        while(i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0){

            data.swap(i,parent(i));
            //重新设置当前索引
            i = parent(i);
        }
    }

    /**
     * 查看堆中的最大元素
     */
    public E findMax(){

        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }

        return data.get(0);

    }

    /**
     * 取出堆中最大元素
     */
    public E extractMax(){

        E ret = findMax();

        //将最后的元素与头元素交换
        data.swap(0,data.getSize() - 1);
        //将末尾的元素删除
        data.removeLast();

        siftDown(0);

        return ret;

    }


    /**
     * 元素下沉操作
     * @param k
     */
    private void siftDown(int k) {

        //如果左边子节点的下标大于数组的元素个数，证明没有元素
        while(leftChild(k) < data.getSize()){
            // 在此轮循环中,data[k]和data[j]交换位置
            int j = leftChild(k);
            //当右边子节点也存在，切右子节点大于左子节点时
            if( j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0 ) {
                j++;
            }

            try {
                // data[j] 是 leftChild 和 rightChild 中的最大值
                if(data.get(k).compareTo(data.get(j)) >= 0 ) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("k:" + k + " " + "j:" +j);

            }

            data.swap(k, j);
            k = j;

        }
    }


}
