package edu.hhuc.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 官方的解法很奇妙
 */
public class _155_最小栈2 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public _155_最小栈2() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
