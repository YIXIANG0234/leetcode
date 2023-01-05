package edu.hhuc.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class _2073_买票需要的时间 {
    public static void main(String[] args) {
        _2073_买票需要的时间 instance = new _2073_买票需要的时间();
        int[] nums = {5, 1, 1, 1};
        System.out.println(instance.solution1(nums, 0));
    }

    /**
     * 使用队列模拟买票过程
     *
     * @param tickets
     * @param k
     * @return
     */
    public int solution1(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.offer(i);
        }
        int spendTime = 0;
        while (tickets[k] != 0) {
            int index = queue.poll();
            spendTime++;
            tickets[index] = tickets[index] - 1;
            if (tickets[index] != 0) {
                queue.offer(index);
            }
        }
        return spendTime;
    }

    /**
     * 官方答案，没有太懂
     *
     * @param tickets
     * @param k
     * @return
     */
    // todo
    public int solution2(int[] tickets, int k) {
        int spendTime = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                spendTime += Math.min(tickets[i], tickets[k]);
            } else {
                spendTime += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return spendTime;
    }
}
