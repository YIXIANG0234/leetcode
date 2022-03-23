package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;

public class _024_两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode head = ListNode.buildLinkedList(1, 2, 3, 4, 5, 9, 11, 8);
        _024_两两交换链表中的节点 instance = new _024_两两交换链表中的节点();
        ListNode.printLinkedList(instance.solution1(head));
    }

    /**
     * 自己想出来的，写法比solution3麻烦，不易理解
     * @param head
     * @return
     */
    public ListNode solution1(ListNode head) {
        ListNode current = head;
        ListNode tail = null;
        ListNode newHead = null;
        while (current != null && current.next != null) {
            ListNode pre = current;
            ListNode next = current.next;
            if (tail != null) {
                tail.next = next;
            }
            if (newHead == null) {
                newHead = next;
            }
            current = current.next.next;
            next.next = pre;
            pre.next = current;
            tail = pre;
        }
        if (newHead == null) {
            newHead = head;
        }
        return newHead;
    }

    /**
     * 这种递归的写法太赞了
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = head.next;
        ListNode three = head.next.next;
        two.next = one;
        one.next = solution2(three);
        return two;
    }

    /**
     * 官方写法要简洁一点啊
     * @param head
     * @return
     */
    public ListNode solution3(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
