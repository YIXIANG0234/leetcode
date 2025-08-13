package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

public class _022_括号生成 {
    public static void main(String[] args) {
        _022_括号生成 instance = new _022_括号生成();
        System.out.println(instance.solution2(3));
    }

    /**
     * 暴力解法，枚举每一个序列，然后判断是否是正确的序列
     *
     * @param n
     * @return
     */
    public List<String> solution1(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    /**
     * 只在序列仍然保持有效时才添加 ‘(’ 或 ‘)’，而不是像 方法一 那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点
     *
     * @param n
     * @return
     */
    public List<String> solution2(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    /**
     * 回溯算法+减枝
     *
     * @param n
     * @return
     */
    public List<String> solution3(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, new StringBuilder(), result);
        return result;
    }

    /**
     * 递归生成所有可能的括号组合，然后将有效组合加入结果集
     *
     * @param current
     * @param pos
     * @param result
     */
    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (isValid(current)) {
                result.add(new String(current));
            }
            return;
        }
        // 分别枚举当前位置为(和)的情况
        current[pos] = '(';
        generateAll(current, pos + 1, result);
        current[pos] = ')';
        generateAll(current, pos + 1, result);
    }

    /**
     * 校验括号有效性
     *
     * @param current
     * @return
     */
    public boolean isValid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            // 当baLance<0时，说明有)先于(出现的场景，该括号组合不合法
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    private void generateAll(int left, int right, StringBuilder sb, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        // 左右括号数量相等时，只能先放左括号
        if (left == right) {
            sb.append("(");
            generateAll(left - 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left < right) {
            // 剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if (left > 0) {
                sb.append("(");
                generateAll(left - 1, right, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(")");
            generateAll(left, right - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void dfs(int left, int right, StringBuilder sb, List<String> result) {
        // 不符合格式的分支直接结束
        if (left < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        sb.append("(");
        dfs(left - 1, right, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        dfs(left, right - 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}
