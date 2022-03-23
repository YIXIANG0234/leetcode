package edu.hhuc.leetcode.easy;

import java.util.LinkedList;
import java.util.Map;

public class _020_有效的括号 {
    /**
     * 使用栈进行匹配
     * @param s
     * @return
     */
    public boolean solution1(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (!map.containsKey(ch)) {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty() || map.get(ch) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 字符串替换的实现方式
     * @param s
     * @return
     */
    public boolean solution2(String s) {
        int length;
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while (s.length() != length);
        return s.isEmpty();
    }
}
