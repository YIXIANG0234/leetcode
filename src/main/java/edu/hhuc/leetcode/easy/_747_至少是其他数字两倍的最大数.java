package edu.hhuc.leetcode.easy;

public class _747_至少是其他数字两倍的最大数 {
    public static void main(String[] args) {
        _747_至少是其他数字两倍的最大数 instance = new _747_至少是其他数字两倍的最大数();
        System.out.println(instance.solution1(new int[]{1,0}));
    }
    /**
     * 只要找出最大值和次大值，判断最大值是否是次大值的两倍即可
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int maxIndex = -1;
        // 最大值
        int max1 = Integer.MIN_VALUE;
        // 次大值
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max1) {
                max2 = max1;
                max1 = nums[i];
                maxIndex = i;
            } else if (nums[i] >= max2) {
                max2 = nums[i];
            }
        }
        if (max1 >= max2 * 2) {
            return maxIndex;
        }
        return -1;
    }
}
