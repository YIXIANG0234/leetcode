package edu.hhuc.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/11 17:18:47
 */
public class _049_字母异位词分组 {

    public static void main(String[] args) {
        _049_字母异位词分组 instance = new _049_字母异位词分组();
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(instance.solution1(s));

    }

    public List<List<String>> solution1(String[] s) {
        List<List<String>> result = new ArrayList<>();
        int len = s.length;
        short[] hit = new short[len];
        for (int i = 0; i < len; i++) {
            if (hit[i] == -1) {
                continue;
            }
            List<String> list = new ArrayList<>();
            hit[i] = -1;
            list.add(s[i]);
            result.add(list);
            for (int j = i + 1; j < len; j++) {
                if (hit[j] == -1) {
                    continue;
                }
                if (similar(s[i], s[j])) {
                    list.add(s[j]);
                    hit[j] = -1;
                }
            }
        }
        return result;
    }

    private boolean similar(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        short[] hit = new short[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            char ch = s1.charAt(i);
            for (int j = 0; j < len; j++) {
                if (hit[j] == -1) {
                    continue;
                }
                if (ch == s2.charAt(j)) {
                    hit[j] = -1;
                    count++;
                }
            }
        }
        return count == len;
    }
}
