package com.lzl.leetcode.sort;

import java.util.Arrays;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/26
 */
public class MergeSort {

    /**
     * 二路归并算法 稳定
     * 将问题划分为logn个子问题，每个子问题进行n次操作
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     */
    private int[] sort(int[] numbers) {
        // 设置递归推出条件
        if (numbers.length == 1) {
            return numbers;
        }

        int mid = numbers.length / 2;
        int[] left = Arrays.copyOfRange(numbers, 0, mid);
        int[] right = Arrays.copyOfRange(numbers, mid, numbers.length);
        return merge(sort(left), sort(right));
    }

    /**
     * 二路归并
     *
     * n次操作
     */
    private int[] merge(int[] left, int[] right) {
        int[] rt = new int[left.length + right.length];

        int l = 0, r = 0, i = 0;
        while (l < left.length && r < right.length)
            rt[i++] = left[l] < right[r] ? left[l++] : right[r++];

        while (l < left.length)
            rt[i++] = left[l++];

        while (r < right.length)
            rt[i++] = right[r++];

        return rt;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 6, 3, 7, 8, 2, 4};
        MergeSort mergeSort = new MergeSort();
        numbers = mergeSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
