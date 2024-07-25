package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _142_环形链表II {
    public static void main(String[] args) {
        _142_环形链表II instance = new _142_环形链表II();
        ListNode head = ListNode.buildLinkedList(1, 2, 3, 4, 5, 6);
        ListNode node = new ListNode(7);
        ListNode current = head;
        while (current.next != null) {
            if (current.val == 3) {
                node.next = current;
            }
            current = current.next;
        }
        current.next = node;
        System.out.println(instance.solution1(head).val);
    }

    /**
     * @param head
     * @return
     */
    public ListNode solution1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
