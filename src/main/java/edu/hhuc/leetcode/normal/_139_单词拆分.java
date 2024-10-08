package edu.hhuc.leetcode.normal;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_单词拆分 {

    public static void main(String[] args) {
        _139_单词拆分 instance = new _139_单词拆分();
        System.out.println(instance.solution1("applepenapple", Lists.newArrayList("apple", "pen")));
    }

    /**
     * 动态规划，dp[i]表示字符s的子串0-i，如果dp[i]为true，则表示子串0-i可以由字典中的单词构成
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean solution1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                String x = s.substring(j, i + 1);
                if (set.contains(x) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }
}

