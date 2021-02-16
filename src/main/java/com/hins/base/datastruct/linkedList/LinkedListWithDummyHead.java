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

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
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

    public void addFirst(E e) {
        add(0, e);
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


    public E get(int index) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.value;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.value = e;
    }

    public E remove(int index){

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i=0; i<index; i++) {
            prev = prev.next;
        }

        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;

        return cur.value;
    }

    public E removeFirst() {
        return remove(0);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for( Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur).append(" -> ");
        }

        sb.append("NULL");

        return sb.toString();
    }
}
