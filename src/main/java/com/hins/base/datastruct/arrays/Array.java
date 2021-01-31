package com.hins.base.datastruct.arrays;

/**
 * @Description: 动态数组
 * @Author:Wyman
 * @Date:2019/11/22
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {

        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        //默认10的容量
        this(10);
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapacity(){

        return data.length;
    }

    /**
     * 获取数组元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在index处新增一个元素
     * @param index
     * @param e
     */
    public void add(int index,E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        //判断是否扩容
        if(size == data.length){
            resize(data.length * 2);
        }

        for(int i = size - 1; i >= index ; i --) {
            data[i + 1] = data[i];
        }

        //存储元素
        data[index] = e;

        size++;
    }

    /**
     * 向所有元素前添加一个新元素
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 向所有元素后添加一个新元素
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获取index索引位置的元素e
     */
    public E get(int index){

        if(index < 0 || index >= size) {

            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        return data[index];
    }

    /**
     * 修改索引位置的元素
     */
    public void set(int index,E e){

        if(index < 0 || index >= size) {

            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }

        data[index] = e;
    }

    /**
     * 查找数组中是否含有元素e
     */
    public boolean contains(E e){

        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素的索引
     */
    public int find(E e){

        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     */
    public E remove(int index){

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for(int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        data[size] = null; // loitering objects != memory leak

        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;

    }

    /**
     * 从数组中删除元素e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    /**
     * 从数组中删除第一个元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 交换操作
     * @param i
     * @param j
     */
    public void swap(int i,int j){

        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }


    /**
     * 数组扩容方法
     * @param newsLength
     */
    private void resize(int newsLength) {

        E[] newArr = (E[]) new Object[newsLength];
        for(int i = 0; i < size; i++){
            newArr[i] = data[i];
        }
        data = newArr;

    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }


}
