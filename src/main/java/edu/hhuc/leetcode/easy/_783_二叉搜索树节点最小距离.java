package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.Collections;
import java.util.List;

public class _783_二叉搜索树节点最小距离 {
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int solution1(TreeNode root) {
        List<Integer> list = TreeNode.preOrder(root);
        Collections.sort(list);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            result = Math.min(result, list.get(i) - list.get(i - 1));
        }
        return result;
    }

    /**
     * 直接中序遍历，不用排序
     * @param root
     * @return
     */
    public int solution2(TreeNode root) {
        dfs(root);
        return result;
    }
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }
}
