package edu.hhuc.leetcode.hard;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

import java.util.PriorityQueue;

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
        ListNode node1 = ListNodeUtils.buildLinkedList(1, 4, 5);
        ListNode node2 = ListNodeUtils.buildLinkedList(1, 3, 4);
        ListNode node3 = ListNodeUtils.buildLinkedList(2, 6, 7);
        ListNode[] lists = {node1, node2, node3};
        ListNode result = instance.solution4(lists);
        ListNodeUtils.printLinkedList(result);
    }


    /**
     * 暴力破解，每次在n个有序链表中选出最小的节点加入结果集，注意对已遍历结束的链表的处理
     *
     * @param lists
     * @return
     */
    public ListNode solution1(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (true) {
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && (minIndex == -1 || lists[i].val <= lists[minIndex].val)) {
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                break;
            }
            current.next = lists[minIndex];
            current = current.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return dummy.next;
    }

    /**
     * 顺序合并，先合并第一个和第二个链表，再将第一个和第二个链表的合并结果和第三个进行合并
     * 两两合并时使用两个有序链表的解法
     *
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
     * 优先队列
     *
     * @param lists
     * @return
     */
    public ListNode solution3(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (!queue.isEmpty()) {
            ListNode top = queue.poll();
            current.next = top;
            current = current.next;
            top = top.next;
            if (top != null) {
                queue.offer(top);
            }
        }
        return dummy.next;
    }

    /**
     * 分治法
     *
     * @param lists
     * @return
     */
    public ListNode solution4(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode node1 = divide(lists, left, mid);
        ListNode node2 = divide(lists, mid + 1, right);
        return mergeList(node1, node2);
    }

    /**
     * 合并两个有序链表
     *
     * @param a
     * @param b
     * @return
     */
    private ListNode mergeList(ListNode a, ListNode b) {
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
