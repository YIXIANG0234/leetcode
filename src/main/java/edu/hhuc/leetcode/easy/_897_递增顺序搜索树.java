package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.Arrays;

public class _897_递增顺序搜索树 {
    private TreeNode newTree = null;
    private TreeNode next = null;

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(Arrays.asList(5, 1, 7));
        _897_递增顺序搜索树 instance = new _897_递增顺序搜索树();
        instance.increasingBST(root);

    }

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return newTree;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (next == null) {
            next = new TreeNode(root.val);
            newTree = next;
        } else {
            next.right = new TreeNode(root.val);
            next = next.right;
        }
        dfs(root.right);
        return;
    }
}
