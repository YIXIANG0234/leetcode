package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/23 10:42:14
 */
public class _337_打家劫舍III {
    public static void main(String[] args) {
        _337_打家劫舍III instance = new _337_打家劫舍III();
        TreeNode root = TreeNodeUtils.randomTree(5);
        // int[] node = {11, 2, 23, 12, 17, 97};
        // TreeNode root = TreeNodeUtils.buildTree(node);
        // List<Integer> list = Lists.newArrayList(3, 2, 3, null, 3, null, 1);
        // TreeNode root = TreeNodeUtils.buildTree(list);
        TreeNodeUtils.prettyPrintTree(root);
        System.out.println(instance.solution1(root));
    }

    public int solution1(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        return new int[]{root.val + l[1] + r[1], Math.max(l[0], l[1]) + Math.max(r[0], r[1])};
    }
}
