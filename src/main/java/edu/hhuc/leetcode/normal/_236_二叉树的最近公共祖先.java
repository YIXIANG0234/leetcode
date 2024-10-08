package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.*;

public class _236_二叉树的最近公共祖先 {

    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    private Set<TreeNode> visited = new HashSet<>();

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        TreeNode p = null;
        TreeNode q = null;
        _236_二叉树的最近公共祖先 instance = new _236_二叉树的最近公共祖先();
        instance.solution1(root, p, q);
        System.out.println(root);
    }

    /**
     * 递归查找
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = solution1(root.left, p, q);
        TreeNode right = solution1(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    /**
     * 先记录所有节点 父节点，然后分别向上查p，q的父节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p);
            p = parentMap.get(p);
        }

        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            dfs(root.right);
        }
    }
}
