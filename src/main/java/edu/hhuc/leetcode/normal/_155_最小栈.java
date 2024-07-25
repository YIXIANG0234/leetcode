package edu.hhuc.leetcode.normal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/17 15:58:22
 */
public class _155_最小栈 {

    public static void main(String[] args) {
        MinStack3 stack = new _155_最小栈().new MinStack3();
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

    class MinStack {
        private Stack<Integer> stack = new Stack<>();
        private PriorityQueue<Integer> queue = new PriorityQueue<>();

        public void push(int val) {
            stack.push(val);
            queue.add(val);
        }

        public void pop() {
            queue.remove(stack.pop());
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            if (!queue.isEmpty()) {
                return queue.peek();
            }
            return -1;
        }
    }

    class MinStack2 {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> min = new Stack<>();

        public void push(int val) {
            stack.push(val);
            if (min.isEmpty() || val <= min.peek()) {
                min.push(val);
            }
        }

        public void pop() {
            int val = stack.pop();
            if (!min.isEmpty() && min.peek() == val) {
                min.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            if (!min.isEmpty()) {
                return min.peek();
            }
            return -1;
        }
    }

    class MinStack3 {
        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack3() {
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();
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
}
