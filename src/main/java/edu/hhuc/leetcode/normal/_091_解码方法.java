package edu.hhuc.leetcode.normal;

public class _091_解码方法 {
    public static void main(String[] args) {
        _091_解码方法 instance = new _091_解码方法();
        System.out.println(instance.solution1("226"));
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int solution1(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != '0') {
                dp[i] += dp[i - 1];
            }
            // 截取i-1和i两个位置的数字组成两位数
            String sub = s.substring(i - 1, i + 1);
            if (Integer.valueOf(sub) <= 26 && !sub.startsWith("0")) {
                dp[i] += (i >= 2 ? dp[i - 2] : 1);
            }
        }
        return dp[n - 1];
    }

    /**
     * 动态规划，滚动数组
     * @param s
     * @return
     */
    public int solution2(String s) {
        int n = s.length();
        int first = 0;
        int second = 1;
        for (int i = 1; i <= n; i++) {
            int current = 0;
            if (s.charAt(i - 1) != '0') {
                current += second;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                current += first;
            }
            first = second;
            second = current;
        }
        return second;
    }
}
