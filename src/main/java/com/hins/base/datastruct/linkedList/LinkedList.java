package com.hins.base.datastruct.linkedList;

/**
 * @Description: 单链表的基本实现
 * @Author:Wyman
 * @Date:2019/11/23
 */
public class LinkedList<E> {


    /**
     * 内部存储的节点类
     */
    private class Node{

        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;
    private int size;

    /**
     * 默认构造函数
     */
    public LinkedList(){

        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    /**
     * 往链表头添加元素
     */
    public void addFirst(E e){

        Node node = new Node(e);
        node.next = head;
        head = node;

        size++;

    }

    private void add(int index,E e){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            for(int i = 0 ; i < index - 1 ; i ++) {
                prev = prev.next;
            }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e, prev.next);
            size ++;
        }
    }

    /**
     * 往链表的尾部添加元素
     */
    public void addLast(E e){

        add(size,e);

    }









}
