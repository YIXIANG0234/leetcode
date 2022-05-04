package edu.hhuc.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _268_丢失的数字 {
    /**
     * hash表统计
     *
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // 处理丢失头部的情况
        if (nums[0] != 0) {
            return 0;
        }
        // 处理丢失 尾部的情况
        if (nums[n - 1] != n) {
            return n;
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }
        return -1;
    }

    /**
     * 也是排序法，但是官方的写法更简洁，solution2简直有点多此一举
     *
     * @param nums
     * @return
     */
    public int solution3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    /**
     * 位运算，一个是异或上它本身，结果为0
     *
     * @param nums
     * @return
     */
    public int solution4(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor = xor ^ i;
        }
        return xor;
    }

    /**
     * 求和算法
     *
     * @param nums
     * @return
     */
    public int solution5(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int sum = Arrays.stream(nums).sum();
        return total - sum;
    }

}
