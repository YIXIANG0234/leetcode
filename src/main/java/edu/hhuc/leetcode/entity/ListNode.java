package edu.hhuc.leetcode.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildLinkedList(int... values) {
        if (values == null) {
            return null;
        }
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < values.length; i++) {
            ListNode node = new ListNode(values[i]);
            if (i == 0) {
                head = node;
                current = node;
            }
            current.next = node;
            current = node;
        }
        return head;
    }

    public static List<Integer> getAllNodes(ListNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    public static void printLinkedList(ListNode head) {
        List<Integer> result = getAllNodes(head);
        System.out.println(result);
    }

    public static void formatList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (Objects.nonNull(head)) {
            sb.append(head.val);
            if (Objects.nonNull(head.next)) {
                sb.append("->");
            }
            head = head.next;
        }
        System.out.println(sb);
    }
}
