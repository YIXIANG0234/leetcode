package edu.hhuc.leetcode.base.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 20:59:04
 */
public class RadixSort implements Sort {
    @Override
    public void sort(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        // 10个桶，0-9
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        int exp = 1;
        // 循环处理不同的位，从各位开始
        while (max / exp > 0) {
            for (int i = 0; i < arr.length; i++) {
                // 计算当前需要处理的最低位
                int bucketIndex = (arr[i] / exp) % 10;
                buckets.get(bucketIndex).add(arr[i]);
            }
            // 对每个桶中的元素排序
            buckets.forEach(Collections::sort);
            int index = 0;
            // 将当前桶中的元素复制到原数组中，准备进行下一轮排序
            for (int i = 0; i < buckets.size(); i++) {
                List<Integer> bucket = buckets.get(i);
                for (int j = 0; j < bucket.size(); j++) {
                    arr[index++] = bucket.get(j);
                }
                bucket.clear();
            }
            // 处理下一位
            exp = exp * 10;
        }
    }
}
