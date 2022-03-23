package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

public class _700_二叉搜索树中的搜索 {
    /**
     * 递归写法：二叉搜索树的搜索
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode solution1(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return solution1(root.left, val);
        }
        return solution1(root.right, val);
    }

    /**
     * 迭代写法
     * @param root
     * @param val
     * @return
     */
    public TreeNode solution2(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }


}
