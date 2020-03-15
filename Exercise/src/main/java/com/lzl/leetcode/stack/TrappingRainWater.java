package com.lzl.leetcode.stack;

import java.util.Stack;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/2
 */
public class TrappingRainWater {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * <p>
     * <p>
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 暴力法
     * 找出每个柱子左边的最高柱子高度left, 以及右边的最高柱子高度right，
     * 当前柱子能容纳雨水量 f(n) = {min（left, right） - height[n] } * 1
     * <p>
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     */
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = 0, right = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > left) left = height[j];
            }
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > right) right = height[j];
            }

            // 双边大于当前块才能容纳雨水
            if (left > height[i] && right > height[i]) {
                sum += (Math.min(left, right) - height[i]);
            }
        }

        return sum;
    }

    /**
     * 动态规划
     * 在暴力法中，针对第i个柱子，我们都需要遍历寻找left跟right。
     * 用两个数组left[] right[] 分别记录前i个柱子的最大高度，以及后i个柱子的最大高度
     * left(i) = max(height[i], left(i-1)) height.length > i > 1;
     * right(i) = max(height[i], left(i+1)) height.length-1 > i > 0;
     *
     * 时间复杂度O(n)
     * 空间复杂度O(2n)
     */
    public int trap2(int[] height) {
        if (height.length < 2) return 0;

        int left[] = new int[height.length];
        int right[] = new int[height.length];
        int sum = 0;

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            if (left[i] > height[i] && right[i] > height[i]) {
                sum += Math.min(left[i], right[i]) - height[i];
            }
        }
        return sum;
    }

    /**
     * 栈
     *
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int trap3(int[] height) {
        if (height.length < 2) return 0;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();
                // 没有左边界
                if (stack.empty()) break;
                int left = stack.peek();
                sum += (Math.min(height[i], height[left]) - height[mid]) * (i - left - 1);
            }
            stack.push(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(height));
        System.out.println(trappingRainWater.trap2(height));
        System.out.println(trappingRainWater.trap3(height));
    }
}
