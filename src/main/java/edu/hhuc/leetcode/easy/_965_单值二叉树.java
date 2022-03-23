package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

public class _965_单值二叉树 {
    private Integer value;
    public boolean solution1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (value == null) {
            value = root.val;
        } else if (value != root.val) {
            return false;
        }
        return solution1(root.left) && solution1(root.right);
    }
}
