package com.lzl.leetcode.sort;

import java.util.Arrays;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/27
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * 时间复杂度O(n2)
     */
    private void sort(int[] numbers) {
        for (int i = numbers.length - 1; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(numbers, j, j - 1);
                }
            }
        }
    }

    private void swap(int[] numbers, int l, int r) {
        int temp = numbers[l];
        numbers[l] = numbers[r];
        numbers[r] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 6, 3, 7, 8, 2, 4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
