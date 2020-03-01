package com.lzl.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用list构造
 *
 * @auther: marco.li
 * @date: Created in 2020/3/1
 */
public class MinStack {

    /**
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     * <p>
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-stack
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    private List<Integer> list;

    private int index;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        list = new ArrayList();
    }

    public void push(int x) {
        list.add(x);
        index++;
    }

    public void pop() {
        list.remove(--index);
    }

    public int top() {
        return list.get(index - 1);
    }

    public int getMin() {
        Integer min = list.get(0);
        for (Integer i : list) {
            if (i < min) min = i;
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        //   --> 返回 -3.
        System.out.println(minStack.getMin());
        minStack.pop();
        // --> 返回 0.
        System.out.println(minStack.top());
        //--> 返回 -2.
        System.out.println(minStack.getMin());
    }
}
