package edu.hhuc.leetcode.normal;

import java.util.Arrays;
import java.util.Stack;

public class _503_下一个更大元素II {
    public static void main(String[] args) {
        _503_下一个更大元素II instance = new _503_下一个更大元素II();
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(instance.solution1(nums)));
    }

    /**
     * 需要遍历两次，代码有重复，官方的解法更好
     *
     * @param nums
     * @return
     */
    public int[] solution1(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 官方采用取模的解法，代码更简洁
     * @param nums
     * @return
     */
    public int[] solution2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek() % length]) {
                result[stack.pop() % length] = nums[i % length];
            }
            stack.push(i);
        }
        return result;
    }
}
