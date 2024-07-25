package edu.hhuc.leetcode.normal;

/**
 * @author guwanghuai
 * @version 1.0
 * @project leetcode
 * @description
 * @date 2024/7/14 14:57:27
 */
public class _079_单词搜索 {
    public static void main(String[] args) {
        _079_单词搜索 instance = new _079_单词搜索();
        char[][] board = {{
                'A', 'B', 'C', 'E'
        }, {
                'S', 'F', 'C', 'S'
        }, {
                'A', 'D', 'E', 'E'
        }};
        String word = "ASFBCS";
        System.out.println(instance.solution1(board, word));
    }

    public boolean solution1(char[][] board, String word) {
        return backtrace(board, word, 0, 0, 0, new boolean[board.length][board[0].length]);
    }

    private boolean backtrace(char[][] board, String word, int nextChar, int i, int j, boolean[][] checked) {
        if (nextChar == word.length() - 1) {
            return board[i][j] == word.charAt(nextChar);
        }
        if (board[i][j] == word.charAt(nextChar)) {
            checked[i][j] = true;
            // 向上检索
            if (i - 1 >= 0 && !checked[i - 1][j] && backtrace(board, word, nextChar + 1, i - 1, j, checked)) {
                return true;
            }
            // 向左检索
            if (j - 1 >= 0 && !checked[i][j - 1] && backtrace(board, word, nextChar + 1, i, j - 1, checked)) {
                return true;
            }
            // 向下检索
            if (i + 1 < board.length && !checked[i + 1][j] && backtrace(board, word, nextChar + 1, i + 1, j, checked)) {
                return true;
            }
            // 向右检索
            if (j + 1 < board[i].length && !checked[i][j + 1] && backtrace(board, word, nextChar + 1, i, j + 1, checked)) {
                checked[i][j + 1] = true;
                return true;
            }
        }
        return false;
    }
}
