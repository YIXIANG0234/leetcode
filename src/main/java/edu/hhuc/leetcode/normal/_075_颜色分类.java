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
        int[] nums = {2, 0, 2, 1, 1, 0};
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
                    swap(nums, j, j + 1);
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
                swap(nums, i, index);
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, index);
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
                swap(nums, i, tail);
                tail--;
            }
            if (nums[i] == 0) {
                swap(nums, i, head);
                head++;
            }
        }
    }

    /**
     * 不同于solution3的双指针写法
     *
     * @param nums
     */
    public void solution4(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    /**
     * 刷三次数据，先将所有数据刷为2，然后将1和0的个数的数据刷为1，最后将0的个数的数据刷为0
     *
     * @param nums
     */
    public void solution5(int[] nums) {
        int n0 = 0;
        int n1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 每一个数都会被刷成2
            nums[i] = 2;
            // 0和1被刷为1
            if (num < 2) {
                nums[n1] = 1;
                n1++;
            }
            // 所有的0都刷为0
            if (num < 1) {
                nums[n0] = 0;
                n0++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
