package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _094_二叉树的中序遍历 {

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildTree(new int[]{25, 5, 2, 95, 90, 75, 61, 48});
        _094_二叉树的中序遍历 instance = new _094_二叉树的中序遍历();
        TreeNodeUtils.prettyPrintTree(root);
        List<Integer> result = instance.solution1(root);
        System.out.println(result);
    }


    /**
     * 非递归的中序遍历方式
     * 中序遍历：左子树->根节点->右子树
     *
     * @param root
     * @return
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
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
     *
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
