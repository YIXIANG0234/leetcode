package edu.hhuc.leetcode.others;

import java.util.Scanner;

public class HJ029_字符串加解密 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String encryptLine = in.nextLine();
        String decryptLine = in.nextLine();
        System.out.println(encrypt(encryptLine));
        System.out.println(decrypt(decryptLine));

    }

    private static String encrypt(String line) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                if (chars[i] == 'z') {
                    chars[i] = 'A';
                    continue;
                }
                chars[i] = Character.toUpperCase((char) (chars[i] + 1));
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                if (chars[i] == 'Z') {
                    chars[i] = 'a';
                    continue;
                }
                chars[i] = Character.toLowerCase((char) (chars[i] + 1));
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                if (chars[i] == '9') {
                    chars[i] = '0';
                    continue;
                }
                chars[i] = String.valueOf(Integer.valueOf(chars[i] + "") + 1).charAt(0);
            }
        }
        return String.valueOf(chars);
    }

    private static String decrypt(String line) {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                if (chars[i] == 'a') {
                    chars[i] = 'Z';
                    continue;
                }
                chars[i] = Character.toUpperCase((char) (chars[i] - 1));
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                if (chars[i] == 'A') {
                    chars[i] = 'z';
                    continue;
                }
                chars[i] = Character.toLowerCase((char) (chars[i] - 1));
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                if (chars[i] == '0') {
                    chars[i] = '9';
                    continue;
                }
                chars[i] = String.valueOf(Integer.valueOf(chars[i] + "") - 1).charAt(0);
            }
        }
        return String.valueOf(chars);
    }
}
