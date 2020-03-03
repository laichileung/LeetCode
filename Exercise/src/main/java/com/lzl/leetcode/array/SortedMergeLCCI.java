package com.lzl.leetcode.array;

import java.util.Arrays;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/3
 */
public class SortedMergeLCCI {

    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     * <p>
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public void merge(int[] A, int m, int[] B, int n) {
        int[] res = new int[n + m];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            res[index++] = A[i] < B[j] ? A[i++] : B[j++];
        }

        while (i < m) {
            res[index++] = A[i++];
        }

        while (j < n) {
            res[index++] = B[j++];
        }

        for (int k = 0; k < res.length; k++) {
            A[k] = res[k];
        }

        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;

        SortedMergeLCCI sortedMergeLCCI = new SortedMergeLCCI();
        sortedMergeLCCI.merge(A, m, B, n);

    }
}
