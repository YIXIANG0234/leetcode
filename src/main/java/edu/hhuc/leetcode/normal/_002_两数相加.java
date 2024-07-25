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
        ListNode node1 = ListNode.buildLinkedList(1,4,8,9);
        ListNode node2 = ListNode.buildLinkedList(5,7,3,9,0,1,7);
        _002_两数相加 instance = new _002_两数相加();
        ListNode result = instance.solution3(node1, node2);
        ListNode.printLinkedList(result);
    }

    public ListNode solution1(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = node;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = node;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = node;
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            current.next = node;
        }
        return head;
    }

    /**
     * 优化版，将多个while循环合并
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution2(ListNode l1, ListNode l2) {
        // 设置哑节点
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            current.next = node;
        }
        return head.next;
    }

    /**
     * 使用递归解决
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution3(ListNode l1, ListNode l2) {
        return recurse(l1, l2, 0);
    }

    public ListNode recurse(ListNode l1, ListNode l2, int carry) {
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
        node.next = recurse(l1, l2, carry);
        return node;
    }
}
