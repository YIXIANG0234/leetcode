package edu.hhuc.leetcode.others;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.Objects;

/**
 * @program: leetcode
 * @ClassName 商汤_交换链表节点位置
 * @description: 给定一个单链表的头节点，输入左右两个下标left和right，交换两个下标处节点的位置
 * @author: gaoya
 * @create: 2022-11-17 10:37
 * @Version 1.0
 */
public class 商汤_交换链表节点位置 {
    public static void main(String[] args) {
        ListNode head = ListNode.buildLinkedList(1, 2, 3, 4, 5, 6);
        商汤_交换链表节点位置 instance = new 商汤_交换链表节点位置();
        ListNode.formatList(instance.solution(head, 1, 4));
    }

    /**
     * 给定1->2->3->4->5->6链表，要求交换给定的left和right处节点，并返回链表
     *
     * @return
     */
    public ListNode solution(ListNode head, int left, int right) {
        if (Objects.isNull(head) || left >= right) {
            return head;
        }
        // 构建虚拟节点
        head = new ListNode(Integer.MIN_VALUE, head);
        // 定义执行队首的之指针
        ListNode current = head;
        ListNode pre = head;
        int currentIndex = 0;
        ListNode leftPre = null;
        ListNode rightPre = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        while (Objects.nonNull(current)) {
            if (currentIndex == left) {
                leftNode = current;
                leftPre = pre;
            }
            if (currentIndex == right) {
                rightNode = current;
                rightPre = pre;
            }
            currentIndex++;
            pre = current;
            current = current.next;
        }
        if (Objects.isNull(leftPre) || Objects.isNull(rightPre)) {
            return head;
        }
        // 断开要处理的节点的链接
        leftPre.next = leftNode.next;
        rightPre.next = rightNode.next;

        // 相邻节点单独处理
        if (left + 1 == right) {
            leftPre.next = rightNode;
            rightPre.next = rightNode.next;
            rightNode.next = rightPre;
            return head.next;
        }
        rightNode.next = leftPre.next;
        leftPre.next = rightNode;

        leftNode.next = rightPre.next;
        rightPre.next = leftNode;

        return head.next;
    }
}
