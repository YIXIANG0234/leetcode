package edu.hhuc.leetcode.剑指Offer;

/**
 * @program: leetcode
 * @ClassName _053_0至n中缺失的数字
 * @description:
 * @author: gaoya
 * @create: 2022-12-12 23:26
 * @Version 1.0
 */
public class _053_0至n中缺失的数字 {
    public int missingNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 利用一个数异或它本身，结果为0，已经异或运算满足交换律和结合律求解
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i] ^ i;
        }
        return result ^ nums.length;
    }

    /**
     * 题目已告知，序列有序，使用二分查找
     *
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
