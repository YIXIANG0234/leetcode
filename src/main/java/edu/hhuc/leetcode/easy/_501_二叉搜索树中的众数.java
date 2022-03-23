package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class _501_二叉搜索树中的众数 {
    public static void main(String[] args) {
        _501_二叉搜索树中的众数 instance = new _501_二叉搜索树中的众数();
        TreeNode root = TreeNode.buildTree(Arrays.asList(1, null, 2, 2));
        int[] result = instance.solution1(root);

        System.out.println(Arrays.toString(result));
    }

    /**
     * 先中序遍历，然后统计得到结果
     * @param root
     * @return
     */
    public int[] solution1(TreeNode root) {
        List<Integer> orderNums = inOrder(root);
        if (orderNums.size() == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        orderNums.forEach(x -> {
            map.put(x, map.getOrDefault(x, 0) + 1);
        });
        List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int length = entries.size();
        int max = entries.get(length - 1).getValue();
        for (int i = length - 1; i >= 0; i--) {
            if (max != entries.get(i).getValue()) {
                break;
            }
            result.add(entries.get(i).getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(inOrder(root.left));
        result.add(root.val);
        result.addAll(inOrder(root.right));
        return result;
    }
}
