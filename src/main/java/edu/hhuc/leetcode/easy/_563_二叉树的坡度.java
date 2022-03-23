package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

public class _563_二叉树的坡度 {
    /**
     * 递归解法，先求根节点的坡度，然后递归求解左右子树的坡度，最后将根节点的坡度和左子树的坡度，
     * 右子树的坡度相加得到结果，其中，需要用先（中，后）序遍历求得数的节点的总和
     * @param root
     * @return
     */
    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currentTilt = Math.abs(getTotal(root.left) - getTotal(root.right));
        return currentTilt + solution1(root.left) + solution1(root.right);
    }

    /**
     * 先序遍历求解根节点的和
     * @param root
     * @return
     */
    public int getTotal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int total = root.val;
        total += getTotal(root.left);
        total += getTotal(root.right);
        return total;
    }
}
