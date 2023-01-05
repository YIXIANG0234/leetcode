package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;

/**
 * @program: leetcode
 * @ClassName _082_删除排序链表中的重复元素II
 * @description:
 * @author: gaoya
 * @create: 2022-12-02 14:37
 * @Version 1.0
 */
public class _082_删除排序链表中的重复元素II {
    public static void main(String[] args) {
        _082_删除排序链表中的重复元素II instance = new _082_删除排序链表中的重复元素II();
        ListNode head = ListNode.buildLinkedList(1, 2, 3, 3, 4, 4, 5);
        ListNode.formatList(instance.solution1(head));
    }

    public ListNode solution1(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int x = current.next.val;
                while (current.next != null && current.next.val == x) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}
