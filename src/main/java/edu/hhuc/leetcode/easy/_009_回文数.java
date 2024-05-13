package edu.hhuc.leetcode.easy;

/**
 * @program: leetcode
 * @ClassName _009_回文数
 * @description:
 * @author: gaoya
 * @create: 2023-01-18 10:09
 * @Version 1.0
 */
public class _009_回文数 {
    public static void main(String[] args) {
        _009_回文数 instance = new _009_回文数();
        System.out.println(instance.solution1(121));
    }
    public boolean solution1(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num = num / 10;
        }
        return result == x;
    }
}
