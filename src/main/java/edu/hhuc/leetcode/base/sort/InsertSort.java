package edu.hhuc.leetcode.base.sort;

/**
 * 排序算法：插入排序
 * 是否稳定排序：稳定排序
 * 是否原地排序：原地排序
 * 最好时间复杂度：O(n)
 * 最坏时间复杂度：O(n^2)
 * 平均时间复杂度：O(n^2)
 *
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 10:46:05
 */
public class InsertSort implements Sort {
    // @Override
    // public void sort(int[] arr) {
    //     int length = arr.length;
    //     // 遍历无序的部分
    //     for (int i = 1; i < length; i++) {
    //         int j = i - 1;
    //         int current = arr[i];
    //         // 在有序的部分找到合适的位置插入
    //         for (; j >= 0; j--) {
    //             if (current < arr[j]) {
    //                 arr[j + 1] = arr[j];
    //             } else {
    //                 break;
    //             }
    //         }
    //         arr[j + 1] = current;
    //     }
    // }


    /**
     * 两种写法都可以
     *
     * @param arr 待排序数组
     */
    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length - 1; i++) {
            int j = i - 1;
            int value = arr[i];
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }
}
