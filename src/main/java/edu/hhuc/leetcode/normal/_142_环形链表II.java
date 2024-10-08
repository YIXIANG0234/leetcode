package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _142_环形链表II {

    public ListNode solution1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 快慢指针，当快慢指针相遇时，代表存在环，此时另外定义一个指针指向头节点，分别向后移动头节点和慢指针
     * 他们相遇的时候的节点，即为入环的节点
     *
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode p = head;
                while (p != slow) {
                    slow = slow.next;
                    p = p.next;
                }
                return p;
            }
        }
        return null;
    }
}
