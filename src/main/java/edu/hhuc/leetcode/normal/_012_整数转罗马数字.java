package edu.hhuc.leetcode.normal;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @ClassName _012_整数转罗马数字
 * @description:
 * @author: gaoya
 * @create: 2023-01-18 10:59
 * @Version 1.0
 */
public class _012_整数转罗马数字 {
    public static void main(String[] args) {
        _012_整数转罗马数字 instance = new _012_整数转罗马数字();
        System.out.println(instance.solution1(3));
    }

    public String solution1(int num) {
        Map<Integer, String> roman = new HashMap<Integer, String>() {{
            put(1000, "M");
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
            put(4, "IV");
            put(9, "IX");
            put(40, "XL");
            put(90, "XC");
            put(400, "CD");
            put(900, "CM");
        }};
        List<Integer> sorted = Lists.newArrayList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < sorted.size(); i++) {
                if (num / sorted.get(i) != 0) {
                    int quantity = num / sorted.get(i);
                    for (int j = 0; j < quantity; j++) {
                        result.append(roman.get(sorted.get(i)));
                    }
                    num = num % sorted.get(i);
                }
            }
        }
        return result.toString();
    }

    public String solution2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num > value) {
                sb.append(symbol);
                num -= value;
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
