package edu.hhuc.leetcode.entity;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/16 17:04:20
 */
public class TreeNodeUtils {
    public static void main(String[] args) {
        // TreeNode root = buildTree(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        TreeNode root = buildTree(Lists.newArrayList(5, 4, 3, 3, 2, 2, 1, 2, 1));
        // TreeNode root = randomTree(10);
        prettyPrintTree(root);
    }

    /**
     * 构建一颗随机节点二叉树
     *
     * @param validNodeCount 节点个数
     * @return 二叉树根节点
     */
    public static TreeNode randomTree(int validNodeCount) {
        return randomTree(validNodeCount, 100);
    }

    public static TreeNode randomTree(int validNodeCount, int bound) {
        Random random = new Random();
        int count = 0;
        List<Integer> data = new ArrayList<>();
        int nullNum = random.nextInt(bound);
        while (nullNum == 0) {
            nullNum = random.nextInt(bound);
        }
        while (count <= validNodeCount) {
            int num = random.nextInt(bound);
            if (num % nullNum == 0) {
                data.add(null);
                continue;
            }
            data.add(num);
            count++;
        }
        System.out.println("随机二叉树序列：" + data);
        return buildTree(data);
    }

    public static TreeNode buildTree(int[] data) {
        return buildTree(Arrays.stream(data).boxed().collect(Collectors.toList()));
    }

    /**
     * 使用层序遍历的方式构建二叉树，其中null值表示空节点
     *
     * @param data 二叉树节点序列
     * @return 根节点
     */
    public static TreeNode buildTree(List<Integer> data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        int index = 0;
        // 选取第一个非null的节点作为根节点
        while (data.get(index) == null) {
            index++;
        }
        TreeNode root = new TreeNode(data.get(index));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        index++;
        while (index < data.size() && !queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (index < data.size()) {
                // 为null的话跳过左子树
                if (data.get(index) != null) {
                    TreeNode left = new TreeNode(data.get(index));
                    node.left = left;
                    queue.offer(left);
                }
                index++;
            }
            if (index < data.size()) {
                // 为null的话跳过右子树
                if (data.get(index) != null) {
                    TreeNode right = new TreeNode(data.get(index));
                    node.right = right;
                    queue.offer(right);
                }
                index++;
            }
        }
        return root;
    }

    /**
     * 计算树的高度：根节点到叶子节点的最长路径
     *
     * @param root 根节点
     * @return 树的高度
     */
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /**
     * 以层级结构打印二叉树，计算逻辑分析如下：
     * 1.使用先序遍历，首先遍历整颗二叉树，并将二叉树节点对应的坐标记录在一个二维数组中
     * 2.假设一棵二叉树的高度是n，则用来记录二叉树节点坐标的二维数组行和列的计算公式如下
     * 行数：2^n-1
     * 列数：2^(n+1)-3
     * 3.假设当前节点位于第k层，坐标为（i，j），则其子节点在横坐标上会下降，下降的计算层数公式如下：
     * T = 2^(n-k)
     * 所以可以得出其左右子节点的坐标
     * 左节点坐标：（i+T，j-T)
     * 右节点坐标：（i+T，j+T）
     *
     * @param root 二叉树根节点
     */
    public static void prettyPrintTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int height = getHeight(root);
        int n = (int) (Math.pow(2, height) - 1);
        int m = (int) Math.pow(2, height + 1) - 3;
        String[][] canvas = new String[n][m];
        prepareCanvas(root, canvas, 0, m / 2, 1, height);
        painting(canvas);
    }

    private static void prepareCanvas(TreeNode root, String[][] canvas, int i, int j, int level, int height) {
        if (root != null) {
            canvas[i][j] = String.valueOf(root.val);
            int descendingFactor = (int) Math.pow(2, height - level);
            int ti = i + 1;
            int tj;
            if (root.left != null) {
                for (tj = j - 1; ti < i + descendingFactor; ti++) {
                    canvas[ti][tj] = "<";
                    tj--;
                }
            }
            if (root.right != null) {
                ti = i + 1;
                for (tj = j + 1; ti < i + descendingFactor; ti++) {
                    canvas[ti][tj] = ">";
                    tj++;
                }
            }
            prepareCanvas(root.left, canvas, ti, j - descendingFactor, level + 1, height);
            prepareCanvas(root.right, canvas, ti, j + descendingFactor, level + 1, height);
        }
    }

    private static void painting(String[][] canvas) {
        int dataColor = 34;
        int lineColor = -1;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if ("<".equals(canvas[i][j])) {
                    formatPrint("/", lineColor);
                } else if (">".equals(canvas[i][j])) {
                    formatPrint("\\", lineColor);
                } else if (canvas[i][j] == null) {
                    formatPrint(" ", lineColor);
                } else {
                    formatPrint(canvas[i][j], dataColor);
                }
            }
            System.out.println();
        }
    }

    /**
     * @param text  打印的文本
     * @param color 颜色代码：背景颜色代号（41-46），前景颜色代号（31-36）
     */
    private static void formatPrint(String text, int color) {
        if (color != -1) {
            text = String.format("\033[%dm%2s\033[0m", color, text);
        } else {
            text = String.format("%2s", text);
        }
        System.out.printf(text);
    }
}
