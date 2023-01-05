package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.Stack;

public class _234_回文链表 {
    private ListNode prev;
    public boolean solution1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty() && head != null) {
            ListNode top = stack.pop();
            if (head.val != top.val) {
                return false;
            }
            head = head.next;
        }
        return stack.isEmpty() && head == null;
    }

    /**
     * 递归正向，反向迭代
     * @param head
     * @return
     */
    public boolean solution2(ListNode head) {
        prev = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (prev.val != currentNode.val) {
                return false;
            }
            prev = prev.next;
        }
        return true;
    }
}
