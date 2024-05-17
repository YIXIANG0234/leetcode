package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _671_二叉树中第二小的节点 {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) {
        _671_二叉树中第二小的节点 instance = new _671_二叉树中第二小的节点();
        TreeNode root = TreeNodeUtils.buildTree(Arrays.asList(2, 2, 5, null, null, 5, 7));
        instance.solution2(root);
    }

    /**
     * 使用优先队列
     *
     * @param root
     * @return
     */
    public int solution1(TreeNode root) {
        dfs(root);
        if (priorityQueue.size() < 2) {
            return -1;
        }
        priorityQueue.poll();
        return priorityQueue.poll();
    }

    /**
     * 递归找出较小的子树中严格大于根节点值的节点
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        int leftVal = (root.left.val == root.val ? solution2(root.left) : root.left.val);
        int rightVal = (root.right.val == root.val ? solution2(root.right) : root.right.val);
        if (leftVal == -1) {
            return rightVal;
        }
        if (rightVal == -1) {
            return leftVal;
        }
        return Math.min(leftVal, rightVal);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (!priorityQueue.contains(root.val)) {
            priorityQueue.offer(root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }
}
