package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _160_相交链表 {
    public ListNode solution1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode nodeA = headA;
        while (nodeA != null) {
            set.add(nodeA);
            nodeA = nodeA.next;
        }
        ListNode nodeB = headB;
        while (nodeB != null) {
            if (set.contains(nodeB)) {
                return nodeB;
            }
            nodeB = nodeB.next;
        }
        return null;
    }

    /**
     * solution2和solution3是同一种解法，但是solution3代码更加的简洁
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode solution2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (true) {
            // 两个链表同时到达尾部，则不相交
            if (nodeA == null && nodeB == null) {
                return null;
            }
            if (nodeA == null) {
                nodeA = headB;
            }
            if (nodeB == null) {
                nodeB = headA;
            }
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
    }
    /**
     * 官方解法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode solution3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = (nodeA == null ? headB : nodeA.next);
            nodeB = (nodeB == null ? headA : nodeB.next);
        }
        return nodeA;
    }
}
