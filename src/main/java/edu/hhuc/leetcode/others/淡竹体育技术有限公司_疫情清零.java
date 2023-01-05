package edu.hhuc.leetcode.others;

import java.util.Scanner;

/**
 * 1 一个小区里有n个居民，第一天有k个传染病感染者，感染者需要转运到医院隔离和治疗，该小区第一天的转运感染者的能力是p个人，
 * 第二天转运能力是p-1人，第三天转运能力是p-2人，以此类推。如果感染者当天没有转运出小区，
 * 则每一个感染者会在当天午夜12点感染1个人。请问这个小区需要多少天感染者能清零。
 * 用Java/JS/TS/C++语言实现求清零天数函数。
 * 要求：
 * (1) 命名一个合适的函数名称，实现完整的函数
 * (2) 按照你平时的编程习惯，在你认为需要注释处写上相应的注释
 * (3) 代码行数尽可能少，代码运行复杂度尽可能小
 * (4) 写出你实现代码的算法复杂度o(n)
 * <p>
 * 输入：
 * (1)	给出n=500, k=30, p=5
 * (2)	给出n=500, k=30, p=16
 */
public class 淡竹体育技术有限公司_疫情清零 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        System.out.println("清零天数：" + clear(n, k, p));
        System.out.println("清零所需最小运力：" + clear2(n, k));
    }

    /**
     * 疫情清零函数
     *
     * @param n 总共有n个居名
     * @param k 第一天有k个传染者
     * @param p 第一天转运感染者的能力
     * @return
     */
    public static int clear(int n, int k, int p) {
        // 记录需要多少天清零
        int day = 0;
        // 感染的总人数
        int total = k;
        // 当前剩余的感染者人数
        int rest = k;
        // 只要未清零，或者还有转运能力，则一直转运
        while (rest > 0 && p > 0) {
            rest = rest - p;
            // 当前总感染人数，总感染人数不能超过小区居民总数
            total = Math.min(total + rest, n);
            // 剩余未转运的感染者，每人会传染一人
            rest = rest * 2;
            day++;
            p--;
        }
        if (p == 0) {
            return -1;
        }
        return day;
    }

    /**
     * 2 接上一题，如果要确保最后小区能清零，即在转运能力减到0之前，所有感染者都能被转运出去，p的最小值是多少。
     * 即基于小区居民n，第一天感染人数k，求出p的最小值。用Java/JS/TS/C++语言实现求p最小值的函数。
     * 要求：
     * (1) 命名一个合适的函数名称，实现完整的函数
     * (2) 按照你平时的编程习惯，在你认为需要注释处写上相应的注释
     *
     * @return
     */
    public static int clear2(int n, int k) {
        for (int i = 1; i <= k; i++) {
            if (clear(n, k, i) != -1) {
                return i;
            }
        }
        return -1;
    }
}
