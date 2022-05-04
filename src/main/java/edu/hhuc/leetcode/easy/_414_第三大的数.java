package edu.hhuc.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _414_第三大的数 {

    public static void main(String[] args) {
        _414_第三大的数 instance = new _414_第三大的数();
        instance.solution3(new int[]{5, 2, 4, 1, 3, 6, 0});
    }

    /**
     * 优先队列
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer num : nums) {
            if (!queue.contains(num)) {
                queue.offer(num);
            }
        }
        if (queue.size() < 3) {
            return queue.peek();
        }
        int index = 0;
        int result = 0;
        while (index < 3) {
            result = queue.poll();
            index++;
        }
        return result;
    }

    /**
     * 排序法
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 3) {
            return nums[length - 1];
        }
        int count = 1;
        int prev = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] != prev) {
                prev = nums[i];
                count++;
            }
            if (count == 3) {
                return prev;
            }
        }
        return nums[length - 1];
    }

    /**
     * 一次遍历，使用3个变量分别记录最大值，次大值和第三大的值
     *
     * @param nums
     * @return
     */
    public int solution3(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= first) {
                if (nums[i] == first) {
                    continue;
                }
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] >= second) {
                if (nums[i] == second) {
                    continue;
                }
                third = second;
                second = nums[i];
            } else if (nums[i] >= third) {
                if (nums[i] == third) {
                    continue;
                }
                third = nums[i];
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
