package com.hins.base.datastruct.leetcode;

/**
 * 反转链表:反转一个单链表。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }

        return prev;

    }



    public static void main(String[] args) {

        ListNode myLinkedList1 = new ListNode(5);
        ListNode myLinkedList2 = new ListNode(4);
        ListNode myLinkedList3 = new ListNode(3);
        ListNode myLinkedList4 = new ListNode(2);
        ListNode myLinkedList5 = new ListNode(1);

        myLinkedList1.next = myLinkedList2;
        myLinkedList2.next = myLinkedList3;
        myLinkedList3.next = myLinkedList4;
        myLinkedList4.next = myLinkedList5;
        myLinkedList2.next = myLinkedList3;

    }
}

