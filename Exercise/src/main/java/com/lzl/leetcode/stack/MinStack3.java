package com.lzl.leetcode.stack;

/**
 * 使用数组构造
 *
 * @auther: marco.li
 * @date: Created in 2020/3/1
 */
public class MinStack3 {

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

    private int index;

    private static int APPEND_SIZE = 10;

    /**
     * initialize your data structure here.
     */
    public MinStack3() {
        array = new Integer[APPEND_SIZE];
    }

    public void push(int x) {
        // 扩展数组
        malloc();
        array[index++] = x;
    }

    public void pop() {
        index--;
    }

    public Integer top() {
        if(index == 0){
            return null;
        }
        return array[index-1];
    }

    public int getMin() {
        Integer min = array[0];
        for(int i=1; i<index; i++){
            if(array[i] < min) min = array[i];
        }
       return min;
    }

    private void malloc(){
        if(index >= array.length){
            Integer[] array2 = new Integer[array.length + APPEND_SIZE];
            // copy
            for(int i=0; i< array.length; i++){
                array2[i] = array[i];
            }
            // swap
            array = array2;
        }
    }

    public static void main(String[] args) {
        MinStack3 minStack = new MinStack3();
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
