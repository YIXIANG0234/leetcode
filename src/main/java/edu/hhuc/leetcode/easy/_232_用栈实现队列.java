package edu.hhuc.leetcode.easy;

import java.util.Stack;

/**
 * 使用两个栈，分别标识入队列和出队列，当且仅当出队列的栈为空时，才能将入队列的栈中的元素放入出队列的栈中
 */
public class _232_用栈实现队列 {

    // 入队列使用的栈
    private Stack<Integer> stack1 = new Stack<>();
    // 出队列使用的栈
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
