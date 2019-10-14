package com.lzl.leetcode;

/**
 * @auther: marco.li
 * @date: Created in 2019/9/26
 */
public class AddTwoNumbers {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode rt = addTwoNumbers(l1, l2);
        while (rt != null) {
            System.out.println(rt.val);
            rt = rt.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rt = new ListNode(0);
        ListNode l3 = rt;
        int carry = 0;
        while (null != l1 || null != l2 || carry != 0) {

            ListNode index = new ListNode(0);

            // 相加 并移动游标
            if (null == l1 && null == l2) {
                index.val = carry;
            } else if (null == l1) {
                index.val = l2.val + carry;
                l2 = l2.next;
            } else if (null == l2) {
                index.val = l1.val + carry;
                l1 = l1.next;
            } else {
                index.val = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            l3.next = index;
            l3 = index;

            // 处理进位
            if (index.val >= 10) {
                index.val = index.val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        return rt.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
