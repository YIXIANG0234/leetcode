package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _572_另一棵树的子树 {
    public static void main(String[] args) {
        _572_另一棵树的子树 instance = new _572_另一棵树的子树();
        TreeNode root = TreeNode.buildTree(Arrays.asList(3, 4, 5, 1, null, 2));
        TreeNode subRoot = TreeNode.buildTree(Arrays.asList(3, 1, 2));
        System.out.println(instance.isSubtree(root, subRoot));
    }

    /**
     * 该测试表明，中序遍历的结果可用于判断一棵二叉树是否为另一棵二叉树的子树，前序遍历和后续遍历不行
     */
    public void test() {
        TreeNode tree1 = TreeNode.buildTree(Arrays.asList(3, 4, 5, 1, null, 2, null));
        TreeNode tree2 = TreeNode.buildTree(Arrays.asList(3, 4, 5, null, 1, null, 2));
        TreeNode tree3 = TreeNode.buildTree(Arrays.asList(3, 4, 5, 1, null, null, 2));
        TreeNode tree4 = TreeNode.buildTree(Arrays.asList(3, 4, 5, null, 1, 2, null));
        System.out.println("前序遍历的结果为：");
        System.out.println("tree1: " + TreeNode.preOrder(tree1));
        System.out.println("tree2: " + TreeNode.preOrder(tree2));
        System.out.println("tree3: " + TreeNode.preOrder(tree3));
        System.out.println("tree4: " + TreeNode.preOrder(tree4));
        System.out.println("中序遍历的结果为：");
        System.out.println("tree1: " + TreeNode.inOrder(tree1));
        System.out.println("tree2: " + TreeNode.inOrder(tree2));
        System.out.println("tree3: " + TreeNode.inOrder(tree3));
        System.out.println("tree4: " + TreeNode.inOrder(tree4));
        System.out.println("后续遍历的结果为：");
        System.out.println("tree1: " + TreeNode.postOrder(tree1));
        System.out.println("tree2: " + TreeNode.postOrder(tree2));
        System.out.println("tree3: " + TreeNode.postOrder(tree3));
        System.out.println("tree4: " + TreeNode.postOrder(tree4));
    }

    /**
     * 解法一，深度优先遍历
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean solution1(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (subRoot == null) {
            return true;
        }
        return solution1(root.left, subRoot) || solution1(root.right, subRoot) || isSubtree(root, subRoot);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null ^ subRoot != null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
    }
}
