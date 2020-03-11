package com.lzl.leetcode.queue;

import java.util.Arrays;
import java.util.LinkedList;

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


    /**
     * 使用单调双向链表, 存储窗口的下标
     *
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k * nums.length == 0) return new int[0];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // 将第i个元素从队列尾部入队
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);

            // 判断窗口是否划过队列最大值
            if (i - k + 1 > queue.getFirst()) {
                queue.pollFirst();
            }

            // 判断是否达到窗口长度
            if (i >= k - 1) {
                res[index++] = nums[queue.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1};
        SlidingWindowMaximun slidingWindowMaximun = new SlidingWindowMaximun();
        System.out.println(Arrays.toString(slidingWindowMaximun.maxSlidingWindow(nums, 1)));
    }

}
