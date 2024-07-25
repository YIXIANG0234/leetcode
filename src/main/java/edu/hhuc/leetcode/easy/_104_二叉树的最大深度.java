package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求树的高度
 */
public class _104_二叉树的最大深度 {
    public static void main(String[] args) {
        _104_二叉树的最大深度 instance = new _104_二叉树的最大深度();
        TreeNode root = TreeNodeUtils.randomTree(9);
        TreeNodeUtils.prettyPrintTree(root);
        System.out.println(instance.solution2(root));
    }

    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = solution1(root.left);
        int right = solution1(root.right);
        return Math.max(left, right) + 1;
    }

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
                TreeNode node = queue.remove();
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
