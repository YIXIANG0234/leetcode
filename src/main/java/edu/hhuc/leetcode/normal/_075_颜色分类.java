package edu.hhuc.leetcode.normal;

/**
 * @program: leetcode
 * @ClassName _075_颜色分类
 * @description:
 * @author: gaoya
 * @create: 2023-02-23 21:39
 * @Version 1.0
 */
public class _075_颜色分类 {
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
}
