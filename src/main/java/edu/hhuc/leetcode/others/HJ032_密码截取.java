package edu.hhuc.leetcode.others;

import java.util.Scanner;

public class HJ032_密码截取 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        System.out.println(solution2(line));
    }

    /**
     * 中心扩散法
     *
     * @param s
     * @return
     */
    private static int solution1(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = longest(s, i, i);
            int len2 = longest(s, i, i + 1);
            maxLength = Math.max(maxLength, Math.max(len1, len2));
        }
        return maxLength;
    }

    private static int longest(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    private static int solution2(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLength = 0;
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    maxLength = Math.max(maxLength, right - left + 1);
                }
            }
        }
        return maxLength;
    }
}
