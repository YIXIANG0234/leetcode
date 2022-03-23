package edu.hhuc.leetcode.easy;

import com.google.common.collect.Lists;
import edu.hhuc.leetcode.entity.TreeNode;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _112_路径总和 {

    public static void main(String[] args) {
        List<Integer> nodes = Lists.newArrayList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
        TreeNode root = TreeNode.buildTree(nodes);
        System.out.println(root);
        _112_路径总和 instance = new _112_路径总和();
        System.out.println(instance.solution1(root, 22));
    }

    /**
     * 广度优先搜索
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean solution1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 层序遍历的节点
        Queue<TreeNode> nodes = new LinkedList<>();
        // 层序遍历对应节点当前路径的和
        Queue<Integer> values = new LinkedList<>();
        nodes.offer(root);
        values.offer(root.val);
        while (!nodes.isEmpty() && !values.isEmpty()) {
            TreeNode node = nodes.poll();
            int value = values.poll();
            if (isLeaf(node) && value == targetSum) {
                return true;
            }
            if (node.left != null) {
                nodes.offer(node.left);
                values.offer(value + node.left.val);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                values.offer(value + node.right.val);
            }
        }
        return false;
    }

    /**
     * 深度优先算法，相当于递归的前序遍历
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean solution2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (isLeaf(root)) {
            return root.val == targetSum;
        }
        return solution2(root.left, targetSum - root.val) || solution2(root.right, targetSum - root.val);
    }

    /**
     * 非递归的前序遍历
     * @param root
     * @param targetSum
     * @return
     */
    public boolean solution3(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> values = new LinkedList<>();
        nodes.push(root);
        values.push(root.val);
        while (!nodes.isEmpty() && !values.isEmpty()) {
            TreeNode node = nodes.pop();
            int value = values.pop();
            if (isLeaf(node) && value == targetSum) {
                return true;
            }
            if (node.right != null) {
                nodes.push(node.right);
                values.push(value + node.right.val);
            }
            if (node.left != null) {
                nodes.push(node.left);
                values.push(value + node.left.val);
            }
        }
        return false;
    }

    public boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

}
