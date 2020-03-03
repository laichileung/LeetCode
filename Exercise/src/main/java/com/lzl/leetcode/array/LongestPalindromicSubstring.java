package com.lzl.leetcode.array;

import java.util.HashMap;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/3
 */
public class LongestPalindromicSubstring {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 暴力法
     * <p>
     * 极端情况时间复杂度O(n3)
     * 空间复杂度O(n);
     */
    public String longestPalindrome(String s) {
        String res = "";
        char[] charArray = s.toCharArray();

        // 找出i开头的最大回文串
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i; j < charArray.length; j++) {
                // 判断当前字串是否为回文串
                if (isPalindrome(charArray, i, j) && (j + 1 - i) > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /**
     * 判断是否回文串
     */
    private boolean isPalindrome(char[] charArray, int begin, int end) {
        while (begin < end) {
            if (charArray[begin] != charArray[end])
                return false;
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("abab"));
    }
}
