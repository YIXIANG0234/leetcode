package edu.hhuc.leetcode.剑指Offer;

import edu.hhuc.leetcode.entity.ListNode;

/**
 * @program: leetcode
 * @ClassName _024_反转链表
 * @description:
 * @author: gaoya
 * @create: 2022-12-12 21:46
 * @Version 1.0
 */
public class _024_反转链表 {
    public static void main(String[] args) {
        _024_反转链表 instance = new _024_反转链表();
        ListNode head = ListNode.buildLinkedList(1, 2, 3, 4, 5);
        ListNode.printLinkedList(instance.reverseList2(head));
    }

    public ListNode reverseList1(ListNode head) {
        // 上一个节点
        ListNode current = null;
        while (head != null) {
            // 即将断开链接，记录下一个节点
            ListNode next = head.next;

            // 当前节点指向上一个节点
            head.next = current;
            current = head;

            head = next;
        }
        return current;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return recursive(head, null);
    }

    public ListNode recursive(ListNode head, ListNode result) {
        if (head == null) {
            return result;
        }
        ListNode next = head.next;

        head.next = result;
        result = head;
        return recursive(next, result);
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList3(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
