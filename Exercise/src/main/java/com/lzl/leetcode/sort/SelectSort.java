package com.lzl.leetcode.sort;

import java.util.Arrays;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/26
 */
public class SelectSort {

    /**
     * 选择排序
     * <p>
     * 每一轮选取未排序集合中的最小值
     *
     * 时间复杂度O(n2)
     */
    private void selectSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int minIndex = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex])
                    minIndex = j;
            }
            // 交换
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 6, 3, 7, 8, 2, 4};
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}
