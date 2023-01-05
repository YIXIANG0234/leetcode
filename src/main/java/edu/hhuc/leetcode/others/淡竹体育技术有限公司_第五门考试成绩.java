package edu.hhuc.leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 4 Lailia took five math tests, each worth a maximum of 100 points. Laila's score on
 * each test was an integer between 0 and 100, inclusive. Laila received the same
 * score on the first four tests, and she received a higher score on the last test. Her
 * average score on the five tests was <P>(P is an integer between 0 and 100). How many values are possible for Lailia's score on the last test?
 * Please use Java/JS/TS/C++ language to write the code.
 */
public class 淡竹体育技术有限公司_第五门考试成绩 {
    public static void main(String[] args) {
        System.out.println(solution(82));
    }

    public static List<Integer> solution(int avg) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            for (int j = i + 1; j <= 100; j++) {
                if ((i * 4 + j) == 5 * avg) {
                    list.add(j);
                    System.out.println(i);
                    break;
                }
            }
        }
        return list;
    }
}
