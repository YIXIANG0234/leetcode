package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _111_二叉树的最小深度 {
    /**
     * 分别计算左右子树的最小高度，记得过滤掉非叶子节点的情况
     * @param root
     * @return
     */
    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return solution1(root.right) + 1;
        }
        if (root.right == null) {
            return solution1(root.left) + 1;
        }
        return Math.min(solution1(root.left), solution1(root.right)) + 1;
    }

    /**
     * 广度优先搜素算法，第一个被遍历到的叶子节点的高度即为该树的最小高度
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return level;
    }
}
