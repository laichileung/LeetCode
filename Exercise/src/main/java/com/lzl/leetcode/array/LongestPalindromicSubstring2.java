package com.lzl.leetcode.array;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/3
 */
public class LongestPalindromicSubstring2 {

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
     * 优秀解题
     * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
     */

    /**
     * 动态规划
     * 1、定义state 定义dp[i][j]表示s[i][j]是否回文串
     * 2、寻找状态转移方程 dp[i][j] = dp[i+1][j-1] && (s[i]==s[j]);
     * 3、初始化边界值
     * <p>
     * 时间复杂度O(n2)
     * 空间复杂度O(n2);
     */
    public String longestPalindrome(String s) {
        String res = "";
        // 1、定义dp[i][j]表示s[i][j]是否回文串
        boolean[][] dp = new boolean[s.length()][s.length()];

        // 2、状态转移方程
        // dp[i][j] = dp[i+1][j-1] && (s[i]==s[j]);

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        // 00 01 11 02 12 22 03 13 23 33
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 三位字符串，头尾相等，则回文
                    if (j + 1 - i <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j]) {
                    res = j + 1 - i > res.length() ? s.substring(i, j + 1) : res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring2 solution = new LongestPalindromicSubstring2();
        System.out.println(solution.longestPalindrome("1111"));
    }
}
