package edu.hhuc.leetcode.normal;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/23 17:35:40
 */
public class _494_目标和 {
    public static void main(String[] args) {
        _494_目标和 instance = new _494_目标和();
        // int[] nums = {1, 1, 1, 1, 1};
        // int target = 3;
        int[] nums = {1, 1, 1, 1};
        int target = 2;
        System.out.println(instance.solution1(nums, target));
    }

    public int solution1(int[] nums, int target) {
        return backtrace(nums, 0, target, 0);
    }


    private int backtrace(int[] nums, int index, int target, int sum) {
        if (index == nums.length) {
            return target == sum ? 1 : 0;
        }
        // 枚举当前位置分别是-和+的情况
        return backtrace(nums, index + 1, target, sum - nums[index]) + backtrace(nums, index + 1, target, sum + nums[index]);
    }

    // 仅为了调试
    private int backtrace(int[] nums, int index, int target, int sum, StringBuilder sb) {
        if (index == nums.length) {
            if (sum == target) {
                System.out.println(sb.toString());
            }
            return target == sum ? 1 : 0;
        }
        sb.append("-").append(nums[index]);
        int a = backtrace(nums, index + 1, target, sum - nums[index], sb);
        sb.delete(sb.length() - 2, sb.length());

        sb.append("+").append(nums[index]);
        int b = backtrace(nums, index + 1, target, sum + nums[index], sb);
        sb.delete(sb.length() - 2, sb.length());
        return a + b;
    }
}
