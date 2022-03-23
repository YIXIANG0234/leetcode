package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

/**
 * 求树的高度
 */
public class _104_二叉树的最大深度 {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = solution(root.left);
        int right = solution(root.right);
        return Math.max(left, right) + 1;
    }
}
