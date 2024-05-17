package edu.hhuc.leetcode.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static void printTreePath(TreeNode root) {
        getAllPath(root).forEach(System.out::println);
    }

    public static List<String> getAllPath(TreeNode root) {
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
                paths.offer(path + "->" + node.right.val);            }
        }
        return result;
    }

    /**
     * 中序遍历，将树的节点放入数组的对应位置
     * 如果把一棵树的节点放在一个数组中，设根节点的下标为index，则其左节点的下标为2*index+1，右节点为2*index+2
     *
     * @param root
     * @param index
     * @param nodes
     */
    public static void traverse(TreeNode root, int index, TreeNode[] nodes) {
        if (root == null) {
            return;
        }
        nodes[index] = root;
        traverse(root.left, index * 2, nodes);
        traverse(root.right, index * 2 + 1, nodes);
    }

    public static List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(preOrder(root.left));
        result.addAll(preOrder(root.right));
        return result;
    }

    public static List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(inOrder(root.left));
        result.add(root.val);
        result.addAll(inOrder(root.right));
        return result;
    }

    public static List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(postOrder(root.left));
        result.addAll(postOrder(root.right));
        result.add(root.val);
        return result;
    }

//    public static List<String> getTreePath(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        StringBuilder sb = new StringBuilder(root.val);
//        if (root.left != null || root.right != null) {
//            sb.append("->");
//            if ()
//        }
//    }
}