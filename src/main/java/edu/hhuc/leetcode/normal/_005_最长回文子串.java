package edu.hhuc.leetcode.normal;

// TODO: 2022/6/9 未解决
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
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String temp = s.substring(i, j);
                if (isPalindromic(temp) && maxString.length() < temp.length()) {
                    maxString = temp;
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
            String len1 = longest(s, i, i);
            String len2 = longest(s, i, i + 1);
            String temp = len1.length() > len2.length() ? len1 : len2;
            maxString = (maxString.length() > temp.length() ? maxString : temp);
        }
        return maxString;
    }

    private String longest(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    private String solution3(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        String maxString = "";
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right-left<=2||dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    String temp = s.substring(left, right + 1);
                    maxString = maxString.length() > temp.length() ? maxString : temp;
                }
            }
        }
        return maxString;
    }

    private boolean isPalindromic(String s) {
        int length = s.length();
        for (int i = 0; i < (length >> 1); i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }


}
