package com.hins.base.datastruct.leetcode;

import java.util.HashSet;

/**
 *环形链表
 *
 * 两种方式解决这个判断是否环形链表的问题:
 * 1.遍历链表中的全部元素，把它存到一个Hash结构中，如果新加入的元素在Hash结构中已经存在，则是环形链表。
 * 2.快慢指针的方式，慢指针走一步，快指针走两步，如果最后快指针追上了慢指针，则是环形链表。
 */
public class CircleLinkedList {

    /** 采用Hash存储方式 */
    public boolean hasCycle(ListNode head){

        if(head == null && head.next == null){
            return false;
        }

        HashSet set = new HashSet();
        ListNode cur = head;
        while (cur.next != null){
            if(!set.add(cur)){
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    /** 快慢指针方式 时间复杂度O(n) 空间复杂度O(1) */
    public boolean hasCycleByFastSlowPointer(ListNode head){

        if(head == null || head.next == null){
            return false;
        }

        //慢指针
        ListNode slow = head;

        //快指针
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){

            //慢指针走一步
            slow = slow.next;
            //快指针走两步
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }

        }
        return false;

    }






    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}


