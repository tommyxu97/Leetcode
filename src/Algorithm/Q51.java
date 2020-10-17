package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q51 {
    private boolean[][] board;
    private boolean[] columnUsed;
    private List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        columnUsed = new boolean[n];
        dfs(0);
        return res;
    }

    private void dfs(int index) {
        if (index == board.length) {
            List<String> temp = new ArrayList<>(board.length);
            StringBuilder builder;
            for (boolean[] booleans : board) {
                builder = new StringBuilder();
                for (boolean b : booleans) {
                    builder.append(b ? 'Q' : '.');
                }
                temp.add(builder.toString());
            }
            res.add(temp);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!columnUsed[i] && isValid(index, i)) {
                columnUsed[i] = true;
                board[index][i] = true;
                dfs(index + 1);
                columnUsed[i] = false;
                board[index][i] = false;
            }
        }
    }

    private boolean isValid(int row, int col) {
        int tempRow = row - 1, tempCol = col - 1;
        while (tempRow >= 0 && tempCol >= 0) {
            if (board[tempRow][tempCol]) return false;
            tempRow--; tempCol--;
        }
        tempRow = row - 1; tempCol = col + 1;
        while (tempRow >= 0 && tempCol < board.length) {
            if (board[tempRow][tempCol]) return false;
            tempRow--; tempCol++;
        }
        return true;
    }
}
