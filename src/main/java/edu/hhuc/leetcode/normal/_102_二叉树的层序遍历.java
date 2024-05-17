package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.*;

public class _102_二叉树的层序遍历 {

    public static void main(String[] args) {
        _102_二叉树的层序遍历 instance = new _102_二叉树的层序遍历();
        TreeNode root = TreeNodeUtils.buildTree(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(instance.solution2(root));
    }

    /**
     * 广度优先搜索实现层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> solution1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前层节点的数量
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<levelSize;i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 深度优先搜索实现层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> solution2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (result.size() < level+1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            dfs(root.left, level+1, result);
        }
        if (root.right != null) {
            dfs(root.right, level+1, result);
        }
    }
}
