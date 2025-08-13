package edu.hhuc.leetcode.others;

import java.util.Arrays;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/10/10 15:58:55
 */
public class 百度_奇偶数排序 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 8, 9, 1, 2, 5};
        百度_奇偶数排序 instance = new 百度_奇偶数排序();
        instance.solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void solution(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (arr[left] % 2 == 1) {
                swap(arr, left, right);
                right--;
            } else {
                left++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


