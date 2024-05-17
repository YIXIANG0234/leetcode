package edu.hhuc.leetcode.others;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述：
 * 疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。黑板上已经写了N个正整数，
 * 同学们需要给每个数分别上一种颜色。为了让黑板报既美观又有学习意义，老师要求同种颜色的所有数都可以被这种颜色中最小的那个数整除。
 * 现在请你帮帮小朋友们，算算最少需要多少种颜色才能给这N个数进行上色。
 *
 * 输入描述：
 * 第一行有一个正整数N，其中1<=N<=100。
 * 第二行有N个int型数（保证输入数据在[1,100]范围中），表示黑板上各个正整数的值。
 */
public class _001_华为od_正整数上色 {
    public static void main(String[] args) {
        _001_华为od_正整数上色 instance = new _001_华为od_正整数上色();
        int n = 10;
        int[] nums = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println(instance.solution1(n, nums));
    }

    public int solution1(int n, int[] nums) {
        Arrays.sort(nums);
        System.out.println("整数数组nums：");
        System.out.println(Arrays.toString(nums));
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (result.isEmpty()) {
                result.add(num);
                continue;
            }
            boolean flag = false;
            for (int digit : result) {
                if (num % digit == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result.add(num);
            }
        }
        System.out.println(result.stream().sorted(Integer::compareTo).collect(Collectors.toList()));
        return result.size();
    }
}
