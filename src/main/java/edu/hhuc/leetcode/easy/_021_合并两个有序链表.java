package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;

public class _021_合并两个有序链表 {
    /**
     * 双指针
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode(-1);
        ListNode node = result;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            node.next = list1;
            node = node.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            node.next = list2;
            node = node.next;
            list2 = list2.next;
        }
        return result.next;
    }

    /**
     * 递归解法
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution2(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        recursive(result, list1, list2);
        return result.next;
    }

    private void recursive(ListNode node, ListNode list1, ListNode list2) {
        if (list1 == null) {
            node.next = list2;
            return;
        }
        if (list2 == null) {
            node.next = list1;
            return;
        }
        if (list1.val <= list2.val) {
            node.next = list1;
            recursive(node.next, list1.next, list2);
            return;
        }
        node.next = list2;
        recursive(node.next, list1, list2.next);
    }

    /**
     * 官方递归解法，比我写的简洁多了
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution3(ListNode list1, ListNode list2) {
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

    /**
     * 官方的迭代写法，也比我的简洁多
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution4(ListNode list1, ListNode list2) {
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
}