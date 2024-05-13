package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @ClassName _017_电话号码的字母组合
 * @description:
 * @author: gaoya
 * @create: 2023-02-23 09:23
 * @Version 1.0
 */
public class _017_电话号码的字母组合 {
    public static void main(String[] args) {
        _017_电话号码的字母组合 instance = new _017_电话号码的字母组合();
        System.out.println(instance.solution1("2347").size());
    }

    /**
     * 回溯算法
     * @param digits
     * @return
     */
    public List<String> solution1(String digits) {
        List<String> result = new ArrayList<>();
        if ("".equals(digits)) {
            return result;
        }
        String[] phones = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(result, 0, digits, new StringBuilder(""), phones);
        return result;
    }

    public void backtrack(List<String> result, int index, String digits, StringBuilder temporary, String[] phones) {
        if (index == digits.length()) {
            result.add(temporary.toString());
            return;
        }
        String s = phones[digits.charAt(index) - '0' - 2];
        for (int i = 0; i < s.length(); i++) {
            temporary = temporary.append(s.charAt(i));
            backtrack(result, index + 1, digits, temporary, phones);
            temporary.deleteCharAt(index);
        }
    }
}
