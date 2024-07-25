package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class _226_翻转二叉树 {
    public static void main(String[] args) {
        _226_翻转二叉树 instance = new _226_翻转二叉树();
        TreeNode root = TreeNodeUtils.randomTree(5);
        TreeNodeUtils.prettyPrintTree(root);
        root = instance.solution2(root);
        TreeNodeUtils.prettyPrintTree(root);
    }

    public TreeNode solution1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = solution1(root.right);
        root.right = solution1(left);
        return root;
    }

    public TreeNode solution2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
