package edu.hhuc.leetcode.normal;

import java.util.Arrays;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/21 20:32:04
 */
public class _238_除自身以外数组的乘积 {

    public static void main(String[] args) {
        _238_除自身以外数组的乘积 instance = new _238_除自身以外数组的乘积();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(instance.solution3(nums)));
    }

    public int[] solution1(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        int result = 1;
        for (int i = 0; i < len; i++) {
            result = result * nums[i];
        }
        for (int i = 0; i < len; i++) {
            answer[i] = result / nums[i];
        }
        return answer;
    }

    public int[] solution2(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        Arrays.fill(answer, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    answer[i] = answer[i] * nums[j];
                }
            }
        }
        return answer;
    }

    public int[] solution3(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        // prefix[i]和suffix[i]分别表示在位置i处，除了i的前缀乘积和后缀乘积
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                prefix[i] = 1;
            } else {
                prefix[i] = prefix[i - 1] * nums[i - 1];
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                suffix[i] = 1;
            } else {
                suffix[i] = suffix[i + 1] * nums[i + 1];
            }
        }
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = suffix[i] * prefix[i];
        }
        return answer;
    }
}
