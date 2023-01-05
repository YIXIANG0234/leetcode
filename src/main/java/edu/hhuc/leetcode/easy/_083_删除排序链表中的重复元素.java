package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;

public class _083_删除排序链表中的重复元素 {
    public ListNode solution1(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    /**
     * 递归解法，秒啊
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = solution2(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
