package edu.hhuc.leetcode.easy;

import com.google.common.collect.Lists;
import edu.hhuc.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _257_二叉树的所有路径 {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, null, 5);
        TreeNode root = TreeNode.buildTree(list);
        _257_二叉树的所有路径 instance = new _257_二叉树的所有路径();
        List<String> paths = instance.solution1(root);
        paths.forEach(System.out::println);
    }

    public List<String> solution1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<String> paths = new LinkedList<>();
        List<String> result = new ArrayList<>();
        nodes.offer(root);
        paths.offer(root.val+"");

        while (!nodes.isEmpty() && !paths.isEmpty()) {
            TreeNode node = nodes.poll();
            String path = paths.poll();
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.left != null) {
                nodes.offer(node.left);
                paths.offer(path + "->" + node.left.val);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                paths.offer(path + "->" + node.right.val);
            }
        }
        return result;
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public List<String> solution2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return getAllPath(root, root.val + "");
    }

    public List<String> getAllPath(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            return List.of(path);
        }
        List<String> result = new ArrayList<>();
        if (root.left != null) {
            result.addAll(getAllPath(root.left, path + "->" + root.left.val));
        }
        if (root.right != null) {
            result.addAll(getAllPath(root.right, path + "->" + root.right.val));
        }
        return result;
    }

}
