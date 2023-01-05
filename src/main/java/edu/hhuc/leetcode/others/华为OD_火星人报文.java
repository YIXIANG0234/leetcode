package edu.hhuc.leetcode.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述：
 * 已知火星人使用的运算符为#、$，其与地球人的等价公式如下：
 * x#y = 4*x+3*y+2
 * x$y = 2*x+y+3
 * 1、其中x、y是无符号整数
 * 2、地球人公式按C语言规则计算
 * 3、火星人公式中，#的优先级高于$，相同的运算符，按从左到右的顺序计算
 * 现有一段火星人的字符串报文，请你来翻译并计算结果。
 *
 * 注意：
 * 题目保证输入的合法性
 *
 * 示例：
 * 输入：7#6$5#12
 * 输出：157
 */
public class 华为OD_火星人报文 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        String[] express_$ = input.split("\\$");
        List<Integer> midResult = new ArrayList<>();
        for (int i = 0; i < express_$.length; i++) {
            String item = express_$[i];
            String[] express = item.split("#");
            int temp = Integer.valueOf(express[0]);
            for (int j = 1; j < express.length; j++) {
                temp = 4 * temp + 3 * Integer.valueOf(express[j]) + 2;
            }
            midResult.add(temp);
        }
        int result = midResult.get(0);
        for (int i = 1; i < midResult.size(); i++) {
            result = 2 * result + midResult.get(i) + 3;
        }
        System.out.println(result);
    }
}
