package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

import java.util.Arrays;

public class _725_分隔链表 {
    public static void main(String[] args) {
        _725_分隔链表 instance = new _725_分隔链表();
        ListNode head = ListNodeUtils.buildLinkedList(1, 2, 3);
        System.out.println(Arrays.toString(instance.solution1(head, 5)));

    }

    public ListNode[] solution1(ListNode head, int k) {
        int total = 0;
        ListNode node = head;
        while (node != null) {
            total++;
            node = node.next;
        }
        // 每段链表的长度
        int avg = total / k;
        // 多余的元素个数
        int rest = total % k;
        ListNode[] result = new ListNode[k];

        // 当前段链表的长度
        int length = avg;
        // 结果集的下标
        int index = 0;
        int count = 0;
        ListNode item = head;
        if (rest > 0) {
            rest--;
            length++;
        }
        while (head != null) {
            count++;
            ListNode prev = head;
            head = head.next;
            if (count == length) {
                prev.next = null;
                count = 0;
                length = avg;
                result[index] = item;
                item = head;
                index++;
                if (rest > 0) {
                    rest--;
                    length++;
                }
            }
        }
        return result;
    }
}
