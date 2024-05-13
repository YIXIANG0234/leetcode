package edu.hhuc.leetcode.normal;

import java.util.List;

public class _139_单词拆分 {

    public static void main(String[] args) {
        _139_单词拆分 instance = new _139_单词拆分();
        System.out.println(instance.solution1("applepenapple", List.of("apple", "pen")));
    }

    /**
     * 动态规划，dp[i]表示字符s的子串0-i，如果dp[i]为true，则表示子串0-i可以由字典中的单词构成
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean solution1(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length];
        for (int i = 0; i < length; i++) {
            String subString = s.substring(0, i + 1);
            if (wordDict.contains(subString)) {
                dp[i] = true;
            } else {
                int j = i;
                while (j > 0) {
                    if (dp[j - 1] && wordDict.contains(s.substring(j, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                    j--;
                }
            }
        }
        return dp[length - 1];
    }

    /**
     * 动态规划官方写法
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean solution2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

