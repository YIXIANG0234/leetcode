package edu.hhuc.leetcode.others;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目描述：
 * 输入一组单词words数组，找出其中的最长单词，
 * 该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，
 * 返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 * 输入：
 * ["apple","iOS","dog","nana","man","good","goodman"]
 * 输出：
 * "goodman"
 */
public class 兴业数金_找出最长单词 {
    public static void main(String[] args) {
        兴业数金_找出最长单词 instance = new 兴业数金_找出最长单词();
        String[] words = {"apple", "apple", "iOS","iOK", "dog", "nana", "appleappleiOS","appleappleiOK", "man", "goo", "good", "goodman1"};
        System.out.println(instance.longestWord(words));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param words string字符串一维数组
     * @return string字符串
     */
    public String longestWord(String[] words) {
        String longest = "";
        List<String> wordSet = Arrays.stream(words).collect(Collectors.toList());
        for (String word : words) {
            List<String> removed = new ArrayList<>();
            while (wordSet.contains(word)) {
                wordSet.remove(word);
                removed.add(word);
            }
            wordSet.remove(word);
            if (contains(wordSet, word)) {
                // 长度相同时，取字典序较小的值
                if (longest.length() == word.length()) {
                    String[] temp = {longest, word};
                    // Arrays.sort方法先按照字符串长度排序，长度相同，按照字典序排序
                    Arrays.sort(temp);
                    longest = temp[0];
                } else {
                    longest = longest.length() > word.length() ? longest : word;
                }
            }
            wordSet.addAll(removed);
        }
        return longest;
    }

    public boolean contains(List<String> words, String current) {
        if ("".equals(current)) {
            return true;
        }
        for (int i = 0; i < current.length(); i++) {
            String subString = current.substring(0, i + 1);
            if (words.contains(subString)) {
                words.remove(subString);
                boolean flag = contains(words, current.substring(i + 1));
                words.add(subString);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
