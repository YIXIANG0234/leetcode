package edu.hhuc.leetcode.normal;

import java.util.Arrays;
import java.util.PriorityQueue;

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
        // int[] nums = {3, 2, 1, 5, 6, 4};
        // int k = 2;

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(instance.solution2(nums, k));
    }

    public int solution1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int solution2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            count++;
            if (count > k) {
                System.out.println(queue.poll());
            }
        }
        return queue.peek();
    }
}
