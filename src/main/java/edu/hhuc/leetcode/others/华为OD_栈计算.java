package edu.hhuc.leetcode.others;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述：
 * 向一个空栈中依次存入正整数， 假设入栈元素n
 * 按顺序依次为nx...n4、n3、n2、n1, 每当元素入栈时，如果n1=n2+...+ny(y的范围[2,x]，2^31-1)，则n1~ny全部元素出栈，重新入栈新元素m(m=2*n1)。
 * 如：依次向栈存入6、1、2、3, 当存入6、1、2时，栈底至栈顶依次为[6、1、2]；当存入3时，3=2+1，3、2、1全部出栈，重新入栈元素6(6=2*3)，
 * 此时栈中有元素6；因为6=6，所以两个6全部出栈，存入12，最终栈中只剩一个元素12。
 *
 * 输入：
 * 使用单个空格隔开的正整数的字符串，如"5 6 7 8"， 左边的数字先入栈，输入的正整数个数为x，1<=x<=1000。
 *
 * 输出：
 * 最终栈中存留的元素值，元素值使用空格隔开，如"8 7 6 5"， 栈顶数字在左边。
 *
 * 示例：
 * 输入：5 10 20 50 85 1
 * 输出：1 170
 *
 * 输入：6 7 8 13 9
 * 输出：9 13 8 7 6
 *
 */
public class 华为OD_栈计算 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        long[] nums = Arrays.stream(line).mapToLong(Long::valueOf).toArray();
        Stack<Long> stack = new Stack<>();
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            pushNum(stack, nums[i]);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void pushNum(Stack<Long> stack, long num) {
        Stack<Long> popStack = new Stack<>();
        long sum = 0;
        while (!stack.isEmpty() && sum < num) {
            long top = stack.pop();
            sum += top;
            popStack.push(top);
        }
        if (sum == num) {
            pushNum(stack, sum * 2);
        } else {
            while (!popStack.isEmpty()) {
                stack.push(popStack.pop());
            }
            stack.push(num);
        }
    }
}
