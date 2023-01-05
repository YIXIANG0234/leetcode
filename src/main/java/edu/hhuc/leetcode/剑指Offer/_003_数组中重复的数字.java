package edu.hhuc.leetcode.剑指Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @ClassName _003_数组中重复的数字
 * @description:
 * @author: gaoya
 * @create: 2022-12-12 22:38
 * @Version 1.0
 */
public class _003_数组中重复的数字 {
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int index = 0;
        while (index<nums.length){
            if (nums[index] == index) {
                index++;
                continue;
            }
            if (nums[nums[index]] == nums[index]) {
                return nums[index];
            }
            int temp = nums[index];
            nums[index] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
