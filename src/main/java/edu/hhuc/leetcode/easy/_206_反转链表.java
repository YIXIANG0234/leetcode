package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

public class _206_反转链表 {

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.buildLinkedList(1, 2, 3, 4, 5);
        _206_反转链表 instance = new _206_反转链表();
        ListNodeUtils.printLinkedList(instance.solution2(head));
    }
    public ListNode solution1(ListNode head) {
        ListNode result = null;
        ListNode current = head;
        while (current != null) {
            // 记住上一个节点
            ListNode prev = current;
            // 指针移动到下一个节点
            ListNode next = current.next;

            // 逆转指针的方向
            prev.next = result;
            result = prev;
            current = next;
        }
        return result;
    }

    public ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 求当前链表的反转链表，等于下一个节点的反转链表，然后再拼上当前节点
        ListNode newHead = solution2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 二刷
     * @param head
     * @return
     */
    public ListNode solution3(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode prev = head;
            head = head.next;
            prev.next = result;
            result = prev;
        }
        return result;
    }
}
