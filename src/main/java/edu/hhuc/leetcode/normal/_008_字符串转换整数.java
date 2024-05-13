package edu.hhuc.leetcode.normal;

/**
 * @program: leetcode
 * @ClassName _008_字符串转换整数
 * @description:
 * @author: gaoya
 * @create: 2023-01-18 09:38
 * @Version 1.0
 */
public class _008_字符串转换整数 {
    public static void main(String[] args) {
        _008_字符串转换整数 instance = new _008_字符串转换整数();
        System.out.println(instance.solution1("9223372036854775808"));
    }

    public int solution1(String s) {
        // 1.去除前导空格
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        // 2.判断符号位
        boolean negative = false;
        int index = 0;
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            negative = s.charAt(index) == '-' ? true : false;
            index++;
        }
        // 3.去除前导0
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        // 4.累加结果，使用long存储
        long result = 0;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            result = result * 10 + s.charAt(index) - '0';
            index++;
            // 超出int范围，则跳过后续处理
            if (result > Integer.MAX_VALUE) {
                break;
            }
        }
        // 5.对符号位和越界进行处理
        if (negative) {
            result = -result;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
