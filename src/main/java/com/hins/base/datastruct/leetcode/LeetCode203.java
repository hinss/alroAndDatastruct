package com.hins.base.datastruct.leetcode;

/**
 * @Description: 链表 反转链表
 * @Author:Wyman
 * @Date: 2021-02-08
 */
public class LeetCode203 {

    /**
     * 双指针迭代法
     */
    public static ListNode reverseInTraverseWay(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 递归解法
     */
    public static ListNode recursionWay(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = recursionWay(head.next);
        head.next.next = head;
        head.next = null;

        return cur;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        listNode = reverseInTraverseWay(listNode);
        System.out.println(listNode);
    }

}
