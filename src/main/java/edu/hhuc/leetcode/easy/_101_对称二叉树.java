package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class _101_对称二叉树 {
    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildTree(new int[]{1, 2, 2, 3, 4, 4, 3});
        TreeNodeUtils.prettyPrintTree(root);
        _101_对称二叉树 instance = new _101_对称二叉树();
        System.out.println(instance.solution1(root));
    }

    /**
     * 深度优先遍历：递归解法
     *
     * @param root
     * @return
     */
    public boolean solution1(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    /**
     * 广度优先遍历，将二叉树入队两次，分别比较左右子树是否对称
     *
     * @param root
     * @return
     */
    public boolean solution2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
