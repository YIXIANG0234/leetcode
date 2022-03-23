package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class _404_左叶子之和 {

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public int solution1(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                if (!isLeaf(root.left)) {
                    // 入队，查找左子树中的左叶子节点
                    queue.offer(root.left);
                } else {
                    // 找到左叶子节点
                    result += root.left.val;
                }
            }
            if (root.right != null) {
                if (!isLeaf(root.right)) {
                    // 如果右子树是叶子节点，不入队也不参与结果计算，非叶子节点的右子树，需要入队，查找右子树中的左叶子节点
                    queue.offer(root.right);
                }
            }
        }
        return result;
    }

    public int dfs(TreeNode root) {
        int result = 0;
        if (root.left != null) {
            result += isLeaf(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLeaf(root.right)) {
            result += dfs(root.right);
        }

        return result;
    }

    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

}
