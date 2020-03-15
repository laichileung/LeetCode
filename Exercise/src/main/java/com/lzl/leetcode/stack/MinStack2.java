package com.lzl.leetcode.stack;

import org.openjdk.jol.info.ClassLayout;

/**
 * 使用数组构造
 *
 * @auther: marco.li
 * @date: Created in 2020/3/1
 */
public class MinStack2 {

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

    private Integer[] array;

    // 使用辅助数组作为最小值
    private Integer[] minArray;

    private int index;

    private int mIndex;

    /**
     *
     */
    private static int APPEND_SIZE = 1024;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        array = new Integer[APPEND_SIZE];
        minArray = new Integer[APPEND_SIZE];
    }

    public void push(int x) {
        // 扩展数组
        array = malloc(array, index);
        minArray = malloc(minArray, mIndex);

        if (mIndex == 0) {
            minArray[mIndex++] = x;
        } else if (x <= minArray[mIndex - 1]) {
            // 小于等于最小值时入栈
            minArray[mIndex++] = x;
        }

        array[index++] = x;
    }

    public void pop() {
        // 当前值==最小值时，minArray出栈
        if (array[--index].equals(minArray[mIndex - 1])) {
            mIndex--;
        }
    }

    public Integer top() {
        if (index == 0) {
            return null;
        }
        return array[index - 1];
    }

    // 使用辅助数组将查询降为O(1)
    public Integer getMin() {
        if (mIndex == 0) {
            return null;
        }
        return minArray[mIndex - 1];
    }

    private Integer[] malloc(Integer[] array, Integer idx) {
        if (idx >= array.length) {
            Integer[] array2 = new Integer[array.length + APPEND_SIZE];
            // copy
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[i];
            }
            return array2;
        }
        return array;
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
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
        System.out.println(ClassLayout.parseInstance(minStack).toPrintable());
        System.out.println(ClassLayout.parseInstance(minStack.array).toPrintable());
    }
}
