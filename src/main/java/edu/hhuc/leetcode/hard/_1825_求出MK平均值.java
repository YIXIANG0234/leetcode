package edu.hhuc.leetcode.hard;

import java.util.Arrays;

/**
 * @program: leetcode
 * @ClassName _1825_求出MK平均值
 * @description:
 * @author: gaoya
 * @create: 2023-01-18 11:23
 * @Version 1.0
 */
public class _1825_求出MK平均值 {
    private int m;
    private int k;
    private int[] nums;
    private int currentIndex = 0;

    public _1825_求出MK平均值(int m, int k) {
        this.m = m;
        this.k = k;
        this.nums = new int[m];
    }

    public void addElement(int num) {
        nums[currentIndex % m] = num;
        currentIndex++;
    }

    public int calculateMKAverage() {
        if (currentIndex < m) {
            return -1;
        }
        int[] processing = Arrays.copyOf(this.nums, m);
        Arrays.sort(processing);
        int sum = 0;
        for (int i = k; i < m - k; i++) {
            sum += processing[i];
        }
        return Math.floorDiv(sum, m - 2 * k);
    }

    public static void main(String[] args) {
        _1825_求出MK平均值 instance = new _1825_求出MK平均值(3, 1);
        instance.addElement(3);        // 当前元素为 [3]
        instance.addElement(1);        // 当前元素为 [3,1]
        System.out.println(instance.calculateMKAverage()); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        instance.addElement(10);       // 当前元素为 [3,1,10]
        System.out.println(instance.calculateMKAverage()); // 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        instance.addElement(5);        // 当前元素为 [3,1,10,5]
        instance.addElement(5);        // 当前元素为 [3,1,10,5,5]
        instance.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
        System.out.println(instance.calculateMKAverage());
    }
}
