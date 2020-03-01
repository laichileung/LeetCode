package com.lzl.leetcode;

/**
 * @auther: marco.li
 * @date: Created in 2019/11/6
 */
public class MediianSortedArrays {

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

//    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{3};
//
//        System.out.println(findMedianSortedArrays(nums1, nums2));
//
//    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int m = nums1.length;
        int n = nums2.length;
        int k = (m + n) / 2 + 1;
        int[] nums = new int[k];

        for (int i = 0, j = 0, h = 0; (i < m || j < n) && h < k; h++) {
            // all numbers of nums1 are added into nums
            if (i == m) {
                nums[h] = nums2[j++];
                continue;
            }

            // all numbers of nums2 are added into nums
            if (j == n) {
                nums[h] = nums1[i++];
                continue;
            }

            if (nums1[i] < nums2[j]) {
                nums[h] = nums1[i++];
            } else {
                nums[h] = nums2[j++];
            }
        }
        return (m + n) % 2 == 0 ? (nums[k - 1] + nums[k - 2]) / 2.0 : nums[k - 1];
    }

    public static void main(String[] args) {
        System.out.println("190804684750192745".hashCode()%128);
    }
}
