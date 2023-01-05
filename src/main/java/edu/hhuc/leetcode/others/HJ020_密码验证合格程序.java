package edu.hhuc.leetcode.others;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HJ020_密码验证合格程序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.length() < 8) {
                System.out.println("NG");
                continue;
            }
            if (!match(line)){
                System.out.println("NG");
                continue;
            }
            if (containRepeatString(line, 0, 3)){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    private static boolean match(String line){
        int count = 0;
        Pattern pattern = Pattern.compile("[0-9]");
        if (pattern.matcher(line).find()){
            count++;
        }
        pattern = Pattern.compile("[a-z]");
        if (pattern.matcher(line).find()){
            count++;
        }
        pattern = Pattern.compile("[A-Z]");
        if (pattern.matcher(line).find()){
            count++;
        }
        pattern = Pattern.compile("[^0-9a-zA-Z]");
        if (pattern.matcher(line).find()){
            count++;
        }
        return count>=3;
    }

    private static boolean containRepeatString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return containRepeatString(str,l+1,r+1);
        }
    }
}
