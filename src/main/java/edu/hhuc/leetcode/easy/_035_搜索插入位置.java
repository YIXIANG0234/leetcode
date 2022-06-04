package edu.hhuc.leetcode.easy;

public class _035_搜索插入位置 {
    public static void main(String[] args) {
        _035_搜索插入位置 instance = new _035_搜索插入位置();
        int[] nums = {1, 3, 5, 6};
        System.out.println(instance.solution1(nums, 7));
    }

    public int solution1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
