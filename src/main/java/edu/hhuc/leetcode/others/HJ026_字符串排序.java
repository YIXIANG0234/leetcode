package edu.hhuc.leetcode.others;

import java.util.Scanner;

public class HJ026_字符串排序 {
    /**
     * 使用具有稳定性的冒泡排序
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                // 非字母，则跳过
                if (!Character.isLetter(chars[j])) {
                    continue;
                }
                char a = Character.toLowerCase(chars[j]);
                int index = j;
                // 找到当前字符最近的一个字母位置
                while (index < chars.length - 1 && !Character.isLetter(chars[index + 1])) {
                    index++;
                }
                // 如果没有找到字母，表面全是非字母，不用排序了
                if (index == chars.length - 1) {
                    break;
                }
                // 比较字母大小，需要时进行位置交换
                char b = Character.toLowerCase(chars[index + 1]);
                if (a > b) {
                    char temp = chars[j];
                    chars[j] = chars[index + 1];
                    chars[index + 1] = temp;
                }
            }
        }
        System.out.println(new String(chars));
    }
}
