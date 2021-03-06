package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _141_环形链表 {
    /**
     * 借助额外的内存空间判断环
     * @param head
     * @return
     */
    public boolean solution1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                return true;
            }
            list.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 自己的写法，和solution3相比，solution3更加简洁
     * @param head
     * @return
     */
    public boolean solution2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 慢指针，一次走一步
        ListNode node1 = head;
        // 快指针，一次走两步
        ListNode node2 = head.next;
        while (node1 != null && node2 != null) {
            if (node1 == node2) {
                return true;
            }
            node1 = node1.next;
            node2= node2.next;
            if (node2.next != null) {
                node2 = node2.next.next;
            }
        }
        return false;
    }

    /**
     * 更加简洁的写法
     * @param head
     * @return
     */
    public boolean solution3(ListNode head) {
        // 慢指针每次走1步
        ListNode slow = head;
        // 快指针每次走2步
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
