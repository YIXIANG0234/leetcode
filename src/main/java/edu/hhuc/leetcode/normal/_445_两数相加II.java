package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

import java.util.Stack;

public class _445_两数相加II {
    public static void main(String[] args) {
        _445_两数相加II instance = new _445_两数相加II();
        ListNode l1 = ListNodeUtils.buildLinkedList(7, 2, 4, 3);
        ListNode l2 = ListNodeUtils.buildLinkedList(5, 6, 4);
        ListNodeUtils.printLinkedList(instance.solution1(l1, l2));
    }

    /**
     * 使用栈逆序计算各个位的值
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution1(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode newHead = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();

            int sum = node1.val + node2.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = newHead;
            newHead = node;
        }
        while (!stack1.isEmpty()) {
            ListNode top = stack1.pop();
            int sum = top.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = newHead;
            newHead = node;
        }

        while (!stack2.isEmpty()) {
            ListNode top = stack2.pop();
            int sum = top.val + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = newHead;
            newHead = node;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }
}
