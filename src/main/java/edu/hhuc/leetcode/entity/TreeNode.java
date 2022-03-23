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

    // 传入节点列表，构建二叉树，方便测试使用
    public static TreeNode buildTree(List<Integer> nodes) {
        if (nodes == null || nodes.size() <= 0) {
            return null;
        }
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();

        int index = 0;
        while (index < nodes.size()) {
            Integer currentVal = nodes.get(index);
            if (queue.isEmpty()) {
                if (currentVal != null) {
                    //构建根节点
                    TreeNode node = new TreeNode(currentVal);
                    root = node;
                    queue.offer(node);
                }
                index++;
                continue;
            }
            TreeNode current = queue.poll();
            if (currentVal != null) {
                TreeNode left = new TreeNode(currentVal);
                current.left = left;
                queue.offer(left);
            }
            // 处理下一个节点
            index++;
            if (index < nodes.size() && nodes.get(index) != null) {
                TreeNode right = new TreeNode(nodes.get(index));
                current.right = right;
                queue.offer(right);
            }
            // 处理下一个节点
            index++;
        }
        return root;
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
     * 打印二叉树
     * @param root
     */
    // TODO: 2022/3/8 未完成
    public static void printTree(TreeNode root) {
        final int maxLevel = getDepth(root);
        // 一棵二叉树的最大节点数为(2^n-1)，即满二叉树，为了方便计算，存储从下标1开始，所以数组的长度设置为2^n
        TreeNode[] nodes = new TreeNode[(int) Math.pow(2, maxLevel)];

        // 将二叉树的节点放入nodes数组
        traverse(root, 0, nodes);

        final int leafNodeWidth = 4;
        for (int level = 1; level <= maxLevel; level++) {
            // 第level层的第一个节点的下标为2^(n-1)
            int start = (int) Math.pow(2, level - 1);
            // 第level层的最后一个节点的下标为2*start - 1
            int end = 2 * start - 1;
            for (int index = start; index <= end; index++) {

            }
        }
    }

    /**
     * 计算树的高度
     *
     * @param root
     * @return
     */
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
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

