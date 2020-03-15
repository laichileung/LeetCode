package com.lzl.leetcode.tree;

/**
 * @auther: marco.li
 * @date: Created in 2020/3/10
 */
public class DiameterOfBinaryTree {

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
     *
     * 示例 :
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    /**
     * 首先我们知道一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
     * <p>
     * 而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到。
     * <p>
     * 因此从根节点向下遍历，分别求出各节点的左儿子L与右儿子R，使用res记录L+R为某一路径长度，求出最大长度即可。
     */

    int res = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return res - 1;
    }


    public int getDiameter(TreeNode node) {
        if (node == null) return 0;
        int l = getDiameter(node.left);

        int r = getDiameter(node.right);

        this.res = Math.max(res, l + r + 1);

        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(treeNode));
    }
}

