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
        System.out.println(Arrays.toString(instance.solution2(nums)));
    }

    public int[] solution1(int[] nums) {
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

    public int[] solution2(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        prefix[0] = 1;
        suffix[len - 1] = 1;
        // prefix[i]和suffix[i]分别表示在位置i处，除了i的前缀乘积和后缀乘积
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = suffix[i] * prefix[i];
        }
        return answer;
    }

    /**
     * 对solution2空间复杂度的优化，结果集result不算在空间复杂度内，可以利用result先计算前缀乘积
     * 然后倒着遍历，计算后缀乘积
     *
     * @param nums
     * @return
     */
    public int[] solution3(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        return result;
    }

    /**
     * 双指针解法，空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public int[] solution4(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int left = 0;
        int right = nums.length - 1;
        int preifx = 1;
        int suffix = 1;
        while (left < nums.length && right >= 0) {
            result[left] = result[left] * preifx;
            result[right] = result[right] * suffix;
            preifx = preifx * nums[left];
            suffix = suffix * nums[right];
            left++;
            right--;
        }
        return result;
    }
}
