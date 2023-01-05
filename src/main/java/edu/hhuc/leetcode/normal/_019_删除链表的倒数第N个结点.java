package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.Stack;

public class _019_删除链表的倒数第N个结点 {
    /**
     * 删除倒数第n个节点，可以转换为删除正数第m个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode solution1(ListNode head, int n) {
        int count = 0;
        ListNode node = head;
        // 一次遍历，计算链表长度
        while (node != null) {
            count++;
            node = node.next;
        }
        // 删除首节点
        if (count == n) {
            return head.next;
        }
        int m = count - n;
        node = head;
        // 跳过链表的前m个节点
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }

    /**
     * 使用栈
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode solution2(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        // 弹出倒数的n个元素
        while (n > 0) {
            stack.pop();
            n--;
        }
        // 如果栈空，则表示删除第一个元素
        if (stack.isEmpty()){
            return head.next;
        }
        // 删除倒数第n个元素
        ListNode top = stack.peek();
        top.next = top.next.next;
        return head;
    }

    /**
     * 双指针，假设链表长度为m+n,m为整数的m个节点，n为倒数的n个节点
     * first指针先走n个节点，然后second指针加入，first和second一起往后走，等到first走到链表结尾的时候有
     * first走的节点数为m+n,因为first比second领先n-1个节点，所以second走的节点数为(m+n)-(n-1)=m+1,此时
     * second正好位于倒数第n个节点处，即删除的节点处
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode solution3(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}