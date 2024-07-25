package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.Arrays;

public class _543_二叉树的直径 {
    public static void main(String[] args) {
        // TreeNode root = TreeNodeUtils.buildTree(Arrays.asList(4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2));
        TreeNode root = TreeNodeUtils.buildTree(new int[]{1, 2, 3, 4, 5});
        _543_二叉树的直径 instance = new _543_二叉树的直径();
        TreeNodeUtils.prettyPrintTree(root);
        System.out.println(instance.solution1(root));
    }

    /**
     * 先求根节点的最长直径，然后递归求解左右子树的最长路径，在三个值中取最大值
     *
     * @param root
     * @return
     */
    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currentDepth = getDepth(root.left) + getDepth(root.right);
        int leftDepth = solution1(root.left);
        int rightDepth = solution1(root.right);
        return Math.max(currentDepth, Math.max(leftDepth, rightDepth));
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
