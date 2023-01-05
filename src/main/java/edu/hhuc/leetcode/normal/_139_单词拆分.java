package edu.hhuc.leetcode.normal;

import java.util.List;

public class _139_单词拆分 {

    private static int count = 0;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * 1024 * 1024];
        System.out.println("finish......");
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        for (String ele : wordDict) {
            s = s.replaceAll(ele, "");
        }
        return s.isEmpty();
    }
}