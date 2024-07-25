package edu.hhuc.leetcode.normal;

import com.google.common.collect.Lists;
import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.List;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/15 21:22:33
 */
public class _114_二叉树展开为链表 {
    public static void main(String[] args) {
        _114_二叉树展开为链表 instance = new _114_二叉树展开为链表();
        List<Integer> list = Lists.newArrayList(1, 2, 5, 3, 4, null, 6);
        TreeNode root = TreeNodeUtils.buildTree(list);
        TreeNodeUtils.prettyPrintTree(root);
        instance.solution1(root);
        TreeNodeUtils.prettyPrintTree(root);
    }

    public void solution1(TreeNode root) {
        backtrace(root);
    }

    public TreeNode backtrace(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode right = root.right;
        root.right = backtrace(root.left);
        root.left = null;
        if (root.right!=null) {
            root = root.right;
        }
        root.right = backtrace(right);
        if (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
