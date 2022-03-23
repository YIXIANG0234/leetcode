package edu.hhuc.leetcode.easy;

import java.util.LinkedList;

public class _225_用队列实现栈 {
    private LinkedList<Integer> queue = new LinkedList<>();
    public void push(int x) {
        queue.push(x);
    }

    public int pop() {
        return queue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
