package edu.hhuc.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _496_下一个更大元素I {
    public int[] solution1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1];
        Arrays.fill(result, -1);
        // 遍历nums1数组，依次处理每个元素
        for (int i = 0; i < length1; i++) {
            int number1 = nums1[i];
            int index = -1;
            // 在nums2中找到nums1[i]对应的元素的下标
            for (int j = 0; j < length2; j++) {
                if (nums2[j] == number1) {
                    index = j;
                    break;
                }
            }
            if (index != -1) {
                // 找到nums1[i]在nums2中对应元素的下一个更大的值
                for (int j = index; j < length2; j++) {
                    if (nums2[j] > nums2[index]) {
                        result[i] = nums2[j];
                        break;
                    }
                }
            }
        }
        return result;
    }

    public int[] solution2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int length = nums1.length;
        int[] result = new int[length];
        for (int x : nums2) {
            while (!stack.isEmpty() && x > stack.peek()) {
                map.put(stack.pop(), x);
            }
            stack.push(x);
        }
        for (int i = 0; i < length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
