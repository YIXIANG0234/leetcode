package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _160_相交链表 {
    public static void main(String[] args) {
        _160_相交链表 instance = new _160_相交链表();
        ListNode headA = ListNode.buildLinkedList(4, 1);
        ListNode headB = ListNode.buildLinkedList(5, 6, 1);
        ListNode headC = ListNode.buildLinkedList(8, 4, 5);
        headA = ListNode.join(headA, headC);
        headB = ListNode.join(headB, headC);
        ListNode node = instance.solution3(headA, headB);
        System.out.println(node == null ? null : node.val);
    }


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
     *
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

    public ListNode solution4(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode solution5(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int countA = 0;
        int countB = 0;
        ListNode current = headA;
        while (current != null) {
            countA++;
            current = current.next;
        }
        current = headB;
        while (current != null) {
            countB++;
            current = current.next;
        }

        int offset = countA >= countB ? countA - countB : countB - countA;
        ListNode node1 = countA >= countB ? headA : headB;
        ListNode node2 = countA >= countB ? headB : headA;
        int count = 0;
        while (node1 != null && node2 != null) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            if (count >= offset) {
                node2 = node2.next;
            }
            count++;
        }
        return null;
    }
}
