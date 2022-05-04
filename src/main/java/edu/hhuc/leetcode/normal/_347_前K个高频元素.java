package edu.hhuc.leetcode.normal;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _347_前K个高频元素 {
    /**
     * 先统计，后排序
     * @param nums
     * @param k
     * @return
     */
    public int[] solution1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).mapToInt(Map.Entry::getKey).limit(k).toArray();
    }
}
