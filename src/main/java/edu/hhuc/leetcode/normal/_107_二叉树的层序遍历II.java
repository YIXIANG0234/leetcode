package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.*;

public class _107_二叉树的层序遍历II {
    public List<List<Integer>> solution(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 关键：将后面遍历的层，放在结果的最前面
            result.add(0, level);
        }

        return result;
    }
}
