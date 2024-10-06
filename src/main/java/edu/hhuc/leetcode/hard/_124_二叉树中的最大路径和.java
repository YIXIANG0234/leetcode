package edu.hhuc.leetcode.hard;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: leetcode
 * @ClassName _124_二叉树中的最大路径和
 * @description:
 * @author: gaoya
 * @create: 2024-10-06 22:45
 * @Version 1.0
 */
public class _124_二叉树中的最大路径和 {
    public static void main(String[] args) {
        _124_二叉树中的最大路径和 instance = new _124_二叉树中的最大路径和();
        TreeNode root = TreeNodeUtils.buildTree(Arrays.asList(-10, 9, 20, null, null, 15, 7));
        TreeNodeUtils.prettyPrintTree(root);
        System.out.println(instance.solution1(root));
    }

    public int solution1(TreeNode root) {
        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        backtrace(root, result);
        return result.get();
    }

    private int backtrace(TreeNode root, AtomicInteger result) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(backtrace(root.left, result), 0);
        int right = Math.max(backtrace(root.right, result), 0);
        int max = Math.max(result.get(), left + right + root.val);
        result.set(max);
        return root.val + Math.max(left, right);
    }
}
