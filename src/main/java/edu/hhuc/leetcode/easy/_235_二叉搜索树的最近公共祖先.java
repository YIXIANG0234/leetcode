package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

public class _235_二叉搜索树的最近公共祖先 {
    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        // 在左子树中查找
        if (root.val > p.val && root.val > q.val) {
            return solution1(root.left, p, q);
        }

        // 在右子树中查找
        if (root.val < p.val && root.val < q.val) {
            return solution1(root.right, p, q);
        }
        // 最近祖先为根节点
        return root;
    }
    /**
     * 遍历
     */
    public TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (ancestor.val > p.val && ancestor.val > q.val) {
                ancestor = ancestor.left;
            } else if (ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    public TreeNode solution3(TreeNode root, TreeNode p, TreeNode q) {
        //如果根节点和p,q的差相乘是正数，说明这两个差值要么都是正数要么都是负数，也就是说
        //他们肯定都位于根节点的同一侧，就继续往下找
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        //如果相乘的结果是负数，说明p和q位于根节点的两侧，如果等于0，说明至少有一个就是根节点
        return root;
    }

}
