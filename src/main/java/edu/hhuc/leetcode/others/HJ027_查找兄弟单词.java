package edu.hhuc.leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HJ027_查找兄弟单词 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> input = new ArrayList<>();
        while (n > 0) {
            input.add(in.next());
            n--;
        }
        String brother = in.next();
        int k = in.nextInt();
        in.close();
        // 遍历输入单词列表，获取所有的兄弟单词
        List<String> brotherList = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (isBrother(brother, input.get(i))) {
                brotherList.add(input.get(i));
            }
        }
        // 对获取到的兄弟单词排序，这里手动排序
        brotherList.sort((t1, t2) -> {
            int i = 0;
            while (i < t1.length() && i < t2.length()) {
                if (t1.charAt(i) != t2.charAt(i)) {
                    return t1.charAt(i) > t2.charAt(i) ? 1 : -1;
                }
                i++;
            }
            if (t1.length() == t2.length()) {
                return 0;
            }
            return t1.length() - t2.length();
        });
        // 获取按照字典序排序后的第k个兄弟单词
        System.out.println(brotherList.size());
        if (k < brotherList.size()) {
            System.out.println(brotherList.get(k - 1));
        }
    }

    /**
     * 判断target是否时origin的兄弟单词
     *
     * @param origin
     * @param target
     * @return
     */
    private static boolean isBrother(String origin, String target) {
        if (origin.length() != target.length() || origin.equals(target)) {
            return false;
        }
        char[] originChars = origin.toCharArray();
        char[] targetChars = target.toCharArray();
        Arrays.sort(originChars);
        Arrays.sort(targetChars);
        return Arrays.equals(originChars, targetChars);
    }
}
