package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/15 21:09:34
 */
public class _105_从前序和中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        _105_从前序和中序遍历序列构造二叉树 instance = new _105_从前序和中序遍历序列构造二叉树();
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode root = instance.solution1(preOrder, inOrder);
        TreeNodeUtils.prettyPrintTree(root);
    }

    public TreeNode solution1(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return recurse(preorder, 0, n - 1, 0, map);
    }

    /**
     * @param preorder      前序遍历序列
     * @param preOrderLeft  前序遍历序列开始节点
     * @param preOrderRight 前序遍历序列开始节点
     * @param inOrderLeft   中序遍历序列开始节点
     * @param map           中序遍历序列
     * @return
     */
    private TreeNode recurse(int[] preorder, int preOrderLeft, int preOrderRight, int inOrderLeft, Map<Integer, Integer> map) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }
        // 根节点
        int rootVal = preorder[preOrderLeft];
        // 根节点在中序遍历中的位置
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        // 左子树节点的数量
        int leftChildSize = rootIndex - inOrderLeft;
        root.left = recurse(preorder, preOrderLeft + 1, preOrderLeft + leftChildSize, inOrderLeft, map);
        root.right = recurse(preorder, preOrderLeft + leftChildSize + 1, preOrderRight, rootIndex + 1, map);
        return root;
    }
}
