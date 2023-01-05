package edu.hhuc.leetcode.others;

import java.util.Scanner;

public class HJ017_坐标移动 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] input = line.split(";");
        int x = 0;
        int y = 0;
        for (int i = 0; i < input.length; i++) {
            String item = input[i];
            if (item.length()<=1||!item.substring(1).matches("[0-9]+")){
                continue;
            }
            char operator = item.charAt(0);
            int coordinate = Integer.valueOf(item.substring(1));
            if (operator == 'A') {
                x -= coordinate;
            } else if (operator == 'D') {
                x += coordinate;
            } else if (operator == 'W') {
                y += coordinate;
            } else if (operator == 'S') {
                y -= coordinate;
            }
        }
        System.out.println(x + "," + y);
    }
}
