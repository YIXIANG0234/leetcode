package edu.hhuc.leetcode.others;

import java.util.Scanner;

public class HJ022_汽水瓶 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while ((n = in.nextInt()) != 0) {
            int count = 0;
            while (n > 0) {
                if (n == 1) {
                    break;
                } else {
                    count++;
                    n = n - 2;
                }
            }
            System.out.println(count);
        }
        in.close();
    }
}
