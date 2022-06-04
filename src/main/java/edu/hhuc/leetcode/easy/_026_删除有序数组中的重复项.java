package edu.hhuc.leetcode.easy;

public class _026_删除有序数组中的重复项 {

    public int solution1(int[] nums) {
        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                nums[index] = nums[i];
                index++;
                count++;
            }
        }
        return count;
    }
}
