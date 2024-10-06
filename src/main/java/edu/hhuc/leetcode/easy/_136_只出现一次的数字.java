package edu.hhuc.leetcode.easy;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/16 13:59:08
 */
public class _136_只出现一次的数字 {
    public static void main(String[] args) {
        _136_只出现一次的数字 instance = new _136_只出现一次的数字();
        int[] nums = {2, 2, 1};
        // int[] nums = {4, 1, 2, 1, 2};
        System.out.println(instance.solution1(nums));
    }

    /**
     * 异或运算的性质：
     * a^a = 0
     * a^0 = a
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
