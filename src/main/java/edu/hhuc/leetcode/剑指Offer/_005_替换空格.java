package edu.hhuc.leetcode.剑指Offer;

/**
 * @program: leetcode
 * @ClassName _005_替换空格
 * @description:
 * @author: gaoya
 * @create: 2022-12-12 22:19
 * @Version 1.0
 */
public class _005_替换空格 {
    public String replaceSpace1(String s) {
        return s.replaceAll(" ", "%20");
    }

    public String replaceSpace2(String s) {
        char[] chars = new char[s.length() * 3];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            } else {
                chars[index++] = s.charAt(i);
            }
        }
        return new String(chars, 0, index);
    }
}
