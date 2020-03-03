package com.lzl.leetcode.array;

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

    /**
     * 时间复杂度：O(max(m,n)) m,n分别是l1、l2的长度。
     * 空间复杂度：O(max(m,n)) + 2, 这里为了简化代码而添加了哑节点（增加了1的空间，另外1是由于进位而造成），否则要添加条件判断来初始化第一个节点。
     */
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
            carry = index.val / 10;
            index.val = index.val % 10;
        }
        return rt.next;
    }

    /**
     * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 00，比如 987 + 23 = 987 + 023 = 1010
     * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
     * 如果两个链表全部遍历完毕后，进位值为1，则在新链表最前方添加节点1
     * 对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (null != l1 || null != l2) {

            int x = null == l1 ? 0 : l1.val;
            int y = null == l2 ? 0 : l2.val;
            int sum = x + y + carry;

            cur.next = new ListNode(sum % 10);
            carry = sum / 10;

            cur = cur.next;
            l1 = null == l1 ? l1 : l1.next;
            l2 = null == l2 ? l2 : l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
