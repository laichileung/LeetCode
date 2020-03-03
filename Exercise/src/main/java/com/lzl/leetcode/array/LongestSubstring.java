package com.lzl.leetcode.array;

import java.util.HashSet;

/**
 * @auther: marco.li
 * @date: Created in 2019/10/15
 */
public class LongestSubstring {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        String s = "abcbacbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 解题思路，最长字串必定连续，因此可以从左到右遍历字符串，使用left、right分别记录两个下标。
     * 空字符串的情况单独处理，因此定义max最小值为1。
     * right 从 left + 1开始遍历，每个字符判断是否在子字符串中，如果在的话，left则跳到对应下标+1。
     * 每个字符的遍历都记录最大值max
     * <p>
     * 时间复杂度：O(n2)
     * 空间复杂度: O(1)
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0, max = 1;
        for (int right = 1; right < s.length(); right++) {
            // 查询子字符串是否包含该字符，这里可用HashSet，使查询能到O(1)
            for (int i = left; i < right; i++) {
                // 相等时左边向右移
                if (s.charAt(i) == s.charAt(right)) {
                    left = i + 1;
                    break;
                }
            }
            max = right - left + 1 > max ? right - left + 1 : max;
        }
        return max;
    }

    /**
     * 滑动窗口
     * 双指针 + hashset
     * 从左到右遍历字符串，每次判断hashset中是否存在相同字符O(1)
     * 不存在则加入hashset中，并刷新最长子串长度
     * 存在则将该元素移除，并将left指针向前移动
     *
     * 时间复杂度：O(n)
     * 空间复杂度: O(n)
     */
    public static int lengthOfLongestSubstring2(String s) {
        HashSet hashSet = new HashSet();
        int max = 0, left = 0, right = 0;
        for (; left < s.length() && right < s.length(); ) {
            if (!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                max = right - left + 1 > max ? right - left + 1 : max;
                right++;
            } else {
                hashSet.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }


}
