package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;

/**
 * @program: leetcode
 * @ClassName _002_两数相加
 * @description:
 * @author: gaoya
 * @create: 2022-12-02 11:50
 * @Version 1.0
 */
public class _002_两数相加 {
    public static void main(String[] args) {
        ListNode node1 = ListNode.buildLinkedList(1, 4, 8, 9);
        ListNode node2 = ListNode.buildLinkedList(5, 7, 3, 9, 0, 1, 7);
        _002_两数相加 instance = new _002_两数相加();
        ListNode result = instance.solution3(node1, node2);
        ListNode.printLinkedList(result);
    }

    /**
     * 比较容易理解的写法啦
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution1(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            carry = l1.val + l2.val + carry;
            current.next = new ListNode(carry % 10);
            carry = carry / 10;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            carry = l1.val + carry;
            current.next = new ListNode(carry % 10);
            carry = carry / 10;
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            carry = l2.val + carry;
            current.next = new ListNode(carry % 10);
            carry = carry / 10;
            current = current.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }

    /**
     * 思路和solution1完全一致，但是写法更加简洁
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            carry = a + b + carry;
            current.next = new ListNode(carry % 10);
            current = current.next;
            carry = carry / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }

    /**
     * 递归解法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution3(ListNode l1, ListNode l2) {
        return recursive(l1, l2, 0);
    }

    private ListNode recursive(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;
        carry = a + b + carry;
        ListNode node = new ListNode(carry % 10);
        carry = carry / 10;
        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }
        node.next = recursive(l1, l2, carry);
        return node;
    }
}
