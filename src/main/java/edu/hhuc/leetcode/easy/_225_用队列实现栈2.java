package edu.hhuc.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _225_用队列实现栈2 {
    // 入栈使用的队列
    private List<Integer> queue1 = new ArrayList<>();
    // 出栈使用的队列
    private List<Integer> queue2 = new ArrayList<>();

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        // top用来记录最后一个元素，即栈顶元素
        for (int i = 0; i < queue1.size() - 1; i++) {
            queue2.add(queue1.get(i));
        }
        int top = queue1.remove(queue1.size() - 1);
        queue1.clear();
        // 交换入栈和出栈使用的队列
        List temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public int top() {
        // top用来记录最后一个元素，即栈顶元素，与pop方法的区别是，最后一个元素要入栈
        int top = 0;
        for (int i = 0; i < queue1.size(); i++) {
            top = queue1.get(i);
            queue2.add(top);
        }
        queue1.clear();
        // 交换入栈和出栈使用的队列
        List temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        _225_用队列实现栈2 stack = new _225_用队列实现栈2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
