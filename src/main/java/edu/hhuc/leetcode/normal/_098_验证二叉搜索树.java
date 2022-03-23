package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _098_验证二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
    /**
     * 二叉搜索树的中序遍历结果单调递增
     * @param root
     * @return
     */
    public boolean solution1(TreeNode root) {
        List<Integer> result = inOrder(root);
        for (int i = 0; i <= result.size() - 1; i++) {
            if (result.get(i) > result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public boolean solution2(TreeNode root) {
        return validTreeRange(root, null, null);
    }

    /**
     * 中序遍历更好的写法
     * @param root
     * @return
     */
    public boolean solution3(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            if (pre >= top.val) {
                return false;
            }
            pre = top.val;
            root = top.right;
        }
        return true;
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

    public List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(inOrder(root.left));
        result.add(root.val);
        result.addAll(inOrder(root.right));
        return  result;
    }
}
