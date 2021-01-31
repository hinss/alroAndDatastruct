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

    /**
     * 递归思想解决问题
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsInRecursive(ListNode head, int val){

        if(head == null){
            return null;
        }

        ListNode res = removeElementsInRecursive(head.next, val);
        if(head.val == val){
            head = res;
        }else{
            head.next = res;
        }

        return head;

    }


    public static void main(String[] args) {

        int[] nums = new int[]{2,4,6,5,7,6};

        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

//        ListNode res = new Problem203().removeElements(listNode, 2);
        ListNode res = new Problem203().removeElementsInRecursive(listNode,6);
        System.out.println(res);

    }



}
