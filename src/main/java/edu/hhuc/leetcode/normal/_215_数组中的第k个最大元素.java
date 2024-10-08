package edu.hhuc.leetcode.normal;

import java.util.Arrays;
import java.util.PriorityQueue;

// TODO: 2024/10/8 后续补下小顶堆的实现
/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/19 15:57:14
 */
public class _215_数组中的第k个最大元素 {
    public static void main(String[] args) {
        _215_数组中的第k个最大元素 instance = new _215_数组中的第k个最大元素();

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(instance.solution1(nums, k));
    }

    public int solution1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int solution2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
