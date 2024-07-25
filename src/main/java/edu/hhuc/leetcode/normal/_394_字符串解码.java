package edu.hhuc.leetcode.normal;

import java.util.Stack;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/23 11:34:27
 */
public class _394_字符串解码 {
    public static void main(String[] args) {
        _394_字符串解码 instance = new _394_字符串解码();
        // String input = "3[a]2[bc]";
        String input = "abc3[cd]xyz";
        // String input = "3[a2[c]]";
        System.out.println(instance.solution1(input));
    }

    public String solution1(String input) {
        StringBuilder sb = new StringBuilder();
        int len = input.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            if (ch == ']') {
                StringBuilder repeat = new StringBuilder();
                while (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (top == '[') {
                        break;
                    }
                    repeat.insert(0, top);
                }
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numStr.insert(0, stack.pop());
                }
                int count = Integer.parseInt(numStr.toString());
                while (count > 0) {
                    for (int j = 0; j < repeat.length(); j++) {
                        stack.push(repeat.charAt(j));
                    }
                    count--;
                }
            } else {
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
