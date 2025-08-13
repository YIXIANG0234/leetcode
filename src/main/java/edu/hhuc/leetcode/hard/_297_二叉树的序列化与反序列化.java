package edu.hhuc.leetcode.hard;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/10/10 19:12:55
 */
public class _297_二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        _297_二叉树的序列化与反序列化 instance = new _297_二叉树的序列化与反序列化();
        // TreeNode root = TreeNodeUtils.randomTree(7);
        TreeNode root = TreeNodeUtils.buildTree(Arrays.asList(1, 2, 3, null, null, 4, 5));
        TreeNodeUtils.prettyPrintTree(root);
        String serialize = instance.serialize(root);
        System.out.println(serialize);
        root = instance.deserialize(serialize);
        TreeNodeUtils.prettyPrintTree(root);
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (sb.length() != 0) {
                    sb.append(",");
                }
                if (node == null) {
                    sb.append("null");
                    continue;
                }
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
        queue.add(root);
        index++;
        while (index < nodes.length) {
            TreeNode node = queue.poll();
            if (!"null".equals(nodes[index])) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.left);
            }
            index++;
            if (index < nodes.length && !"null".equals(nodes[index])) {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }
}
