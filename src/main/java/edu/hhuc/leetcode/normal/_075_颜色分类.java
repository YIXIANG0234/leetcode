package edu.hhuc.leetcode.normal;

import java.util.Arrays;

/**
 * @program: leetcode
 * @ClassName _075_颜色分类
 * @description:
 * @author: gaoya
 * @create: 2023-02-23 21:39
 * @Version 1.0
 */
public class _075_颜色分类 {
    public static void main(String[] args) {
        _075_颜色分类 instance = new _075_颜色分类();
        int[] nums = {1, 0, 1, 2, 0, 1, 0, 0, 1};
        // int[] nums = {2, 0, 0, 0, 2, 2};
        instance.solution4(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 直接使用排序算法，冒泡排序
     *
     * @param nums
     */
    public void solution1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 单指针，进行两次遍历，第一次遍历将所有的0放在最前面，第二次遍历，将所有的1放在0后面
     *
     * @param nums
     */
    public void solution2(int[] nums) {
        int index = 0;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
    }

    /**
     * 双指针法，在一次遍历中，分别把0和2放在数组的头部和尾部
     *
     * @param nums
     */
    public void solution3(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        for (int i = head; i <= tail; i++) {
            while (tail >= i && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[tail];
                nums[tail] = temp;
                tail--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[head];
                nums[head] = temp;
                head++;
            }
        }
    }

    /**
     * 双指针，秒啊（自己想的）
     * @param nums
     */
    public void solution4(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            } else if (nums[i] == 2) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
            }
        }
    }

    /**
     * 插入排序
     * @param nums
     */
    public void solution5(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int value = nums[i];
            for (; j >= 0; j--) {
                if (value < nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
    }
}
