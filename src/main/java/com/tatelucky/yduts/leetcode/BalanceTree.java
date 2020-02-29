package com.tatelucky.yduts.leetcode;

/**
 * 平衡树
 *
 * @author tangsheng
 * @since 2020-02-29
 */
public class BalanceTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static boolean flag = true;

    public static boolean isBalanced(TreeNode root) {
        if (null == root) {
            return flag;
        }

        maxHeght(root);

        return flag;
    }

    public static int maxHeght(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxHeght(root.left);
        int right = maxHeght(root.right);

        if (Math.abs(left - right) > 1) {
            flag = false;
        }

        return 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(3);

        treeNode.left.left.left = new TreeNode(4);
        treeNode.left.left.right = new TreeNode(4);

        System.out.println(isBalanced(treeNode));
    }
}
