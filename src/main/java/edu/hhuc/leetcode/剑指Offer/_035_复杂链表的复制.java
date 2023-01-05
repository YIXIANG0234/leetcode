package edu.hhuc.leetcode.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @ClassName _035_复杂链表的复制
 * @description:
 * @author: gaoya
 * @create: 2022-12-12 22:09
 * @Version 1.0
 */
public class _035_复杂链表的复制 {
    private Map<Node, Node> cacheNodes = new HashMap<>();

    /**
     * 回溯算法
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cacheNodes.containsKey(head)) {
            Node newNode = new Node(head.val);
            cacheNodes.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return cacheNodes.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
