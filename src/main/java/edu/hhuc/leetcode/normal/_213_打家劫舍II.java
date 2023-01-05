package edu.hhuc.leetcode.normal;

public class _213_打家劫舍II {
    public static void main(String[] args) {
        _213_打家劫舍II instance = new _213_打家劫舍II();
        System.out.println(instance.solution1(new int[]{200, 3, 140, 20, 10}));
    }

    /**
     * 其实只要判断是否偷了第一间房子与否，来判断是否要偷最后一间房子即可，但是貌似无法判断出是否会偷第一间房子
     * 因此，选择从[0,n-1]和[1,n]分别偷一次，然后取较大者
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = 0;
        int second = 0;

        for (int i = start; i <= end; i++) {
            int three = Math.max(first + nums[i], second);
            first = second;
            second = three;
        }
        return second;
    }
}
