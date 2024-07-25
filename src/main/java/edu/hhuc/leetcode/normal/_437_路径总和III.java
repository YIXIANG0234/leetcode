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
 * @date 2024/7/23 15:21:11
 */
public class _437_路径总和III {

    public static void main(String[] args) {
        // List<Integer> list = Lists.newArrayList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
        // int target = 8;
        List<Integer> list = Lists.newArrayList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        int target = 22;
        TreeNode root = TreeNodeUtils.buildTree(list);
        _437_路径总和III instance = new _437_路径总和III();
        TreeNodeUtils.prettyPrintTree(root);
        System.out.println(instance.solution1(root, target));
    }

    public int solution1(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        return backtrace(root, target, 0) + backtrace(root.left, target, 0) + backtrace(root.right, target, 0);
    }

    private int backtrace(TreeNode root, int target, int sum) {
        if (root == null) {
            return 0;
        }
        if (target == sum + root.val) {
            return 1;
        }
        return backtrace(root.left, target, sum + root.val) + backtrace(root.right, target, sum + root.val);
    }
}
