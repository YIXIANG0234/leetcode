package edu.hhuc.leetcode.others;

import java.util.*;

public class HJ004_字符串分割 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        int index = 0;
        int length = line.length();
        while (index < length) {
            String subString = index + 8 > length ? line.substring(index, length) : line.substring(index, index + 8);
            index = index + 8;
            while (subString.length() < 8) {
                subString = subString + "0";
            }
            System.out.println(subString);
        }
    }
}
