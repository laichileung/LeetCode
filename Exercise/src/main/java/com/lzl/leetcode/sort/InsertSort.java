package com.lzl.leetcode.sort;

import java.util.Arrays;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/26
 */
public class InsertSort {

    /**
     * 插入排序
     * 时间复杂度O(n2)
     */
    private void insertSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int temp = numbers[i];
            int j = i;
            for (; j > 0 && temp < numbers[j - 1]; j--) {
                // 将j往后挪动
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 6, 3, 7, 8, 2, 4};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
