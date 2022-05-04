package edu.hhuc.leetcode.easy;

public class _922_按奇偶排序数组II {
    public static void main(String[] args) {
        _922_按奇偶排序数组II instance = new _922_按奇偶排序数组II();
        int[] nums = {3,4};
        instance.solution1(nums);
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int[] solution1(int[] nums) {
        int left = 0;
        int right = 0;
        while (left < nums.length) {
            if (left % 2 == nums[left] % 2) {
                left++;
                right++;
                continue;
            }
            while (right < nums.length && left % 2 != nums[right] % 2) {
                right++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
        }
        return nums;
    }
}
