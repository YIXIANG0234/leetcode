package edu.hhuc.leetcode.hard;

import edu.hhuc.leetcode.entity.ListNode;

/**
 * @program: leetcode
 * @ClassName _023_合并K个升序链表
 * @description:
 * @author: gaoya
 * @create: 2023-02-23 09:56
 * @Version 1.0
 */
public class _023_合并K个升序链表 {
    public static void main(String[] args) {
        _023_合并K个升序链表 instance = new _023_合并K个升序链表();
        ListNode node1 = ListNode.buildLinkedList(1, 4, 5);
        ListNode node2 = ListNode.buildLinkedList(1, 3, 4);
        ListNode node3 = ListNode.buildLinkedList(2, 6);
        ListNode[] lists = {node1, node2, node3};
        ListNode result = instance.solution2(lists);
        ListNode.printLinkedList(result);
    }

    /**
     * 暴力破解，每次在n个有序链表中选出最小的节点加入结果集，注意对已遍历结束的链表的处理
     *
     * @param lists
     * @return
     */
    public ListNode solution1(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode processNode = dummy;
        while (true) {
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (minIndex == -1) {
                    minIndex = lists[i] == null ? -1 : i;
                    continue;
                }
                ListNode minNode = lists[minIndex];
                ListNode current = lists[i];
                if (current != null && current.val < minNode.val) {
                    minIndex = i;
                }
            }
            // 表示所有的有序链表都已经处理完毕
            if (minIndex == -1) {
                break;
            }
            processNode.next = lists[minIndex];
            processNode = processNode.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return dummy.next;
    }

    /**
     * 顺序合并，先合并第一个和第二个链表，再将第一个和第二个链表的合并结果和第三个进行合并
     * 两两合并时使用两个有序链表的解法
     * @param lists
     * @return
     */
    public ListNode solution2(ListNode[] lists) {
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result = mergeList(result, lists[i]);
        }
        return result;
    }

    /**
     * 合并两个有序链表
     * @param a
     * @param b
     * @return
     */
    public ListNode mergeList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = a != null ? a : b;
        return dummy.next;
    }
}
