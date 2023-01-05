package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;

public class _328_奇偶链表 {

    public static void main(String[] args) {
        _328_奇偶链表 instance = new _328_奇偶链表();
        ListNode head = ListNode.buildLinkedList(1, 2, 3, 4, 5);
        ListNode.printLinkedList(instance.solution1(head));
    }

    public ListNode solution1(ListNode head) {
        ListNode newHead = head;
        ListNode oddTail = null;
        ListNode evenTail = null;
        int index = 1;
        while (head != null) {
            ListNode currentNode = head;
            head = head.next;
            // 很重要，切断当前处理节点的连接，否则可能会出现死循环
            currentNode.next = null;
            if (index % 2 == 1) {
                // 初始化奇链表尾节点
                if (oddTail == null) {
                    oddTail = currentNode;
                } else {
                    // 当前奇链表的尾节点的下一个节点是偶链表的头节点
                    ListNode evenHead = oddTail.next;
                    oddTail.next = currentNode;
                    oddTail = oddTail.next;
                    // 奇链表指向偶链表
                    oddTail.next = evenHead;
                }
            } else {
                // 初始化偶链表尾节点
                if (evenTail == null) {
                    evenTail = currentNode;
                    oddTail.next = evenTail;
                } else {
                    // 偶节点添加到偶链表结尾
                    evenTail.next = currentNode;
                    evenTail = evenTail.next;
                }
            }
            index++;
        }
        return newHead;
    }

    /**
     * 官方的解法真的比我的解法好太多了
     *
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
