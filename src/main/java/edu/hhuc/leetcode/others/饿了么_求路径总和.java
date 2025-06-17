package edu.hhuc.leetcode.others;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 给定一颗二叉树，求所有路径的和
 * 每条路径的值：
 * 路径1:9 -> 5 -> 3 = 953
 * 路径2:2 -> 4 -> 8 = 248
 * 路径总和：953+248=1201
 *
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/10/24 10:12:49
 */
public class 饿了么_求路径总和 {
    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.randomTree(5, 10);
        // TreeNode root = TreeNodeUtils.buildTree(new int[]{8, 6, 4, 2, 5, 7, 3});
        TreeNodeUtils.prettyPrintTree(root);
        饿了么_求路径总和 instance = new 饿了么_求路径总和();
        System.out.println(instance.solution1(root));
        System.out.println(instance.solution2(root));

    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> list = new LinkedList<>();
        int result = 0;
        queue.offer(root);
        list.offer(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int value = list.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    list.offer(value * 10 + node.left.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    list.offer(value * 10 + node.right.val);
                }
                if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
                    result = result + value;
                }
            }
        }
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return backtrace(root, 0);
    }

    private int backtrace(TreeNode root, int value) {
        value = value * 10 + root.val;
        if (root.left == null && root.right == null) {
            return value;
        }
        int leftNum = root.left == null ? 0 : backtrace(root.left, value);
        int rightNum = root.right == null ? 0 : backtrace(root.right, value);
        return leftNum + rightNum;
    }
}
