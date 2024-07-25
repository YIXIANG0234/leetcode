package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.Arrays;

public class _617_合并二叉树 {
    public static void main(String[] args) {
        TreeNode root1 = TreeNodeUtils.buildTree(Arrays.asList(1, 3, 2, 5));
        TreeNode root2 = TreeNodeUtils.buildTree(Arrays.asList(2, 1, 3, null, 4, null, 7));
        TreeNodeUtils.prettyPrintTree(root1);
        TreeNodeUtils.prettyPrintTree(root2);
        _617_合并二叉树 instance = new _617_合并二叉树();
        TreeNode root = instance.solution2(root1, root2);
        TreeNodeUtils.prettyPrintTree(root);
    }

    public TreeNode solution1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = solution1(root1.left, root2.left);
        root1.right = solution1(root1.right, root2.right);
        return root1;
    }

    public TreeNode solution2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = solution2(root1.left, root2.left);
        root1.right = solution2(root1.right, root2.right);
        return root1;
    }
}
