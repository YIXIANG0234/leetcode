package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _653_两数之和IV输入BST {
    Set<Integer> table = new HashSet<>();
    public static void main(String[] args) {
        _653_两数之和IV输入BST instance = new _653_两数之和IV输入BST();
        TreeNode root = TreeNode.buildTree(Arrays.asList(2, 1, 3));
        System.out.println(instance.solution2(root, 4));
    }

    /**
     * 分别以每个节点作为其中一个节点，然后在二叉搜索树中查找另外一个节点
     *
     * @param root
     * @param k
     * @return
     */
    public boolean solution1(TreeNode root, int k) {
        return dfs(root, k, root);
    }

    /**
     * 建立一个hash表，遍历树的时候将节点值放在hash表中
     * @param root
     * @param k
     * @return
     */
    public boolean solution2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (table.contains(k - root.val)) {
            return true;
        }
        table.add(root.val);
        return solution2(root.left, k) || solution2(root.right, k);
    }

    public boolean dfs(TreeNode root, int k, TreeNode current) {
        if (current == null) {
            return false;
        }
        int diff = k - current.val;
        if (findNum(root, diff, current)) {
            return true;
        }
        return dfs(root, k, current.left) || dfs(root, k, current.right);
    }

    public boolean findNum(TreeNode root, int num, TreeNode current) {
        if (root == null) {
            return false;
        }
        if (num == root.val && root != current) {
            return true;
        }
        if (num < root.val) {
            return findNum(root.left, num, current);
        }
        return findNum(root.right, num, current);
    }

}
