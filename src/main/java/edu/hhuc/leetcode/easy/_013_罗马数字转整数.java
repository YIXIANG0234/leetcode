package edu.hhuc.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @ClassName _013_罗马数字转整数
 * @description:
 * @author: gaoya
 * @create: 2023-01-18 10:18
 * @Version 1.0
 */
public class _013_罗马数字转整数 {
    public static void main(String[] args) {
        _013_罗马数字转整数 instance = new _013_罗马数字转整数();
        System.out.println(instance.solution1("MCMXCIV"));
    }

    public int solution1(String s) {
        // 1.建表
        Map<String, Integer> digit = new HashMap<>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};
        int result = 0;
        int index = 0;
        int prev = 0;
        char prevChar = ' ';
        do {
            // 2.判断是否有组合字符，累加组合字符的值
            if (digit.getOrDefault("" + prevChar + s.charAt(index), 0) != 0) {
                result += digit.get("" + prevChar + s.charAt(index));
                prevChar = ' ';
                prev = 0;
            } else {
                // 3. 累加单个字符的值
                result += prev;
                prevChar = s.charAt(index);
                prev = digit.getOrDefault(s.charAt(index) + "", 0);
            }
            index++;
        } while (index < s.length());
        // 4.判断最后两个是否为组合字符
        if (s.length() < 2 || digit.getOrDefault(s.substring(s.length() - 2, s.length()), 0) == 0) {
            result += prev;
        }
        return result;
    }

    public int solution2(String s) {
        Map<Character, Integer> digit = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = digit.get(s.charAt(i));
            if (i < s.length() - 1 && current < digit.get(s.charAt(i + 1))) {
                result = result - current;
            } else {
                result = result + current;
            }
        }
        return result;
    }
}
