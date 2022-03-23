package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.*;

public class _145_二叉树的后序遍历 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        _145_二叉树的后序遍历 instance = new _145_二叉树的后序遍历();
        List<Integer> result = instance.solution1(node1);
        System.out.println(result);
    }


    /**
     * 非递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (node.right == null || node.right == prev) {
                result.add(node.val);
                prev = node;
            } else {
                stack.push(node);
                root = node.right;
            }
        }
        return result;
    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(solution2(root.left));
        result.addAll(solution2(root.right));
        result.add(root.val);
        return result;
    }
}
