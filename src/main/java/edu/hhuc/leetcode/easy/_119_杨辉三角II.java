package edu.hhuc.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _119_杨辉三角II {
    public static void main(String[] args) {
        _119_杨辉三角II instance = new _119_杨辉三角II();
        System.out.println(instance.solution1(3));
    }

    /**
     * 使用两个list记录当前行和上一行的结果，将空间复杂度降为O(n)
     * @param rowIndex
     * @return
     */
    public List<Integer> solution1(int rowIndex) {
        List<Integer> lastRow = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                int num = 1;
                // 非第一行，非行首和行尾
                if (i != 0 && j != 0 && j != i) {
                    num = lastRow.get(j - 1) + lastRow.get(j);
                }
                row.add(num);
            }
            List<Integer> temp = lastRow;
            lastRow.clear();
            lastRow = row;
            row = temp;
        }
        return lastRow;
    }
}
