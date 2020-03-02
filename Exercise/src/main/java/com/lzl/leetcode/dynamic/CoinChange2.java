package com.lzl.leetcode.dynamic;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/2
 */
public class CoinChange2 {

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
     * 采用自上到下的方式
     * fa[amount] = fa[amount - coin] + 1;
     * 要想fa[amount]最小，则只需取min(fa[amount - coin[n]]), n(0, coins.length-1)
     *
     * 最坏情况coin中有1时，递归树深度为amount，每个子问题遍历coin.length
     * 时间复杂度O（amount*coin.length）
     * 空间复杂度O(amount+1) 多一位用于下标padding
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        return coinChange(coins, amount, new int[amount + 1]);
    }

    private int coinChange(int[] coins, int amount, int[] cache) {
        if (amount == 0) return 0;
        // 子问题解已经被缓存
        if (cache[amount] != 0) return cache[amount];

        Integer min = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 当前金额大于coin时，进入递归
            if (amount >= coin) {
                int sub = coinChange(coins, amount - coin, cache);
                if (sub >= 0 && sub < min) {
                    // 记录当前金额最优解
                    min = sub + 1;
                }
            }
        }
        // 如果fa[amount]有最优解，则缓存
        cache[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return cache[amount];
    }

    public static void main(String[] args) {
        CoinChange2 coinChange = new CoinChange2();
        int[] coins = new int[]{1,2,5};
        int count = coinChange.coinChange(coins, 11);
        System.out.println(count);
    }


}
