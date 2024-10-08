package edu.hhuc.leetcode.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * @program: leetcode
 * @ClassName ListNodeUtils
 * @description:
 * @author: gaoya
 * @create: 2024-10-07 18:32
 * @Version 1.0
 */
public class ListNodeUtils {
    public static ListNode buildLinkedList(int... values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int num : values) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static ListNode randomList(int size) {
        Random random = new Random();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = random.nextInt(100);
        }
        return buildLinkedList(nums);
    }

    public static void printLinkedList(ListNode head) {
        List<Integer> result = getAllNodes(head);
        System.out.println(result);
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

    public static void beautifulFormat(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (Objects.nonNull(head)) {
            sb.append(head.val);
            if (Objects.nonNull(head.next)) {
                sb.append(" -> ");
            }
            head = head.next;
        }
        System.out.println(sb);
    }

    public static ListNode join(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        ListNode current = headA;
        while (current.next != null) {
            current = current.next;
        }
        current.next = headB;
        return headA;
    }
}
