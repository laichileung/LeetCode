package com.lzl.leetcode.stack;

import java.util.Stack;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/1
 */
public class MinStack4 {

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


    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack4() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        if (minStack.empty()) {
            minStack.push(x);
        } else if (x <= minStack.peek()) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public Integer top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack4 minStack = new MinStack4();
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
