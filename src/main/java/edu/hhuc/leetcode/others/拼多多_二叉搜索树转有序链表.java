package edu.hhuc.leetcode.others;

import com.google.common.collect.Lists;
import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.TreeNode;
import edu.hhuc.leetcode.entity.TreeNodeUtils;

import java.util.List;

/**
 * @program: leetcode
 * @ClassName 拼多多_二叉搜索树转有序链表
 * @description:
 * @author: gaoya
 * @create: 2023-02-23 15:05
 * @Version 1.0
 */
public class 拼多多_二叉搜索树转有序链表 {
    private ListNode dummy = new ListNode(-1);
    private ListNode current = dummy;

    public static void main(String[] args) {
        拼多多_二叉搜索树转有序链表 instance = new 拼多多_二叉搜索树转有序链表();
        TreeNode root = TreeNodeUtils.buildTree(Lists.newArrayList(8, 5, 12, 3, 6, 10, 15));
        ListNode node = instance.solution(root);
        System.out.println("中序遍历结果：" + TreeNode.inOrder(root));
        ListNode.printLinkedList(node);
    }

    public ListNode solution(TreeNode root) {
        transfer(root);
        return dummy.next;
    }

    public void transfer(TreeNode root) {
        if (root == null) {
            return;
        }
        transfer(root.left);
        ListNode node = new ListNode(root.val);
        current.next = node;
        current = current.next;
        transfer(root.right);
    }
}
