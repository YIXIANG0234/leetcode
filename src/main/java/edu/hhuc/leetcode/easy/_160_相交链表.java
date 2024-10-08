package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _160_相交链表 {
    public ListNode solution1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!set.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode solution3(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = (nodeA == null ? headB : nodeA.next);
            nodeB = (nodeB == null ? headA : nodeB.next);
        }
        return nodeA;
    }
}
