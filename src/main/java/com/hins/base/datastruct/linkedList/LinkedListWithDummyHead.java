package com.hins.base.datastruct.linkedList;

/**
 * @Description: 带有虚拟头结点的链表
 * @Author:Wyman
 * @Date: 2021-01-31
 */
public class LinkedListWithDummyHead<E> {

    private class Node {

        public E value;
        public Node next;

        public Node(){}

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this.value = value;
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListWithDummyHead(){
        this.dummyHead = new Node(null,null);
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int index, E e) {

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }
}
