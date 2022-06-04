package edu.hhuc.leetcode.hard;

import java.util.Arrays;

public class _041_缺失的第一个正数 {
    public static void main(String[] args) {
        _041_缺失的第一个正数 instance = new _041_缺失的第一个正数();
        System.out.println(instance.solution3(new int[]{3, 4, -1, 1}));
    }

    /**
     * 排序后查找，时间复杂度不满足要求
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        Arrays.sort(nums);
        int minNum = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= 0) {
                continue;
            }
            if (num == minNum) {
                minNum++;
                continue;
            } else if (num < minNum) {
                continue;
            } else {
                return minNum;
            }
        }
        return minNum;
    }

    /**
     * 哈希表
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                int index = num - 1;
                nums[index] = -Math.abs(nums[index]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /**
     * 交换元素到正确的位置
     *
     * @param nums
     * @return
     */
    public int solution3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
