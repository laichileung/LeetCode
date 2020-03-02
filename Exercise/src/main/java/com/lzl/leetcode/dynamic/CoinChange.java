package com.lzl.leetcode.dynamic;

import java.util.Arrays;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/2
 */
public class CoinChange {

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     * 示例 2:
     * <p>
     * 输入: coins = [2], amount = 3
     * 输出: -1
     * 说明:
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 采用自下到上的方式，先将0 ~ amount-1的最优解解出来，并存放到fa中
     * <p>
     * fa[amount] = fa[amount-coin] + 1;
     * <p>
     * 时间复杂度为O(amount*coins.length)
     * 空间复杂度为O(amount+1)
     */
    public int coinChange(int[] coins, int amount) {
        // 记录子问题最优解
        int[] fa = new int[amount + 1];
        // 金额为0时，结果为0
        // 其他值设为无穷大, 初始化很重要
        Arrays.fill(fa, Integer.MAX_VALUE);
        fa[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 当前硬币小于等于金额时, 进入决策
                if (coins[j] <= i) {
                    // 选择当前硬币
                    int current = fa[i - coins[j]] + 1;
                    // 当fa[i - coins[j]]无解时，current < 0，
                    if (current > 0) {
                        fa[i] = Math.min(fa[i], current);
                    }
                }
            }
        }

        // 1、没有进入决策 当coins都比amount大或 coins为空时出现
        // 2、无解 即current < 0
        if (fa[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return fa[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{5};
        int count = coinChange.coinChange(coins, 10);
        System.out.println(count);
    }


}
