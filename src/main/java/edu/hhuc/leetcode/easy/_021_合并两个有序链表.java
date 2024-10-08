package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

public class _021_合并两个有序链表 {
    public static void main(String[] args) {
        _021_合并两个有序链表 instance = new _021_合并两个有序链表();
        ListNode list1 = ListNodeUtils.buildLinkedList(1, 2, 4);
        ListNode list2 = ListNodeUtils.buildLinkedList(1, 3, 4);
        ListNode result = instance.solution1(list1, list2);
        ListNodeUtils.beautifulFormat(result);
    }

    /**
     * 迭代解法
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (list1 != null || list2 != null) {
            if (list1 != null && (list2 == null || list1.val <= list2.val)) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }
        return dummy.next;
    }

    /**
     * 迭代解法二，比较长的链表可以直接合并
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution2(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode node = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        node.next = (list1 != null ? list1 : list2);
        return result.next;
    }

    /**
     * 递归解法
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution3(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode current;
        if (list1 != null && (list2 == null || list1.val <= list2.val)) {
            current = list1;
            current.next = solution2(list1.next, list2);
        } else {
            current = list2;
            current.next = solution2(list1, list2.next);
        }
        return current;
    }

    /**
     * 递归解法的另一种写法
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution4(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = solution3(list1.next, list2);
            return list1;
        } else {
            list2.next = solution3(list1, list2.next);
            return list2;
        }
    }
}