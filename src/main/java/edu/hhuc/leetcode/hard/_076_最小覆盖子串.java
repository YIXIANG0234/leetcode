package edu.hhuc.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/14 16:21:02
 */
public class _076_最小覆盖子串 {
    public static void main(String[] args) {
        _076_最小覆盖子串 instance = new _076_最小覆盖子串();
        String s = "wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon";
        String t = "ozgzyywxvtublcl";
        System.out.println(instance.solution2(s, t));
    }

    /**
     * 暴力枚举, 会超时
     *
     * @param s
     * @param t
     * @return
     */
    public String solution1(String s, String t) {
        int start = -1;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + t.length() - 1; j < s.length(); j++) {
                if (valid(s, i, j, new HashMap<>(map)) && j - i + 1 < minLength) {
                    start = i;
                    minLength = j - i + 1;
                }
            }
        }
        return start == -1 ? "" : s.substring(start, start + minLength);
    }

    private boolean valid(String s, int left, int right, Map<Character, Integer> map) {
        for (int i = left; i <= right; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        return map.values().stream().allMatch(x -> x <= 0);
    }

    /**
     * 双指针+滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public String solution2(String s, String t) {
        int start = -1;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int validCount = 0;
        for (int i = 0; i < t.length(); i++) {
            need.merge(t.charAt(i), 1, Integer::sum);
        }
        // 移动右指针，直到窗口能完全覆盖子串
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (need.containsKey(ch)) {
                window.merge(ch, 1, Integer::sum);
                if (window.get(ch).equals(need.get(ch))) {
                    validCount++;
                }
            }
            // 当前窗口能完全覆盖字串时，开始缩小左边界，寻找最小覆盖子串
            while (validCount == need.size()) {
                ch = s.charAt(left);
                if (window.containsKey(ch)) {
                    window.put(ch, window.get(ch) - 1);
                    // 判断当前窗口是否还能覆盖子串
                    if (window.get(ch) < need.get(ch)) {
                        validCount--;
                    }
                }
                // 更新最小覆盖子串位置和长度
                if (right - left + 1 < minLength) {
                    start = left;
                    minLength = right - left + 1;
                }
                left++;
            }
            right++;
        }
        return start == -1 ? "" : s.substring(start, start + minLength);
    }
}