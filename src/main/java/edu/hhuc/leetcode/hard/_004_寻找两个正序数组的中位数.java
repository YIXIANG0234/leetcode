package edu.hhuc.leetcode.hard;

public class _004_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        _004_寻找两个正序数组的中位数 instance = new _004_寻找两个正序数组的中位数();
        int[] nums1 = {2, 3};
        int[] nums2 = {2, 3};
        System.out.println(instance.solution1(nums1, nums2));
    }

    /**
     * 求取nums1和nums2中间的数
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public double solution1(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int totalLength = nums1.length + nums2.length;
        int prev1 = 0;
        int prev2 = 0;
        int count = 0;
        int midIndex = totalLength / 2 + 1;
        while (i < nums1.length || j < nums2.length) {
            count++;
            if (i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])) {
                if (count <= midIndex) {
                    prev1 = prev2;
                    prev2 = nums1[i];
                }
                i++;
            } else {
                if (count <= midIndex) {
                    prev1 = prev2;
                    prev2 = nums2[j];
                }
                j++;
            }
        }
        return totalLength % 2 == 0 ? (prev1 + prev2) / 2.0 : prev2;
    }

    /**
     * 采用数组合并的方式
     * 时间复杂度O(m+n)
     * 空间复杂度O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double solution2(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] merged = new int[len];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])) {
                merged[index] = nums1[i];
                i++;
            } else {
                merged[index] = nums2[j];
                j++;
            }
            index++;
        }
        int mid = len / 2;
        return len % 2 == 0 ? (merged[mid - 1] + merged[mid]) / 2.0 : merged[mid];
    }
    // TODO: 2024/10/3 以上都是时间复杂度为O(m+n)的，题目要求O(log(m+n))的解法
}
