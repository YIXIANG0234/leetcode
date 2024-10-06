package edu.hhuc.leetcode.hard;

// TODO: 2024/10/6 更优的解法未解决 

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
        System.out.println(instance.solution1(s, t));
    }

    /**
     * 暴力枚举
     *
     * @param s
     * @param t
     * @return
     */
    public String solution1(String s, String t) {
        int len = t.length();
        int left = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + len - 1; j < s.length(); j++) {
                if (contains(s, i, j, t)) {
                    if (left == -1 || (j - i) < (right - left)) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return left == -1 ? "" : s.substring(left, right + 1);
    }

    private boolean contains(String s, int left, int right, String t) {
        boolean[] checked = new boolean[t.length()];
        while (left <= right) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(left) == t.charAt(j) && !checked[j]) {
                    checked[j] = true;
                    break;
                }
            }
            left++;
        }
        for (boolean b : checked) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
