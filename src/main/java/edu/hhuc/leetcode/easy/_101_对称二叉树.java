package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.*;

public class _101_对称二叉树 {
    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildTree(new int[]{1,2,2,3,4,4,3});
        TreeNodeUtils.prettyPrintTree(root);
        _101_对称二叉树 instance = new _101_对称二叉树();
        System.out.println(instance.solution4(root));

    }
    /**
     * 深度优先遍历：递归解法
     * @param root
     * @return
     */
    public boolean solution1(TreeNode root) {
       return isSymmetric(root.left, root.right);
    }

    /**
     * 广度优先遍历：迭代解法
     * @param root
     * @return
     */
    public boolean solution2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int head = 0;
            int tail = queue.size() - 1;
            while (head <= tail) {
                TreeNode headNode = queue.get(head);
                TreeNode tailNode = queue.get(tail);
                if (headNode == null ^ tailNode == null) {
                    return false;
                }
                if ((headNode == null && tailNode == null ) || (headNode.val == tailNode.val)) {
                    head++;
                    tail--;
                    continue;
                }
                return false;
            }
            int size = queue.size();
            for (int i=0;i< size;i++) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
        }
        return true;
    }

    /**
     * 广度优先遍历：写法比solution2要简洁
     * @param root
     * @return
     */
    public boolean solution3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2= queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public boolean solution4(TreeNode root) {
        if (root == null) {
            return true;
        }
        return test(root.left, root.right);
    }

    public boolean solution5(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        int size = result.size();
        for (int i = 0; i < size / 2; i++) {
            if (!result.get(i).equals(result.get(size - i - 1))) {
                return false;
            }
        }
        return true;
    }

    public boolean test(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && test(left.left, right.right) && test(left.right, right.left);
    }
}
