package edu.hhuc.leetcode.easy;

import java.util.*;

public class _349_两个数组的交集 {
    /**
     * hash统计
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] solution1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        return Arrays.stream(nums2).filter(x -> set1.contains(x)).distinct().toArray();
    }

    /**
     * 排序+双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] solution2(int[] nums1, int[] nums2) {
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
        return result.stream().distinct().mapToInt(Integer::intValue).toArray();
    }
}
