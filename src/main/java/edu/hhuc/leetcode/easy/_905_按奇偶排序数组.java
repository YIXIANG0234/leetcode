package edu.hhuc.leetcode.easy;

public class _905_按奇偶排序数组 {
    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int[] solution1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1) {
                while (left < right) {
                    if (nums[right] % 2 == 0) {
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        break;
                    }
                    right--;
                }
            } else {
                left++;
            }
        }
        return nums;
    }

    /**
     * 双指针的另一种写法
     * @param nums
     * @return
     */
    public int[] solution2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0) {
                left++;
            }
            if (nums[right] % 2 == 1) {
                right--;
            }
        }
        return nums;
    }
}
