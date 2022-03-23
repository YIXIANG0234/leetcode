package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.Arrays;

public class _543_二叉树的直径 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(Arrays.asList(4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2));
        _543_二叉树的直径 instance = new _543_二叉树的直径();
        System.out.println(instance.diameterOfBinaryTree(root));
    }

    /**
     * 先求根节点的最长直径，然后递归求解左右子树的最长路径，在三个值中取最大值
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currentDepth = getDepth(root.left) + getDepth(root.right);
        int leftDepth = diameterOfBinaryTree(root.left);
        int rightDepth = diameterOfBinaryTree(root.right);
        int result = Math.max(currentDepth, Math.max(leftDepth, rightDepth));
        System.out.println(String.format("当前节点是：%d, 当前直径为：%d, 左子树直径为：%d, 右子树直径为：%d, 结果为：%d", root.val, currentDepth, leftDepth, rightDepth, result));
        return result;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
