package com.lzl.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: marco.li
 * @date: Created in 2019/9/25
 */
public class SumOfTwoNums {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(solution1(nums, 9)));
        System.out.println(Arrays.toString(solution2(nums, 9)));
        System.out.println(Arrays.toString(solution3(nums, 9)));
    }

    /**
     * 暴力法
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     */
    public static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("numbers not found");
    }

    /**
     * 两次遍历hash表
     * 以空间换时间，从hash表中查询时间降低到O(1)
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i]) && numsMap.get(target - nums[i]) != i) {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("numbers not found");
    }

    /**
     * 单次遍历hash表
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * <p>
     * 注意：需要判断map中有无元素满足条件，没有的时候才将元素放入hash表中，否则出现冲突时会丢失键
     */
    public static int[] solution3(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
            numsMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("numbers not found");
    }

}
