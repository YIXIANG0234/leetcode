package edu.hhuc.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class _020_有效的括号 {
    public static void main(String[] args) {
        _020_有效的括号 instance = new _020_有效的括号();
        System.out.println(instance.solution4("[{({[]})}]"));
    }

    /**
     * 使用栈进行匹配
     *
     * @param s
     * @return
     */
    public boolean solution1(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
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

    public boolean solution3(String s) {
        int left = 0;
        int right = s.length() - 1;
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        while (left <= right) {
            if (map.get(s.charAt(left)) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean solution4(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (stack.isEmpty() || !map.containsKey(ch)) {
                stack.push(ch);
                continue;
            }
            if (!map.get(ch).equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }


}
