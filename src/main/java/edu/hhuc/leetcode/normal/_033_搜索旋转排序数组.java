package edu.hhuc.leetcode.normal;

public class _033_搜索旋转排序数组 {
    public static void main(String[] args) {
        _033_搜索旋转排序数组 instance = new _033_搜索旋转排序数组();
        // int[] nums = {4, 5, 6, 7, 0, 1, 2};
        // int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums = {7, 8, 9, 0, 1, 2, 3, 4, 5, 6};
        System.out.println(instance.solution4(nums, 2));
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
     * 双指针遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public int solution2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (target == nums[left]) {
                return left;
            } else if (target == nums[right]) {
                return right;
            } else if (target < nums[left] && target > nums[right]) {
                return -1;
            } else if (target > nums[left]) {
                if ((left + 1) < nums.length && nums[left] > nums[left + 1]) {
                    return -1;
                }
                left++;
            } else {
                if ((right - 1) >= 0 && nums[right] < nums[right - 1]) {
                    return -1;
                }
                right--;
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
    public int solution3(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 左边部分有序
            if (nums[mid] >= nums[0]) {
                // 在左边找
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边部分有序
                if (nums[mid] < target && target <= nums[length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // {7, 8, 9, 0, 1, 2, 3, 4, 5, 6};
    public int solution4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[left]<=nums[right]) {
                if (target<nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
            if (nums[left]>nums[right]) {
                if (target<nums[right]) {

                }
            }

            else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
