package edu.hhuc.leetcode.normal;

public class _005_最长回文子串 {
    public static void main(String[] args) {
        _005_最长回文子串 instance = new _005_最长回文子串();
        System.out.println(instance.solution3("51233214"));
    }

    /**
     * 暴力枚举，时间复杂度为O(n^3)会超时
     *
     * @param s
     * @return
     */
    public String solution1(String s) {
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindromic(s, i, j)) {
                    String temp = s.substring(i, j + 1);
                    maxString = maxString.length() > temp.length() ? maxString : temp;
                }
            }
        }
        return maxString;
    }

    /**
     * 中心扩散法，遍历所有字符，将当前字符，以及当前字符和下一字符为中心，分别找出ABA型和ABBA型回文串的最大长度，在两者中取较大者
     *
     * @param s
     * @return
     */
    public String solution2(String s) {
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = findPalindromic(s, i, i);
            String s2 = findPalindromic(s, i, i + 1);
            maxString = maxString.length() > s1.length() ? maxString : s1;
            maxString = maxString.length() > s2.length() ? maxString : s2;
        }
        return maxString;
    }

    /**
     * 动态规划：
     * 假设dp[i][j]表示字符i到j的字串是回文串
     * 则dp[i-1][j+1]是回文串的条件是，s[i-1] == s[j+1] 且 dp[i][j]是回文串
     * 时间复杂度和空间复杂度都是O(n^2)
     * @param s
     * @return
     */
    public String solution3(String s) {
        String maxString = "";
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(right) == s.charAt(left) && (right - left <= 1 || dp[left + 1][right - 1] == 1)) {
                    dp[left][right] = 1;
                    String temp = s.substring(left, right + 1);
                    maxString = maxString.length() > temp.length() ? maxString : temp;
                }
            }
        }
        return maxString;
    }

    private boolean isPalindromic(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private String findPalindromic(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
