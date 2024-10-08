package edu.hhuc.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _239_滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        _239_滑动窗口最大值 instance = new _239_滑动窗口最大值();
        int[] result = instance.solution2(nums, k);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] solution1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            result[i - k + 1] = nums[i];
            for (int j = i - k + 1; j <= i; j++) {
                result[i - k + 1] = Math.max(result[i - k + 1], nums[j]);
            }
        }
        return result;
    }


    /**
     * 使用优先队列，每次判断队头元素是否在窗口内，不在则删除，否则加入结果集合
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] solution2(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.add(new int[]{nums[i], i});
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = maxHeap.peek()[0];
        for (int i = k; i < nums.length; i++) {
            maxHeap.add(new int[]{nums[i], i});
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            result[i - k + 1] = maxHeap.peek()[0];
        }
        return result;
    }
}
