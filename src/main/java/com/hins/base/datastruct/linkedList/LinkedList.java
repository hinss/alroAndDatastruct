package com.hins.base.datastruct.linkedList;

/**
 * @Description: 单链表的基本实现
 *
 * 对于单链表来说，需要清晰的点:
 * 1)初始化一个默认的链表时，链表中的头指针指向Null。
 * 2)往链表头添加元素，实际上只需要构造Node对象，并且指向head引用，再把新增的节点设置为head头指针。
 * 3)往指定的index中添加元素，cur指针只需要移动index-1次。
 *
 *
 *
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
    public void addFirst(E e) {

        // 这一步相当于前面3步合在一起。
        head = new Node(e, head);
        size++;
    }

    // 在链表的index(0-based)位置添加新的元素e
    private void add(int index,E e) {

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            for(int i = 0 ; i < index - 1 ; i ++) {
                prev = prev.next;
            }

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
