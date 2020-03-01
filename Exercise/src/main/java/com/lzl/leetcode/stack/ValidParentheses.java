package com.lzl.leetcode.stack;

import java.util.Stack;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/1
 */
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean isValid(String s) {
        // 排除奇数
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 第一个元素先入栈
            if (stack.empty()) {
                stack.push(c);
            } else if (isMatch(stack.peek(), c)) {
                stack.pop();
            } else {
                // 这里不能直接return false ，"{()}"
                stack.push(c);
            }
        }
        return stack.empty();
    }

    private boolean isMatch(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();

        System.out.println(validParentheses.isValid("{}}{"));
    }
}
