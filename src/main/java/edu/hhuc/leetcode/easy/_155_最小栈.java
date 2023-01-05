package edu.hhuc.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _155_最小栈 {
    private Stack<Integer> stack = new Stack<>();
    private List<Integer> nums = new ArrayList<>();
    private int min = Integer.MAX_VALUE;

    public void push(int val) {
        min = Math.min(min, val);
        stack.push(val);
        nums.add(val);
    }

    public void pop() {
        Integer top = stack.pop();
        nums.remove(top);
        if (top == min && nums.size() > 0) {
            min = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                min = Math.min(min, nums.get(i));
            }
        }
        // 需要清空记录
        if (nums.size() == 0) {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        _155_最小栈 instance = new _155_最小栈();
        instance.push(2147483646);
        instance.push(2147483646);
        instance.push(2147483647);
        System.out.println(instance.top());
        instance.pop();
        System.out.println(instance.getMin());
        instance.pop();
        System.out.println(instance.getMin());
        instance.pop();
        instance.push(2147483647);
        System.out.println(instance.top());
        System.out.println(instance.getMin());
        instance.push(-2147483648);
        System.out.println(instance.top());
        System.out.println(instance.getMin());
        instance.pop();
        System.out.println(instance.getMin());

    }
}
// [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483648,-2147483648,null,2147483647]
// [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]