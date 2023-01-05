package edu.hhuc.leetcode.normal;

public class _045_跳跃游戏II {
    public static void main(String[] args) {
        _045_跳跃游戏II instance = new _045_跳跃游戏II();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(instance.solution2(nums));
    }

    /**
     * 贪心算法，从后往前查找
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public int solution2(int[] nums) {
        int count = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            int maxPosition = 0;
            for (int i = start; i < end; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
            }
            start = end;
            end = maxPosition + 1;
            count++;
        }
        return count;
    }

}
