//package com.lzl.leetcode.stack;
//
//import java.util.Stack;
//
///**
// * @auther: marco.li
// * @date: Created in 2020/3/2
// */
//public class TrappingRainWater {
//
//    /**
//     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//     * <p>
//     * <p>
//     * <p>
//     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//     * <p>
//     * 来源：力扣（LeetCode）
//     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
//     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//     */
//
//    public int trap(int[] height) {
//        int n = height.length;
//        if (n <= 2) return 0;
//
//        Stack<Integer> stack = new Stack<>();
//        // 栈底下标
//        int button = 0;
//        int sum = 0;
//        for (int index = 0; index < n; index++) {
//            if (stack.empty() && height[index] != 0) {
//                stack.push(height[index]);
//                button = index;
//            } else if (height[index] <= stack.peek()) {
//                // 小于时入栈
//                stack.push(height[index]);
//            } else if (height[index] > stack.peek()) {
//                stack.pop();
//
//            }
//
//
//            if (height[i] <= stack.peek()) {
//                stack.push(height[i]);
//            } else if (height[i] > stack.peek()) {
//
//                int len = 0;
//                int left = stack.pop();
//                while (true) {
//                    if (stack.peek() > left) {
//
//                    }
//                }
//
//
//                int left = stack.peek();
//                sum += Math.max(left, height[i]);
//            }
//
//        }
//    }
//}
