package edu.hhuc.leetcode.normal;

public class _033_搜索旋转排序数组 {
    public static void main(String[] args) {
        _033_搜索旋转排序数组 instance = new _033_搜索旋转排序数组();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(instance.solution2(nums, 0));
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 虽然整体无序，但是局部是有序的，仍然可以使用二分法进行查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int solution2(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 左边部分有序
            if (nums[left] <= nums[mid]) {
                // 在左边找
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
