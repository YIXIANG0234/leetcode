package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/14 17:28:20
 */
public class _096_不同的二叉搜索树 {
    public static void main(String[] args) {
        _096_不同的二叉搜索树 instance = new _096_不同的二叉搜索树();
        System.out.println(instance.solution2(3));
    }

    /**
     * 动态规划，dp[i]表示由1-i的数字序列构成的二叉搜索树种类
     *
     * @param n
     * @return
     */
    public int solution1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 第一层循环，枚举二叉搜索树的节点个数
        for (int i = 2; i <= n; i++) {
            // 当节点个数为i时，计算这i个节点可以构成的二叉搜索树的种类
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + (dp[j - 1] * dp[i - j]);
            }
        }
        return dp[n];
    }


    /**
     * 扩展：枚举每种二叉搜索树
     *
     * @param n
     * @return
     */
    public int solution2(int n) {
        List<TreeNode> treeNodes = generateTree(1, n);
        for (TreeNode node : treeNodes) {
            TreeNodeUtils.prettyPrintTree(node);
        }
        return treeNodes.size();
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            // 关键，必须要添加null，否则得到的leftChildren/rightChildren为空list
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            // 递归生成左子树和右子树
            List<TreeNode> leftChildren = generateTree(start, i - 1);
            List<TreeNode> rightChildren = generateTree(i + 1, end);

            // 组合左子树和右子树，便得到以i为根节点的所有二叉搜索树的情形
            for (TreeNode left : leftChildren) {
                for (TreeNode right : rightChildren) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }


}
