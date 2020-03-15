package com.lzl.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/1
 */
public class MyStack {

    private List<Integer> list;

    private int index;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        list = new ArrayList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        list.add(x);
        index++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public Integer pop() {
        if (empty()) {
            return null;
        }
        return list.remove(--index);
    }

    /**
     * Get the top element.
     */
    public Integer top() {
        if (empty()) {
            return null;
        }
        return list.get(index - 1);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return index == 0;
    }
}
