package com.lzl.leetcode.dynamic;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/2
 */
public class MinimumCostForTickets {

    /**
     * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
     *
     * 火车票有三种不同的销售方式：
     *
     * 一张为期一天的通行证售价为 costs[0] 美元；
     * 一张为期七天的通行证售价为 costs[1] 美元；
     * 一张为期三十天的通行证售价为 costs[2] 美元。
     * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
     *
     * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
     *
     *  1 <= days.length <= 365
     * 1 <= days[i] <= 365
     * days 按顺序严格递增
     * costs.length == 3
     * 1 <= costs[i] <= 1000
     *
     * 示例 1：
     *
     * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
     * 输出：11
     * 解释：
     * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
     * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
     * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
     * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
     * 你总共花了 $11，并完成了你计划的每一天旅行。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */


    /**
     * 采用自顶向下的解题思路，dp作为备忘录，n表示第几天。
     * 递归深度 days[days.length -1], 最大为365
     * 子问题个数为O(n), n<=365
     * 每个子问题为O(1)
     *
     * 可知状态转移方程如下
     * <p>
     * F(n) = 0， n=0;
     * F(n) = F(n-1), n不属于days
     * F(n) = min{F(n-1) + cost[0], F(n-7) + cost[1], F(n-30) + cost[2] } n>=30
     * F(n) = min{F(n-1) + cost[0], F(n-7) + cost[1],  cost[2] } n>=15
     * F(n) = min{F(n-1) + cost[0], cost[1], cost[2] } n>=1
     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        for (int day : days) {
            dp[day] = -1;
        }
        return mincostTickets(days[days.length - 1], costs, dp);
    }

    private int mincostTickets(int day, int[] costs, int[] dp) {
        if (day == 0) return 0;
        if (dp[day] > 0) return dp[day];

        // 非旅行日
        if (dp[day] != -1) {
            dp[day] = mincostTickets(day - 1, costs, dp);
        } else {
            int a, b, c;
            a = mincostTickets(day - 1, costs, dp) + costs[0];
            // 小于7天时，需要比较直接购买7天票的价格
            if (day >= 7) {
                b = mincostTickets(day - 7, costs, dp) + costs[1];
            } else {
                b = costs[1];
            }
            // 小于30天时，需要比较直接购买30天票的价格
            if (day >= 30) {
                c = mincostTickets(day - 30, costs, dp) + costs[2];
            } else {
                c = costs[2];
            }
            dp[day] = Math.min(a, Math.min(b, c));
        }
        return dp[day];
    }

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{7, 2, 15};
        MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();
        System.out.println(minimumCostForTickets.mincostTickets(days, costs));
    }
}
