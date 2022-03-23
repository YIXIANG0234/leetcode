package edu.hhuc.leetcode.easy;

import java.util.PriorityQueue;

public class _703_数据流中的第K大元素 {
    private int k;
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public _703_数据流中的第K大元素(int k, int[] nums) {
        this.k = k;
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        _703_数据流中的第K大元素 instance = new _703_数据流中的第K大元素(3, new int[]{4, 5, 8, 2});

        System.out.println(instance.add(3));
        System.out.println(instance.add(5));
        System.out.println(instance.add(10));
        System.out.println(instance.add(9));
        System.out.println(instance.add(4));
    }
}
