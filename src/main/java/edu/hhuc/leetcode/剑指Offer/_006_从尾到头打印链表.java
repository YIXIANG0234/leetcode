package edu.hhuc.leetcode.剑指Offer;

import edu.hhuc.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @ClassName _006_从尾到头打印链表
 * @description:
 * @author: gaoya
 * @create: 2022-12-12 21:33
 * @Version 1.0
 */
public class _006_从尾到头打印链表 {
    public int[] reversePrint1(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int[] arr = new int[nums.size()];
        for (int i = nums.size() - 1; i >= 0; i--) {
            arr[nums.size() - 1 - i] = nums.get(i);
        }
        return arr;
    }

    public int[] reversePrint2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        recursive(head, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void recursive(ListNode head, List<Integer> arr) {
        if (head == null){
            return;
        }
        recursive(head.next, arr);
        arr.add(head.val);
    }
}
