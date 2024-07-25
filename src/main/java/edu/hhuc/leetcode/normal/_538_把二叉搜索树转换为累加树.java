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
 * @date 2024/7/23 20:22:09
 */
public class _538_把二叉搜索树转换为累加树 {
    public static void main(String[] args) {
        _538_把二叉搜索树转换为累加树 instance = new _538_把二叉搜索树转换为累加树();
        List<Integer> list1 = Lists.newArrayList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);
        TreeNode root = TreeNodeUtils.buildTree(list1);
        List<Integer> list2 = Lists.newArrayList(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8);
        TreeNode verify = TreeNodeUtils.buildTree(list2);

        // List<Integer> list1 = Lists.newArrayList(1, 0, 2);
        // TreeNode root = TreeNodeUtils.buildTree(list1);
        // List<Integer> list2 = Lists.newArrayList(3, 3, 2);
        // TreeNode verify = TreeNodeUtils.buildTree(list2);

        // List<Integer> list1 = Lists.newArrayList(3, 2, 4, 1);
        // TreeNode root = TreeNodeUtils.buildTree(list1);
        // List<Integer> list2 = Lists.newArrayList(7, 9, 4, 10);
        // TreeNode verify = TreeNodeUtils.buildTree(list2);

        TreeNodeUtils.prettyPrintTree(root);
        TreeNodeUtils.prettyPrintTree(verify);

        TreeNode result = instance.solution2(root);
        TreeNodeUtils.prettyPrintTree(result);
    }

    public TreeNode solution1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current);
            current = current.right;
        }
        int prev = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            TreeNode node = list.get(i);
            node.val = node.val + prev;
            prev = node.val;
        }
        return root;
    }

    public TreeNode solution2(TreeNode root) {
        return root;
    }

}
