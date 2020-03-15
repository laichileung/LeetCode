package com.lzl.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/6
 */
public class ContinuousSequence {

    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * <p>
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     * 示例 2：
     * <p>
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     *  
     * <p>
     * 限制：
     * <p>
     * 1 <= target <= 10^5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 滑动窗口
     */
    public int[][] findContinuousSequence2(int target) {
        List<int[]> rest = new ArrayList<>();

        for (int l = 1, r = 2; r <= (target / 2 + 1) && l < r; ) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum < target) r++;
            if (sum > target) l++;
            if (sum == target) {
                int[] rt = new int[r - l + 1];
                for (int k = 0, j = l; k < rt.length; k++, j++) {
                    rt[k] = j;
                }
                rest.add(rt);
                l++;
            }
        }
        int[][] result = new int[rest.size()][];
        for (int i = 0; i < rest.size(); i++) {
            result[i] = rest.get(i);
        }
        return result;
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < target; i++) {
            int t = 0;
            int j = i;
            for (; t < target; j++) {
                t += j;
            }
            if (t == target) {
                int[] rt = new int[j - i];
                for (int k = i, h = 0; k < j; k++, h++) {
                    rt[h] = k;
                }
                list.add(rt);
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        ContinuousSequence continuousSequence = new ContinuousSequence();
//        System.out.println(Arrays.deepToString(continuousSequence.findContinuousSequence(9)));
        System.out.println(Arrays.deepToString(continuousSequence.findContinuousSequence2(9)));
    }
}
