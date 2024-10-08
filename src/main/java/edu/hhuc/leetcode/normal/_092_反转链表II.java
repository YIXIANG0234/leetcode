package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

/**
 * @program: leetcode
 * @ClassName _092_反转链表II
 * @description:
 * @author: gaoya
 * @create: 2022-12-02 15:53
 * @Version 1.0
 */
public class _092_反转链表II {
    public static void main(String[] args) {
        ListNode head = ListNodeUtils.buildLinkedList(1, 2, 3, 4, 5);
        _092_反转链表II instance = new _092_反转链表II();
        ListNodeUtils.printLinkedList(instance.solution2(head, 2, 4));
    }

    /**
     * 将链表拆分为3段，对需要反转的部分反转后再拼接
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode solution1(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode leftPre = null;
        ListNode leftNode = null;
        ListNode rightNext = null;
        ListNode pre = dummy;
        int index = 1;
        while (head != null) {
            if (index == left) {
                leftPre = pre;
                leftNode = head;
            }
            if (index == right) {
                rightNext = head.next;
                head.next = null;
            }
            index++;
            pre = head;
            head = head.next;
        }
        ListNode reversed = reverseList(leftNode);
        leftPre.next = reversed;
        leftNode.next = rightNext;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 一次遍历
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode solution2(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
