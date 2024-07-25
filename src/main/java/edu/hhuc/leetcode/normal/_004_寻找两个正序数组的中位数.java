package edu.hhuc.leetcode.normal;

import java.util.Arrays;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/1 17:20:05
 */
public class _004_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        _004_寻找两个正序数组的中位数 instance = new _004_寻找两个正序数组的中位数();
        int[] nums1 = {1, 3, 4, 7, 9};
        int[] nums2 = {2, 5, 6, 8};
        System.out.println(instance.solution2(nums1, nums2));
    }

    /**
     * 先合并为一个有序数组，然后求中位数
     * 时间复杂度：O(max(m,n))
     * 空间复杂度：O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double solution1(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] nums = new int[n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                nums[index] = nums1[i];
                i++;
            } else {
                nums[index] = nums2[j];
                j++;
            }
            index++;
        }
        while (i < nums1.length) {
            nums[index] = nums1[i];
            index++;
            i++;
        }
        while (j < nums2.length) {
            nums[index] = nums2[j];
            index++;
            j++;
        }
        System.out.println(Arrays.toString(nums));
        if (n % 2 == 0) {
            return (nums[n / 2 - 1] + nums[n / 2]) / 2.0;
        }
        return nums[n / 2];
    }

    public double solution2(int[] nums1, int[] nums2) {
        int mid = (nums1.length + nums2.length) / 2;
        int i = 0;
        int j = 0;
        int prev = 0;
        int current = 0;
        int count = 0;
        while (i < nums1.length && j < nums2.length) {
            if (count == mid) {
                return (prev + current) / 2.0;
            }
            if (nums1[i] <= nums2[j]) {
                i++;
                prev = current;
                current = nums1[i];
                count++;
            } else {
                j++;
                prev = current;
                current = nums2[j];
                count++;
            }
        }
        while (i < nums1.length) {
            if (count == mid) {
                return (prev + current) / 2.0;
            }
            i++;
            prev = current;
            current = nums1[i];
            count++;
        }
        while (j < nums2.length) {
            if (count == mid) {
                return (prev + current) / 2.0;
            }
            j++;
            prev = current;
            current = nums2[j];
            count++;
        }
        return 0;
    }
}
