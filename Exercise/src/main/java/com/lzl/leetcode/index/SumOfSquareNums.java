package com.lzl.leetcode.index;

import java.util.HashMap;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/11
 */
public class SumOfSquareNums {

    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     * <p>
     * 示例1:
     * <p>
     * 输入: 5
     * 输出: True
     * 解释: 1 * 1 + 2 * 2 = 5
     *  
     * <p>
     * 示例2:
     * <p>
     * 输入: 3
     * 输出: False
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean judgeSquareSum(int c) {
        int b = (int) Math.sqrt(c) + 1;
        for (int a = 0; a <= b; ) {
            if (Math.pow(a, 2) + Math.pow(b, 2) == c) {
                return true;
            } else if (Math.pow(a, 2) + Math.pow(b, 2) > c) {
                b--;
            } else if (Math.pow(a, 2) + Math.pow(b, 2) < c) {
                a++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumOfSquareNums sumOfSquareNums = new SumOfSquareNums();
        System.out.println(sumOfSquareNums.judgeSquareSum(4));
    }

}
