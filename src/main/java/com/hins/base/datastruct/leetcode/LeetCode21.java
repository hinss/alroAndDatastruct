package com.hins.base.datastruct.leetcode;

/**
 * @Description: 合并两个链表
 * @Author:Wyman
 * @Date:
 */
public class LeetCode21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        while(l1 != null || l2 != null){

            if (l1 == null) {
                cur.next = l2;
                return pre.next;
            }

            if (l2 == null) {
                cur.next = l1;
                return pre.next;
            }

            if(l1.val == l2.val) {
                cur.next = new ListNode(l1.val, cur.next);
                cur = cur.next;
                cur.next = new ListNode(l2.val, cur.next);
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }

            if(l1.val < l2.val) {
                cur.next = new ListNode(l1.val, cur.next);
                cur = cur.next;
                l1 = l1.next;
            }else {
                cur.next = new ListNode(l2.val, cur.next);
                cur = cur.next;
                l2 = l2.next;
            }
        }

        return pre.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(3);
        listNode2.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(listNode1, listNode2);


    }
}
