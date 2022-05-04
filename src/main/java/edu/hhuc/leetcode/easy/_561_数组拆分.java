package edu.hhuc.leetcode.easy;

import java.util.Arrays;

public class _561_数组拆分 {
    /**
     * 将2n个元素进行从小到大排序，每相邻的两个元素组成一组，所有的min(a,b)组合的和最大
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
