package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.Arrays;

public class _617_合并二叉树 {
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.buildTree(Arrays.asList(1,3,2,5));
        TreeNode root2 = TreeNode.buildTree(Arrays.asList(2,1,3,null,4,null,7));
        _617_合并二叉树 instance = new _617_合并二叉树();
        TreeNode root = instance.solution1(root1, root2);
        TreeNode.printTreePath(root);
    }
    public TreeNode solution1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = solution1(root1.left, root2.left);
        root.right = solution1(root1.right, root2.right);
        return root;
    }
}
