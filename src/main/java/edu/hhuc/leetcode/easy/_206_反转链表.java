package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

import java.util.Stack;

public class _206_反转链表 {

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.buildLinkedList(1, 2, 3, 4, 5);
        _206_反转链表 instance = new _206_反转链表();
        ListNodeUtils.printLinkedList(instance.solution1(head));
    }

    public ListNode solution1(ListNode head) {
        ListNode current = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = current;
            current = head;
            head = next;
        }
        return current;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
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
     * 借助栈实现反转链表
     *
     * @param head
     * @return
     */
    public ListNode solution3(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            top.next = null;
            current.next = top;
            current = current.next;
        }
        return dummy.next;
    }


}
