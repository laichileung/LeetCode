package com.lzl.leetcode.slidingWindow;

import java.util.Arrays;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/9
 */
public class SlidingWindowMaximun {
    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * <p>
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     *  
     * <p>
     * 提示：
     * <p>
     * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k * nums.length == 0) return new int[0];
        int l = 0, r = k - 1;
        int[] res = new int[nums.length - k + 1];

        int maxIndex = -1;
        for (; r < nums.length; r++, l++) {
            if (l <= maxIndex) {
                // 最大下标还在窗口中，则判断最右边与当前值大小
                maxIndex = nums[r] >= nums[maxIndex] ? r : maxIndex;
            } else {
                maxIndex = maxIndex(nums, l, r);
            }
            res[l] = nums[maxIndex];
        }
        return res;
    }

    private int maxIndex(int[] nums, int l, int r) {
        int maxIndex = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] >= nums[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        SlidingWindowMaximun slidingWindowMaximun = new SlidingWindowMaximun();
        System.out.println(Arrays.toString(slidingWindowMaximun.maxSlidingWindow(nums, 3)));
    }

}
