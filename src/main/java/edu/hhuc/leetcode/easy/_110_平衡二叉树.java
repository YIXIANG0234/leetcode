package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

public class _110_平衡二叉树 {

    /**
     * 自顶向下的递归，有重复计算，时间复杂度为O(n^2)
     *
     * @param root
     * @return
     */
    public boolean solution1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHigh = getHigh(root.left);
        int rightHigh = getHigh(root.right);
        return Math.abs(leftHigh - rightHigh) <= 1 && solution1(root.left) && solution1(root.right);
    }

    public int getHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 至低向上的递归方法
     * @param root
     * @return
     */
    public boolean solution2(TreeNode root) {
        return high(root) != -1;
    }

    public int high(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left, right;
        if ((left = high(root.left)) == -1
                || (right = high(root.right)) == -1
                || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
