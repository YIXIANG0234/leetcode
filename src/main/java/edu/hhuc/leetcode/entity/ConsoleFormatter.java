package edu.hhuc.leetcode.entity;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/12 11:01:11
 */
public class ConsoleFormatter {
    public static void arrayToConsole(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j != array[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
