package edu.hhuc.leetcode.easy;

import java.util.*;
import java.util.stream.IntStream;

public class _350_两个数组的交集II {
    /**
     * 349的排序解法可以直接用，去掉distinct即可
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] solution1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        List<Integer> result = new ArrayList<>();
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                result.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = count(nums1);
        Map<Integer, Integer> map2 = count(nums2);
        List<Integer> result = new ArrayList<>();
        map1.forEach((key, value)->{
            if (map2.containsKey(key)) {
                int times = Math.min(value, map2.get(key));
                IntStream.generate(()-> key).limit(times).forEach(result::add);
            }
        });
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public Map<Integer, Integer> count(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }
}
