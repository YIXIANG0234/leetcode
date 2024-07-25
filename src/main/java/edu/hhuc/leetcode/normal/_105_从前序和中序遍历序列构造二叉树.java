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
 * @date 2024/7/15 21:09:34
 */
public class _105_从前序和中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(3, 9, 20, null, null, 15, 7);
        TreeNode root = TreeNodeUtils.buildTree(list);
        TreeNodeUtils.prettyPrintTree(root);
    }
    public TreeNode solution1(int[] preOrder, int[] inOrder) {
        // 3 9 20 15 7
        // 9 3 15 20 7
        return null;
    }
}
