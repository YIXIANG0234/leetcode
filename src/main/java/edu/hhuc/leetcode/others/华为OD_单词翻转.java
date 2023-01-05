package edu.hhuc.leetcode.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述：
 * 给定一段英文文章片段，由若干单词组成，单词间以空格间隔，单词下标从0开始。
 * 请翻转片段中指定区间的单词顺序并返回翻转后的内容。
 * 例如给定的英文文章片段为"I am a developer"，翻转区间为[0,3]，则输出"developer a am I"。
 *
 * 示例：
 * 输入：
 * I am a developer
 * 1
 * 2
 * 输出：
 * I a am developer
 */
public class 华为OD_单词翻转 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split(" ");
        int length = words.length;
        int start = Math.min(length - 1, Math.max(0, in.nextInt()));
        int end = Math.max(0, Math.min(length - 1, in.nextInt()));
        in.close();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < start; i++) {
            result.add(words[i]);
        }
        for (int i = end; i >= start; i--) {
            result.add(words[i]);
        }
        for (int i = end + 1; i < length; i++) {
            result.add(words[i]);
        }
        System.out.println(result.stream().collect(Collectors.joining(" ")));
    }
}
