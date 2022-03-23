package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class _530_二叉搜索树的最小绝对差 {
    private int result;
    private TreeNode prev;
    public static void main(String[] args) {
        _530_二叉搜索树的最小绝对差 instance = new _530_二叉搜索树的最小绝对差();
        TreeNode root = TreeNode.buildTree(Arrays.asList(236, 104, 701, null, 227, null, 911));
        System.out.println(instance.solution3(root));

    }

    /**
     * 先求根节点与左子树（找到左子树中的最大值）和右子树（找到右子树中的最小值）的绝对值，
     * 然后递归寻找左右子树的最小绝对值，从四个绝对值中选取最小的，即为答案
     *
     * @param root
     * @return
     */
    public int solution1(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        TreeNode leftMax = root.left;
        TreeNode rightMin = root.right;

        while (leftMax != null && leftMax.right != null) {
            leftMax = leftMax.right;
        }
        while (rightMin != null && rightMin.left != null) {
            rightMin = rightMin.left;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (leftMax != null) {
            left = Math.abs(root.val - leftMax.val);
        }
        if (rightMin != null) {
            right = Math.abs(root.val - rightMin.val);
        }
        int leftDiff = solution1(root.left);
        int rightDiff = solution1(root.right);
        int[] result = new int[]{left, right, leftDiff, rightDiff};
        Arrays.sort(result);
        return result[0];
    }

    /**
     * 直接中序遍历，然后计算前一个节点和当前节点的差的绝对值，求其中最小的绝对值，写法更简洁
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        int result = Integer.MAX_VALUE;
        TreeNode prev = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null) {
                result = Math.min(result , Math.abs(root.val - prev.val));
            }
            prev = root;
            root = root.right;
        }
        return result;
    }

    /**
     * 递归的中序遍历解法
     * @param root
     * @return
     */
    public int solution3(TreeNode root) {
        result = Integer.MAX_VALUE;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev == null) {
            prev = root;
        } else {
            result = Math.min(result, Math.abs(root.val - prev.val));
            prev = root;
        }
        dfs(root.right);
    }
}
