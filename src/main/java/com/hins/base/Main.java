package com.hins.base;

import com.hins.base.datastruct.linkedList.LinkedListStack;
import com.hins.base.datastruct.linkedList.LinkedListWithDummyHead;

/**
 * @Description:
 * @Author:Wyman
 * @Date:
 */
public class Main {

    public static void main(String[] args) {

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        for (int i=0; i<5; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }

        linkedListStack.pop();

        System.out.println(linkedListStack);
    }
}
