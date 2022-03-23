package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _094_二叉树的中序遍历 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        _094_二叉树的中序遍历 instance = new _094_二叉树的中序遍历();
        List<Integer> result = instance.solution1(node1);
        System.out.println(result);
    }


    /**
     * 非递归的中序遍历方式
     * 中序遍历：左子树->根节点->右子树
     * @param root
     * @return
     */
    public List<Integer> solution1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    /**
     * 递归的中序遍历
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(solution2(root.left));
        result.add(root.val);
        result.addAll(solution2(root.right));
        return result;
    }
}
