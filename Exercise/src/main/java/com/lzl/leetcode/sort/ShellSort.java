package com.lzl.leetcode.sort;

import java.util.Arrays;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/26
 */
public class ShellSort {


    /**
     * 希尔排序，选取n/2， n/2 -1， n/2 -2 。。。。 1的步长，进行分组插入排序
     * <p>
     * 直到步长为1
     * 时间复杂度O(n2)
     */
    private void shellSort(int[] numbers) {
        for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < numbers.length; i++) {
                int temp = numbers[i];
                int j;
                for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap) {
                    numbers[j] = numbers[j - gap];
                }
                numbers[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 6, 3, 7, 8, 2, 4};
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
