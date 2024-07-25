package edu.hhuc.leetcode.normal;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/23 14:53:26
 */
public class _416_分割等和子集 {
    public static void main(String[] args) {
        _416_分割等和子集 instance = new _416_分割等和子集();
        // int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 3, 5, 1};
        System.out.println(instance.solution1(nums));
    }

    /**
     * 回溯，分别判断当前元素加入集合a和集合b的情况
     * @param nums
     * @return
     */
    public boolean solution1(int[] nums) {
        return backtrace(nums, 0, 0, 0);
    }

    private boolean backtrace(int[] nums, int index, int sumA, int sumB) {
        if (index == nums.length) {
            return sumA == sumB;
        }
        return backtrace(nums, index + 1, sumA + nums[index], sumB) || backtrace(nums, index + 1, sumA, sumB + nums[index]);
    }
}
