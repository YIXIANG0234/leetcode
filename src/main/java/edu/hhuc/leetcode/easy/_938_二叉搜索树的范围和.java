package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _938_二叉搜索树的范围和 {
    public int solution1(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.val >= low && root.val <= high) {
                result += root.val;
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return result;
    }
}
