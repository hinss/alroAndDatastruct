package com.hins.base;

import com.hins.base.datastruct.linkedList.LinkedListWithDummyHead;

/**
 * @Description:
 * @Author:Wyman
 * @Date:
 */
public class Main {

    public static void main(String[] args) {

        LinkedListWithDummyHead<Integer> linkedListWithDummyHead = new LinkedListWithDummyHead();
        for (int i=0; i<5; i++) {
            linkedListWithDummyHead.addFirst(i);
            System.out.println(linkedListWithDummyHead);
        }

        linkedListWithDummyHead.set(2, 888);

        System.out.println(linkedListWithDummyHead);
    }
}
