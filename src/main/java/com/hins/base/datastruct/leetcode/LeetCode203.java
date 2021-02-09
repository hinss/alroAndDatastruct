package com.hins.base.datastruct.leetcode;

/**
 * @author: hins
 * @created: 2021-02-09 09:57
 * @desc: 移除链表元素
 **/
public class LeetCode203 {

    public static ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        cur.next = head;

        while(head != null) {

            if (head.val == val) {
                cur.next = head.next;
                head = head.next;
            } else {
                // just forward move two pointer...
                head = head.next;
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(6);
        listNode.next.next = new ListNode(5);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(6);

        listNode = removeElements(listNode, 6);

        System.out.println("DEBUG");

    }


}
