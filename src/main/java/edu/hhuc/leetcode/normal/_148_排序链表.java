package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/16 15:48:20
 */
public class _148_排序链表 {
    public static void main(String[] args) {
        _148_排序链表 instance = new _148_排序链表();
        ListNode head = ListNodeUtils.buildLinkedList(new int[]{29, 68, 75, 23, 41, 71, 97, 26, 3, 81});
        ListNodeUtils.beautifulFormat(head);
        ListNodeUtils.beautifulFormat(instance.solution1(head));
    }

    /**
     * 插入排序
     *
     * @param head
     * @return
     */
    public ListNode solution1(ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (current.next == null || current.val <= current.next.val) {
                current = current.next;
                continue;
            }
            // 待排序的节点
            ListNode next = current.next;
            current.next = next.next;
            ListNode prev = null;
            ListNode compare = head;
            while (compare.val < next.val) {
                prev = compare;
                compare = compare.next;
            }
            if (prev == null) {
                head = next;
            } else {
                prev.next = next;
            }
            // 待排序的节点next需要插在compare的前面
            next.next = compare;
        }
        return head;
    }


}
