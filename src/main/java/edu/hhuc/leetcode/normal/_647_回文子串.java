package edu.hhuc.leetcode.normal;

/**
 * @program: leetcode
 * @ClassName _647_回文子串
 * @description:
 * @author: gaoya
 * @create: 2023-03-09 14:26
 * @Version 1.0
 */
public class _647_回文子串 {
    public static void main(String[] args) {
        _647_回文子串 instance = new _647_回文子串();
        // String s = "aaaaa";
        String s = "aba";
        System.out.println(instance.solution2(s));
    }

    /**
     * 暴力解法，时间复杂度为o(n^3)
     *
     * @param s
     * @return
     */
    public int solution1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindromic(s, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 时间复杂度为o(n^2)
     *
     * @param s
     * @return
     */
    public int solution2(String s) {
        int count = 0;
        int n = s.length();
        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            flag[i][i] = true;
            count++;
        }
        for (int right = 1; right < n; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || flag[left + 1][right - 1])) {
                    flag[left][right] = true;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 官方给出的解法
     * @param s
     * @return
     */
    public int solution3(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
            }
        }
        return count;
    }

    public boolean isPalindromic(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
