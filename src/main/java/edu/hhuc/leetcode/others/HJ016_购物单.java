package edu.hhuc.leetcode.others;

import java.util.Scanner;

// todo 01背包问题，没搞定
public class HJ016_购物单 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] price = new int[m];
        int[] wight = new int[m];
        int[] master = new int[m];
        int index = 0;
        while (n > 0) {
            price[index] = in.nextInt();
            wight[index] = in.nextInt();
            master[index] = in.nextInt();
            n--;
            index++;
        }


    }
}
