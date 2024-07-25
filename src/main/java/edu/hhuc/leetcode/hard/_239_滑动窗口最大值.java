package edu.hhuc.leetcode.hard;

import java.util.*;
import java.util.stream.Collectors;

public class _239_滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        _239_滑动窗口最大值 instance = new _239_滑动窗口最大值();
        int[] result = instance.solution4(nums, k);
        System.out.println(Arrays.toString(result));
    }


    /**
     * 最直接的想法，需要排序，会超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] solution1(int[] nums, int k) {
        int left = 0;
        int right = left + k - 1;
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        while (right < nums.length) {
            int[] range = Arrays.copyOfRange(nums, left, right + 1);
            result[index] = Collections.max(Arrays.stream(range).boxed().collect(Collectors.toList()));
            index++;
            left++;
            right++;
        }
        return result;
    }

    /**
     * 使用PriorityQueue大顶堆实现，PriorityQueue默认生成的是小顶堆，所以需要改变下比较器的逻辑，使之生成大顶堆
     * 本方法会超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] solution2(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int left = 0;
        int right = 0;
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        while (right < nums.length) {
            if (right - left <= k - 1) {
                maxHeap.add(nums[right]);
                if (right - left == k - 1) {
                    result[index] = maxHeap.peek();
                    index++;
                }
                right++;
            } else {
                maxHeap.remove(nums[left]);
                maxHeap.add(nums[right]);
                left++;
                right++;
                result[index] = maxHeap.peek();
                index++;
            }
        }
        return result;
    }


    /**
     * solution2的优化版本，不必要每次都从堆中删除元素，只有元素出了滑动窗口的左边界之后才从堆中删除元素，可以加速程序
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] solution3(int[] nums, int k) {
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

    /**
     * 暴力枚举
     * @param nums
     * @param k
     * @return
     */
    public int[] solution4(int[] nums, int k) {
        int len = nums.length;
        int[] answer = new int[len - k + 1];
        for (int i = k - 1; i < len; i++) {
            int max = nums[i];
            for (int j = i - k + 1; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }
            answer[i - k + 1] = max;
        }
        return answer;
    }
}
