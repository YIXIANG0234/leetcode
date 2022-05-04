package edu.hhuc.leetcode.easy;

public class _088_合并两个有序数组 {
    public static void main(String[] args) {
        _088_合并两个有序数组 instance = new _088_合并两个有序数组();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        instance.solution1(nums1, 3, nums2, 3);
    }

    public void solution1(int[] nums1, int m, int[] nums2, int n) {
        int index2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            int index1 = i;
            // 如果nums2数组的元素更小，则将nums1数组元素后移，然后将nums2的元素插入
            if (index2 < n && nums1[index1] > nums2[index2]) {
                for (int j = m + index2 - 1; j >= index1; j--) {
                    nums1[j + 1] = nums1[j];
                }
                nums1[index1] = nums2[index2];
                index2++;
            }
        }

        // 如果nums2的元素没有处理完，则追加在nums1的末尾
        while (index2 < n) {
            nums1[m + index2] = nums2[index2];
            index2++;
        }
    }

    /**
     * 品论区解法，代码超简洁
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void solution2(int[] nums1, int m, int[] nums2, int n) {
        int tail = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p2 >= 0) {
            if (p1 < 0 || nums1[p1] <= nums2[p2]) {
                nums1[tail--] = nums2[p2--];
            } else {
                nums1[tail--] = nums1[p1--];
            }
        }
    }
}
