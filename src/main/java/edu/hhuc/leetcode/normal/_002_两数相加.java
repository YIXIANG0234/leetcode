package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

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
        ListNode node1 = ListNodeUtils.buildLinkedList(1, 4, 8, 9);
        ListNode node2 = ListNodeUtils.buildLinkedList(5, 7, 3, 9, 0, 1, 7);
        _002_两数相加 instance = new _002_两数相加();
        ListNode result = instance.solution3(node1, node2);
        ListNodeUtils.printLinkedList(result);
    }

    /**
     * 比较容易理解的写法啦
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }

    /**
     * 解法一的简洁实现版本
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return dummy.next;
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
        int sum = carry;
        if (l1 != null) {
            sum = sum + l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum = sum + l2.val;
            l2 = l2.next;
        }
        ListNode current = new ListNode(sum % 10);
        current.next = recursive(l1, l2, sum / 10);
        return current;
    }
}
