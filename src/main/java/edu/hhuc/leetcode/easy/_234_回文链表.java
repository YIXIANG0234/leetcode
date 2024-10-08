package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.Stack;

public class _234_回文链表 {
    private ListNode prev;

    public boolean solution1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        while (head != null) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean solution2(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        int left = 0;
        int right = sb.length() - 1;
        while (left <= right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 递归正向，反向迭代
     *
     * @param head
     * @return
     */
    public boolean solution3(ListNode head) {
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
