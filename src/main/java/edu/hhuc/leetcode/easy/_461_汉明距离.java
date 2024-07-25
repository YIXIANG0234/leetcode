package edu.hhuc.leetcode.easy;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/23 17:19:38
 */
public class _461_汉明距离 {
    public static void main(String[] args) {
        _461_汉明距离 instance = new _461_汉明距离();
        int x = 1;
        int y = 4;
        System.out.println(instance.solution3(x, y));
    }

    public int solution1(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            int bitA = x & 1;
            int bitB = y & 1;
            if (bitA != bitB) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }

    public int solution2(int x, int y) {
        int num = x ^ y;
        int count = 0;
        while (num != 0) {
            count = count + (num & 1);
            num = num >> 1;
        }

        return count;
    }

    public int solution3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
