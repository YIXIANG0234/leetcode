package edu.hhuc.leetcode.normal;

/**
 * @program: leetcode
 * @ClassName _007_整数反转
 * @description:
 * @author: gaoya
 * @create: 2022-12-13 13:28
 * @Version 1.0
 */
public class _007_整数反转 {
    public static void main(String[] args) {
        _007_整数反转 instance = new _007_整数反转();
        System.out.println(instance.reverse(1534236469));
    }

    public int reverse(int x) {
        boolean negative = x < 0;
        int num = Math.abs(x);
        int result = 0;
        while (num > 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int bit = num % 10;
            num = num / 10;
            result = result * 10 + bit;
        }
        return negative ? -result : result;
    }
}

// 1534236469
// 9646324351
// 1056389759