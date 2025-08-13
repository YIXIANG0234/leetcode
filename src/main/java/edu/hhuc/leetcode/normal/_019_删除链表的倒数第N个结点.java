package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

import java.util.Stack;

public class _019_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        _019_删除链表的倒数第N个结点 instance = new _019_删除链表的倒数第N个结点();
        ListNode head = ListNodeUtils.randomList(10);
        ListNodeUtils.beautifulFormat(head);
        ListNode result = instance.solution1(head, 3);
        ListNodeUtils.beautifulFormat(result);
    }

    /**
     * 删除倒数第n个节点，可以转换为删除正数第m个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode solution1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        int count = 0;
        ListNode node = dummy;
        // 一次遍历，计算链表长度
        while (node != null) {
            count++;
            node = node.next;
        }
        int m = count - n - 1;
        node = dummy;
        for (int i = 0; i < m; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
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
        ListNode dummy = new ListNode(-1, head);
        ListNode node = dummy;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        // 弹出倒数的n个元素
        while (n > 0) {
            stack.pop();
            n--;
        }
        // 删除倒数第n个元素
        ListNode top = stack.peek();
        top.next = top.next.next;
        return dummy.next;
    }

    /**
     * 双指针，假设链表长度为m+n,m为正数的m个节点，n为倒数的n个节点
     * first指针先走n个节点，然后second指针加入，first和second一起往后走，等到first走到链表结尾的时候有
     * first走的节点数为m+n,因为first比second领先n-1个节点，所以second走的节点数为(m+n)-(n-1)=m+1,此时
     * second正好位于倒数第n个节点处，即删除的节点处
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode solution3(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}