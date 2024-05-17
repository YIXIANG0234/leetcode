package edu.hhuc.leetcode.base.sort;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 20:56:56
 */
public class CountSort implements Sort {
    @Override
    public void sort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        // 找待排序数组的范围
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 计数数组
        int countSize = max - min + 1;
        int[] count = new int[countSize];
        // 记录每个值出现的次数
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - min;
            count[index]++;
        }
        int i = 0;
        int index = 0;
        // 将计数数组的值还原到目标数组中
        while (i < countSize) {
            if (count[i] == 0) {
                i++;
                continue;
            }
            arr[index] = i + min;
            count[i]--;
            index++;
        }
    }
}
