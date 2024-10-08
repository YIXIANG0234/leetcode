package edu.hhuc.leetcode.normal;

import edu.hhuc.leetcode.entity.ListNode;
import edu.hhuc.leetcode.entity.ListNodeUtils;

/**
 * @program: leetcode
 * @ClassName _086_分隔链表
 * @description:
 * @author: gaoya
 * @create: 2022-12-02 15:33
 * @Version 1.0
 */
public class _086_分隔链表 {
    public static void main(String[] args) {
        _086_分隔链表 instance = new _086_分隔链表();
        ListNode head = ListNodeUtils.buildLinkedList(1, 4, 3, 2, 5, 2);
        ListNodeUtils.beautifulFormat(instance.solution1(head, 3));
    }

    public ListNode solution1(ListNode head, int x) {
        ListNode dummy = new ListNode(-1, head);
        // 第一个大于等于x的节点，及其前继续节点
        ListNode partitionPre = dummy;
        ListNode partition = null;
        // 当前正在处理的节点和起前继节点
        ListNode current = head;
        ListNode currentPre = dummy;
        while (current != null) {
            if (current.val < x) {
                // 更新partitionPre，到目前为止还没找到比x大的值
                if (partition == null) {
                    partitionPre = current;
                } else {
                    currentPre.next = current.next;
                    partitionPre.next = current;
                    current.next = partition;
                    partitionPre = partitionPre.next;
                }
            } else {
                // 更新第一个大于等于x的节点，其他节点跳过
                if (partition == null) {
                    partition = current;
                }
            }
            currentPre = current;
            current = current.next;
        }
        return dummy.next;
    }
}
