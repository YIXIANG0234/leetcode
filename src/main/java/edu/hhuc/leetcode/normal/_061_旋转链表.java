package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.Objects;
import java.util.Stack;

/**
 * @program: leetcode
 * @ClassName _061_旋转链表
 * @description:
 * @author: gaoya
 * @create: 2022-12-02 13:49
 * @Version 1.0
 */
public class _061_旋转链表 {
    public static void main(String[] args) {
        ListNode head = ListNode.buildLinkedList(1, 2, 3, 4, 5);
        _061_旋转链表 instance = new _061_旋转链表();
        ListNode.beautifulFormat(instance.solution2(head, 3));
    }

    /**
     * 使用栈模拟节点移动的过程
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode solution1(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        int length = 0;
        Stack<ListNode> stack = new Stack();
        ListNode node = head;
        while (node != null) {
            length++;
            stack.push(node);
            node = node.next;
        }
        k = k % length;
        ListNode midNode = stack.peek();
        ListNode newHead = null;
        while (!stack.isEmpty()) {
            newHead = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
        }
        if (!stack.isEmpty()) {
            stack.peek().next = null;
        }
        ListNode last = null;
        while (!stack.isEmpty()) {
            last = stack.pop();
        }
        midNode.next = last;
        return newHead;
    }

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode solution2(ListNode head, int k) {
        if (Objects.isNull(head) || k <= 0) {
            return head;
        }
        int count = 0;
        ListNode node = head;
        ListNode tail = null;
        while (node != null) {
            count++;
            tail = node;
            node = node.next;
        }
        // 闭合链表，成为环
        tail.next = head;
        // 需要找到正数第k个节点
        k = count - k % count;

        // 开始计算需要断开链接的节点位置
        int index = 1;
        while (index != k) {
            head = head.next;
            index++;
        }
        // 断开链接，并记录新的头节点
        ListNode result = head.next;
        head.next = null;
        return result;
    }
}
