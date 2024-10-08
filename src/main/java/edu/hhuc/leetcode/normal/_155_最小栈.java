package edu.hhuc.leetcode.normal;

import java.util.Stack;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/17 15:58:22
 */
public class _155_最小栈 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        _155_最小栈 stack = new _155_最小栈();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(1);
        stack.push(4);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
