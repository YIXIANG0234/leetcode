package edu.hhuc.leetcode.normal;

import java.util.*;

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

    /**
     * 思路：
     * 暴力解法，针对每一个字符串，都在剩余字符串中寻找其字母异位词，如果找到就加入到结果集中，并标记为已使用
     *
     * @param strs
     * @return
     */
    public List<List<String>> solution1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int len = strs.length;
        boolean[] processed = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (processed[i]) {
                continue;
            }
            List<String> list = new ArrayList<>();
            processed[i] = true;
            list.add(strs[i]);
            result.add(list);
            for (int j = i + 1; j < len; j++) {
                if (processed[j]) {
                    continue;
                }
                if (similar(strs[i], strs[j])) {
                    list.add(strs[j]);
                    processed[j] = true;
                }
            }
        }
        return result;
    }

    /**
     * 将每个字符串排序后作为key，所有的字母异位词得到的key是一样的，把字母异位词出现的次数作为value
     *
     * @param strs
     * @return
     */
    public List<List<String>> solution2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 思路和solution2是一样的，只不过这时字母异位词的key，是按照字母出现的次数得到的
     *
     * @param strs
     * @return
     */
    public List<List<String>> solution3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = similarKey(strs[i]);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private boolean similar(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private String similarKey(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                char ch = (char) (i + 'a');
                key.append(ch).append(count[i]);
            }
        }
        return key.toString();
    }
}
