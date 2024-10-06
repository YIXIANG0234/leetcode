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
//        char[][] board = {{
//                'A', 'B', 'C', 'E'
//        }, {
//                'S', 'F', 'C', 'S'
//        }, {
//                'A', 'D', 'E', 'E'
//        }};
        char[][] board = {{
                'A', 'B', 'C', 'E'
        }, {
                'S', 'F', 'E', 'S'
        }, {
                'A', 'D', 'E', 'E'
        }};
        String word = "ABCESEEEFS";
        System.out.println(instance.solution1(board, word));
    }

    public boolean solution1(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] checked = new boolean[board.length][board[0].length];
                if (backtrace(board, word, 0, i, j, checked)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrace(char[][] board, String word, int index, int i, int j, boolean[][] checked) {
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        // 标记当前位置已经检索过了
        checked[i][j] = true;
        // 向上检索
        if (i - 1 >= 0 && !checked[i - 1][j] && backtrace(board, word, index + 1, i - 1, j, checked)) {
            return true;
        }
        // 向左检索
        if (j - 1 >= 0 && !checked[i][j - 1] && backtrace(board, word, index + 1, i, j - 1, checked)) {
            return true;
        }
        // 向下检索
        if (i + 1 < board.length && !checked[i + 1][j] && backtrace(board, word, index + 1, i + 1, j, checked)) {
            return true;
        }
        // 向右检索
        if (j + 1 < board[0].length && !checked[i][j + 1] && backtrace(board, word, index + 1, i, j + 1, checked)) {
            return true;
        }
        // 如果4个方向都没有检索成功，则将当前位置恢复为未检索
        checked[i][j] = false;
        return false;
    }
}
