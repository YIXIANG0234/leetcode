package edu.hhuc.leetcode.hard;

public class _004_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        _004_寻找两个正序数组的中位数 instance = new _004_寻找两个正序数组的中位数();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(instance.solution3(nums1, nums2));
    }

    public double solution1(int[] nums1, int[] nums2) {
        int numA = 0;
        int numB = 0;
        int index1 = 0;
        int index2 = 0;
        int currentIndex = 0;
        int maxLength = nums1.length + nums2.length;
        int midIndex = (maxLength % 2 == 0) ? maxLength / 2 : maxLength / 2 + 1;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                currentIndex++;
                if (currentIndex == midIndex) {
                    numA = nums1[index1];
                } else if ((maxLength % 2 == 0) && (currentIndex == maxLength / 2 + 1)) {
                    numB = nums1[index1];
                }
                index1++;
            } else {
                currentIndex++;
                if (currentIndex == midIndex) {
                    numA = nums2[index2];
                } else if ((maxLength % 2 == 0) && (currentIndex == maxLength / 2 + 1)) {
                    numB = nums2[index2];
                }
                index2++;
            }
        }
        while (index1 < nums1.length) {
            currentIndex++;
            if (currentIndex == midIndex) {
                numA = nums1[index1];
            } else if ((maxLength % 2 == 0) && (currentIndex == maxLength / 2 + 1)) {
                numB = nums1[index1];
            }
            index1++;
        }

        while (index2 < nums2.length) {
            currentIndex++;
            if (currentIndex == midIndex) {
                numA = nums2[index2];
            } else if ((maxLength % 2 == 0) && (currentIndex == maxLength / 2 + 1)) {
                numB = nums2[index2];
            }
            index2++;
        }
        return (maxLength % 2 == 0) ? (numA + numB) / 2.0 : numA;
    }

    /**
     * 采用数组合并的方式
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double solution2(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] merged = new int[len];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged[index] = nums1[i];
                i++;
            } else {
                merged[index] = nums2[j];
                j++;
            }
            index++;
        }
        while (i < nums1.length) {
            merged[index] = nums1[i];
            i++;
            index++;
        }
        while (j < nums2.length) {
            merged[index] = nums2[j];
            index++;
            j++;
        }
        int mid = len / 2;
        return len % 2 == 0 ? (merged[mid - 1] + merged[mid]) / 2.0 : merged[mid];
    }

    /**
     * 不需要合并数组，只需要找到两个数组中间的数即可
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double solution3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int prev = 0;
        int mid = 0;
        int count = 0;
        int aStart = 0;
        int bStart = 0;
        while (count <= len / 2) {
            prev = mid;
            if (aStart < m && (bStart >= n || nums1[aStart] <= nums2[bStart])) {
                mid = nums1[aStart];
                aStart++;
            } else {
                mid = nums2[bStart];
                bStart++;
            }
            count++;
        }
        return len % 2 == 0 ? (prev + mid) / 2.0 : mid;
    }

}
