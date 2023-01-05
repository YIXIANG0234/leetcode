package edu.hhuc.leetcode.others;

import java.util.ArrayList;
import java.util.List;

public class 会小二_整数n的连续和 {
    public static void main(String[] args) {
        会小二_整数n的连续和 instance = new 会小二_整数n的连续和();
        for (int i = 2; i < 20; i++) {
            String format = String.format("整数%d的连续和为：%s", i, instance.solution1(i).toString());
            System.out.println(format);
        }
    }

    /**
     * 线上机器 CPU 使用量占比100%、Load飙高的原因可能有哪些
     * Mysql 数据表有大量的数据，现要增加字段name，该如何操作。
     * <p>
     * 输入一个正数n，输出所有和为n 连续正数序列。例如输入15，输出为：{1，2，3，4，5}、{4，5，6}、{7，8}。（可用JAVA 或伪代码 或思路）
     *
     * @param n
     * @return
     */
    public List<List<Integer>> solution1(int n) {
        List<List<Integer>> result = new ArrayList<>();
        int diff = 0;
        for (int i = 2; i < n; i++) {
            diff = diff + (i - 1);
            for (int j = 1; j < n; j++) {
                int sum = i * j + diff;
                if (sum == n) {
                    int count = i;
                    int base = j;
                    List<Integer> list = new ArrayList<>();
                    while (count > 0) {
                        list.add(base);
                        base++;
                        count--;
                    }
                    result.add(list);
                }
            }
        }
        return result;
    }
}
