package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

public class _022_括号生成 {
    public static void main(String[] args) {
        _022_括号生成 instance = new _022_括号生成();
        System.out.println(instance.solution1(3));
    }

    public List<String> solution1(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
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
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            // 分别枚举当前位置为(和)的情况
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    /**
     * 校验括号有效性
     *
     * @param current
     * @return
     */
    public boolean valid(char[] current) {
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
}
