package edu.hhuc.leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 3 输入一个没有重复字符的字符串，打印出该字符串中所有字符的排列。如输入abc，
 * 则打印出a、b、c所能排列出来的所有字符串abc, acb, bac, bca, cab, cba。用Java/JS/TS/C++语言写一个函数实现。
 * 要求：
 * (1)	命名一个合适的函数名称，实现完整的函数
 * (2)	仅用一个函数实现，不要出现调用子函数
 * (3) 按照你平时的编程习惯，在你认为需要注释处写上相应的注释
 */
public class 淡竹体育技术有限公司_全排列 {
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution("xyz"));
    }

    public static List<String> solution(String input) {
        // 用来标记字符是否被使用过
        boolean[] judge = new boolean[input.length()];
        // 当前可能的排列
        StringBuilder possibility = new StringBuilder();
        int index = 0;
        permute(input, possibility, judge, index);
        return result;
    }

    public static void permute(String input, StringBuilder possibility, boolean[] judge, int index) {
        // 当前的排序已经枚举结束，加入结果集中
        if (index == input.length()) {
            result.add(possibility.toString());
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            // 该字符使用过，查找下一个未使用过的字符
            if (judge[i]) {
                continue;
            }
            // 将未使用的字符加入到排列中，构建排列的结果，并标记为已使用状态
            possibility.append(input.charAt(i));
            judge[i] = true;
            // 递归查找下一个位置
            permute(input, possibility, judge, index + 1);
            // 删除当前位置的标记，进行下一轮循环，即在该位置枚举下一字符
            judge[i] = false;
            possibility.deleteCharAt(index);
        }
    }

}
