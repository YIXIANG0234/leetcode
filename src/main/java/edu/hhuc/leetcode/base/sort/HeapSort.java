package edu.hhuc.leetcode.base.sort;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/5/14 20:52:36
 */
public class HeapSort implements Sort {

    /**
     * 堆排序分两步
     * 1.建堆，使用自上而下堆方式建一个最大堆
     * 2.调整堆，每次调整都将目前最大堆元素调整到末尾，调整结束后将得到一个升序堆序列
     * @param arr
     */
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
