package edu.hhuc.leetcode.剑指Offer;

import java.util.Stack;

/**
 * @program: leetcode
 * @ClassName _009_用两个栈实现队列
 * @description:
 * @author: gaoya
 * @create: 2022-12-12 21:17
 * @Version 1.0
 */
public class _009_用两个栈实现队列 {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public _009_用两个栈实现队列() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.isEmpty() ? -1 : popStack.pop();
    }
}
