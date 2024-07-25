package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/16 15:48:20
 */
public class _148_排序链表 {
    public static void main(String[] args) {
        _148_排序链表 instance = new _148_排序链表();
        // ListNode head = ListNode.randomList(10);
        ListNode head = ListNode.buildLinkedList(new int[]{29, 68, 75, 23, 41, 71, 97, 26, 3, 81});
        ListNode.formatList(head);
        ListNode.formatList(instance.solution1(head));
    }

    public ListNode solution1(ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (current.next == null || current.val <= current.next.val) {
                current = current.next;
            } else {
                ListNode next = current.next;
                current.next = next.next;
                ListNode top = head;
                ListNode prev = null;
                while (top.val < next.val) {
                    prev = top;
                    top = top.next;
                }
                if (prev != null) {
                    prev.next = next;
                } else {
                    head = next;
                }
                next.next = top;
            }
        }
        return head;
    }
}
