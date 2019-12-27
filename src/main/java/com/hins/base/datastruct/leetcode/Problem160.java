package com.hins.base.datastruct.leetcode;

/**
 * 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始位置
 * 特点:
 *   1)相交的条件是: 两个节点完全相同也就是 pa = pb 而不是仅仅 pa.val = pb.val 就行了
 *   2)相交之后的部分都是相等的
 *
 *   8
 *  [4,1,8,4,5]
 *  [5,0,1,8,4,5]
 *  2
 *  3
 */
public class Problem160 {

    /** 双指针法，最好画一个图模拟过程 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    public static void main(String[] args) {


    }
}
