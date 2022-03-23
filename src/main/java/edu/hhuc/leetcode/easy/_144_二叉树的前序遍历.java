package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ._144
 */
public class _144_二叉树的前序遍历 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        _144_二叉树的前序遍历 instance = new _144_二叉树的前序遍历();
        List<Integer> result = instance.solution2(node1);
        System.out.println(result);
    }

    /**
     * 非递归的前序遍历方式
     * 前序遍历：根节点->左子树->右子树
     * 需要一个后进先出的数据结构栈，保遍存历路径，先访问根节点，然后右子树入栈，最后左子树入栈
     * 左子树后入栈的原因是要先出栈，先处理左子树
     * @param root
     * @return
     */
    public List<Integer> solution1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return result;
    }

    /**
     * 递归遍历的方式
     * @param root
     * @return
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(solution2(root.left));
        result.addAll(solution2(root.right));
        return result;
    }
}
