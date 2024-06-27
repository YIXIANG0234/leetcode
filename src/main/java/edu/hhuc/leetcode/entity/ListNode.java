package edu.hhuc.leetcode.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yixiang
 */
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
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int num : values) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummyHead.next;
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
