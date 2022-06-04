package edu.hhuc.leetcode.hard;

public class _004_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        _004_寻找两个正序数组的中位数 instance = new _004_寻找两个正序数组的中位数();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(instance.solution1(nums1, nums2));
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

}
