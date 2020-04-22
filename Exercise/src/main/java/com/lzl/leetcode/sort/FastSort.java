package com.lzl.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/27
 */
public class FastSort {

    /**
     * 快速排序O(nlogn) ~ O(n2)
     */
    private void sort(int[] numbers, int left, int right) {
        if (left >= right) return;
        int index = partition2(numbers, left, right);
        sort(numbers, left, index - 1);
        sort(numbers, index + 1, right);
    }

    /**
     * n次操作
     */
    private int partition(int[] numbers, int left, int right) {
        // 选取基准数
        int temp = numbers[left];

        int l = left, r = right;

        while (l < r) {
            while (l < r && numbers[r] >= temp) r--;

            while (l < r && numbers[l] <= temp) l++;

            if (l < r) {
                swap(numbers, l, r);
                System.out.println(Arrays.toString(numbers));
            }
        }
        swap(numbers, l, left);
        System.out.println(Arrays.toString(numbers));
        return l;
    }

    private int partition2(int[] numbers, int left, int right) {
        // 选取基准数
        int temp = numbers[right];
        int l = left, r = right;

        while (l < r) {
            while (l < r && numbers[l] <= temp) l++;

            while (l < r && numbers[r] >= temp) r--;

            if (l < r) {
                swap(numbers, l, r);
                System.out.println(Arrays.toString(numbers));
            }
        }
        swap(numbers, r, right);
        System.out.println(Arrays.toString(numbers));
        return r;
    }


    private void swap(int[] numbers, int l, int r) {
        int temp = numbers[l];
        numbers[l] = numbers[r];
        numbers[r] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 6, 3, 7, 8, 2, 4};
        System.out.println(Arrays.toString(numbers));
        FastSort fastSort = new FastSort();
        fastSort.sort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }
}
