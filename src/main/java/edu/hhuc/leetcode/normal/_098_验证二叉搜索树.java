package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _098_验证二叉搜索树 {
    public static void main(String[] args) {
        _098_验证二叉搜索树 instance = new _098_验证二叉搜索树();
        TreeNode root = TreeNodeUtils.buildTree(Arrays.asList(5, 4, 6, null, null, 3, 7));
        TreeNodeUtils.prettyPrintTree(root);
        System.out.println(instance.solution1(root));
    }

    /**
     * 二叉搜索树的中序遍历结果是单调递增的
     * 先求中序遍历的结果，然后判断是否递增即可
     *
     * @param root
     * @return
     */
    public boolean solution1(TreeNode root) {
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
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 对solution1空间复杂度的优化，无需储存整个中序遍历的结果
     * 只用记录前一个节点的值即可
     *
     * @param root
     * @return
     */
    public boolean solution2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean solution3(TreeNode root) {
        return validTreeRange(root, null, null);
    }

    public boolean validTreeRange(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return validTreeRange(root.left, min, root.val) && validTreeRange(root.right, root.val, max);
    }
}
