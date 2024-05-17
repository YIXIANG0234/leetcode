package edu.hhuc.leetcode.base.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 20:57:53
 */
public class BucketSort implements Sort {
    @Override
    public void sort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        // 桶的个数
        int bucketNum = (max - min) / arr.length + 1;
        // 初始化桶
        List<List<Integer>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - min) / arr.length;
            buckets.get(bucketIndex).add(arr[i]);
        }
        buckets.forEach(x -> Collections.sort(x));
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            List<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                arr[index++] = bucket.get(j);
            }
        }
    }
}
