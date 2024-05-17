package edu.hhuc.leetcode.base.sort;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 20:52:36
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            adjustHeap(arr, i, 0);
        }
    }

    private void buildMaxHeap(int[] nums) {
        int mid = nums.length >> 1;
        // i = mid时，是堆的倒数第二层
        for (int i = mid; i >= 0; i--) {
            adjustHeap(nums, nums.length, i);
        }
    }

    private void adjustHeap(int[] nums, int size, int parent) {
        int left = (parent << 1) + 1;
        int right = (parent << 1) + 2;
        int largest = parent;
        if (left < size && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < size && nums[right] > nums[largest]) {
            largest = right;
        }
        if (parent != largest) {
            int temp = nums[parent];
            nums[parent] = nums[largest];
            nums[largest] = temp;
            adjustHeap(nums, size, largest);
        }
    }
}
