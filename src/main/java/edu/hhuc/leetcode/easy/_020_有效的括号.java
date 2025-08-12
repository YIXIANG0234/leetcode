package edu.hhuc.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _020_有效的括号 {
    public static void main(String[] args) {
        _020_有效的括号 instance = new _020_有效的括号();
        System.out.println(instance.solution1("[{({[]})}]"));
    }

    /**
     * 使用栈进行匹配
     *
     * @param s
     * @return
     */
    public boolean solution1(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (!map.containsKey(ch)) {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty() || !map.get(ch).equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 字符串替换的实现方式
     *
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
