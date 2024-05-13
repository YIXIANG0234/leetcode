package edu.hhuc.leetcode.normal;

/**
 * @program: leetcode
 * @ClassName _621_任务调度器
 * @description:
 * @author: gaoya
 * @create: 2023-03-09 15:05
 * @Version 1.0
 */
public class _621_任务调度器 {
    public static void main(String[] args) {
        _621_任务调度器 instance = new _621_任务调度器();
        System.out.println(instance.solution1(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
    }

    public int solution1(char[] tasks, int n) {
        int[] interval = new int[26];
        boolean[] flag = new boolean[tasks.length];
        int count = 0;
        int ans = 0;
        int index = 0;
        while (count != tasks.length) {
            // 表示任务处理过了,或者该任务的冷却时间还没到
            char currentTask = tasks[index];
            if (flag[index] || interval[currentTask - 'A'] != 0) {
                if (index < tasks.length - 1) {
                    index++;
                    continue;
                } else {
                    index = 0;
                }
            }
            // cpu执行时间+1
            ans++;
            // 更新任务的冷却时间
            for (int i = 0; i < interval.length; i++) {
                // 找到了当前任务的冷却时间，且已完成冷却，则执行任务（count++)，并重置冷却
                if (i == currentTask - 'A' && interval[currentTask - 'A'] == 0) {
                    flag[index] = true;
                    count++;
                    interval[currentTask - 'A'] = n;
                    index = 0;
                } else {
                    // 其他任务的冷却-1，但是不能小于0
                    interval[i] = Math.max(0, interval[i] - 1);
                }
            }
        }
        return ans;
    }
}
