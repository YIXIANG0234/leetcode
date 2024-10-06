package edu.hhuc.leetcode.normal;

import com.google.common.collect.Lists;
import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    /**
     * 先先序遍历，得到先序遍历的序列，然后变更为单链表
     *
     * @param root
     */
    public void solution1(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        TreeNode current = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            current.left = null;
            current.right = list.get(i);
            current = current.right;
        }
    }

    /**
     * 先序遍历，在先序遍历的过程中维护prev指针
     *
     * @param root
     */
    public void solution2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = current;
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            prev = current;
        }
    }

    /**
     * 根据先序遍历的规则，根节点 -> 左子树 -> 右子树
     * 左子树中最后一个右子树的节点遍历结束之后，会开始遍历右子树
     *
     * @param root
     */
    public void solution3(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode prev = current.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

}
