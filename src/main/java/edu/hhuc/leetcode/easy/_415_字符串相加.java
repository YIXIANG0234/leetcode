package edu.hhuc.leetcode.easy;

/**
 * @program: leetcode
 * @ClassName _415_字符串相加
 * @description:
 * @author: gaoya
 * @create: 2023-01-12 16:44
 * @Version 1.0
 */
public class _415_字符串相加 {
    public static void main(String[] args) {
        _415_字符串相加 instance = new _415_字符串相加();
        String result = instance.solution1("123", "4568");
        System.out.println(result);
    }

    public String solution1(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int i = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i < maxLength) {
            int a = i < num1.length() ? num1.charAt(i) - '0' : 0;
            int b = i < num2.length() ? num2.charAt(i) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i++;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
