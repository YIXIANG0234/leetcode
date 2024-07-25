package edu.hhuc.leetcode.easy;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class _234_回文链表 {
    private ListNode prev;

    public static void main(String[] args) {
        ListNode head = ListNode.randomList(7);
        // ListNode head = ListNode.buildLinkedList(1, 2, 3, 4, 5, 4, 3, 2, 1);
        _234_回文链表 instance = new _234_回文链表();
        System.out.println(instance.solution1(head));
    }


    public boolean solution1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 递归正向，反向迭代
     *
     * @param head
     * @return
     */
    public boolean solution2(ListNode head) {
        prev = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (prev.val != currentNode.val) {
                return false;
            }
            prev = prev.next;
        }
        return true;
    }

    public boolean solution3(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            if (!Objects.equals(list.get(start), list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
