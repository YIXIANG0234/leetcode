package edu.hhuc.leetcode.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ068_成绩排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int order = in.nextInt();
        List<Grade> infos = new ArrayList<>();
        while (n > 0) {
            infos.add(new Grade(in.next(), in.nextInt()));
            n--;
        }
        infos.sort(((o1, o2) -> order == 1 ? o1.score.compareTo(o2.score) : o2.score.compareTo(o1.score)));
        // 排序
        for (Grade entry : infos) {
            System.out.println(entry.name + " " + entry.score);
        }
    }

    private static class Grade {
        private String name;
        private Integer score;

        public Grade(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
    }
}