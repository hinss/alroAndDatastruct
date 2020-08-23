package com.hins.base.datastruct.leetcode;

/**
 * @author: hins
 * @created: 2020-08-24 06:53
 * @desc: Remove-Linked-List-Element
 *
 * public class ListNode{
 *     int val;
 *     ListNode next;
 *     ListNode(int x){ val = x; }
 * }
 *
 **/
public class Problem203 {

    public ListNode removeElements(ListNode head, int val){

        // 处理头部全部符合删除元素情况
        while(head != null && head.val == val){
            head = head.next;
        }

        if(head == null){
            return null;
        }

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }

        return head;
    }

    public ListNode removeElementsWithDummyHead(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }

        return dummyHead.next;

    }



}
