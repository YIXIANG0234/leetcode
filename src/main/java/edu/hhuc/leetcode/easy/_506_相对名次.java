package edu.hhuc.leetcode.easy;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class _506_相对名次 {
    /**
     * 借助treeMap，分别根据分数，和选手的下标进行两次排序
     * @param score
     * @return
     */
    public String[] solution1(int[] score) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int index = 0; index < score.length; index++) {
            map.put(score[index], index);
        }

        Map<Integer, String> result = new TreeMap<>();
        int[] count = {1};
        map.forEach((key, value) -> {
            if (count[0] == 1) {
                result.put(value, "Gold Medal");
            } else if (count[0] == 2) {
                result.put(value, "Silver Medal");
            } else if (count[0] == 3) {
                result.put(value, "Bronze Medal");
            } else {
                result.put(value, count[0] + "");
            }
            count[0]++;
        });
        return result.values().toArray(new String[0]);
    }
}
