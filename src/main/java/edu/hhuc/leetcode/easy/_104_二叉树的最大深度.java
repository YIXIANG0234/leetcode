package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求树的高度
 */
public class _104_二叉树的最大深度 {

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(solution1(root.left), solution1(root.right)) + 1;
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            height++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return height;
    }
}
