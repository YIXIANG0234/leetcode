package edu.hhuc.leetcode.剑指Offer;

import java.util.Stack;

/**
 * @program: leetcode
 * @ClassName _0
 * @description:
 * @author: gaoya
 * @create: 2022-12-12 21:21
 * @Version 1.0
 */
public class _030_包含min函数的栈 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public _030_包含min函数的栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int top = minStack.peek();
            if (top >= x) {
                minStack.push(x);
            }
        }
        stack.push(x);
    }

    public void pop() {
        if (minStack.peek().equals(stack.pop())) {
            minStack.pop();
        }
        return;
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
