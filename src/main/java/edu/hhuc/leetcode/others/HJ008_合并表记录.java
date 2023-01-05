package edu.hhuc.leetcode.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ008_合并表记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        while (n > 0) {
            int index = in.nextInt();
            int value = in.nextInt();
            map.put(index, map.getOrDefault(index, 0) + value);
            n--;
        }
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
    }
}
