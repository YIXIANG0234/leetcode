package edu.hhuc.leetcode.base.sort;

import java.util.Arrays;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 10:24:32
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = Sort.randomArray(20, 100);
        // arr = new int[]{33, 98, 29, 92, 85, 1, 66, 28, 43, 58};
        int[] origin = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println(Sort.sorted(arr) ? "该数组有序" : "该数组处于非排序状态");
        Sort sort = new RadixSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Sort.sorted(arr) ? "该数组有序" : "该数组处于非排序状态");
        System.out.println(Sort.validateArray(origin, arr) ? "数组数据正确" : "数组数据有误");
    }
}
