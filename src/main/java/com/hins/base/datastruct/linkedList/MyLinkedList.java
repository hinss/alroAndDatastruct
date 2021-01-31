package com.hins.base.datastruct.linkedList;

public class MyLinkedList {

    private class Node{
        int val;
        Node next;
        Node(int x){
            this.val = x;
        }
    }

    //头节点
    Node head;
    int size;


    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        if(index < 0 || index >= size){
            return -1;
        }

        Node cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }

        return cur.val;
    }

    public Node getNode(int index){

        if(index < 0 || index >= size){
            return  null;
        }

        Node cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }

        return cur;
    }


    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        Node cur = new Node(val);
        cur.next = head;
        head = cur;

        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);

    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list,
     * the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if(index < 0 || index > size ){
            return;
        }

        if(index == 0){
            addAtHead(val);
        }else{
            Node prev = head;
            for(int i = 0; i < index - 1; i++){
                prev = prev.next;
            }

            Node node = new Node(val);
            node.next = prev.next;
            prev.next = node;

        }

        size++;

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if(index < 0 || index >= size){
           return;
        }

        if(index == 0){
            head = head.next;
        }else{
            Node prev = getNode(index - 1);
            if (prev == null) return;
            prev.next = prev.next.next;

        }
        size--;
    }





    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        while(head != null){
            res.append(head.val);
            res.append("->");
            head = head.next;
        }
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {

        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.deleteAtIndex(1);


    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
