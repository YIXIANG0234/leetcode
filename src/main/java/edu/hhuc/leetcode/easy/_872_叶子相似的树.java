package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _872_叶子相似的树 {
    public static void main(String[] args) {
        _872_叶子相似的树 instance = new _872_叶子相似的树();
        TreeNode roo1 = TreeNode.buildTree(Arrays.asList(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4));
        TreeNode roo2 = TreeNode.buildTree(Arrays.asList(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8));
        instance.solution1(roo1, roo2);
    }

    /**
     * 先遍历二叉树得到叶子节点的集合，然后比较叶子节点的集合是否相等
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean solution1(TreeNode root1, TreeNode root2) {
        List<Integer> leafList1 = getAllLeaves(root1);
        List<Integer> leafList2 = getAllLeaves(root2);
        return leafList1.equals(leafList2);
    }

    public List<Integer> getAllLeaves(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        result.addAll(getAllLeaves(root.left));
        result.addAll(getAllLeaves(root.right));
        return result;
    }
}
