package Algorithm;

public class Q52 {
    private boolean[][] board;
    private boolean[] columnUsed;
    private int res = 0;

    public int totalNQueens(int n) {
        board = new boolean[n][n];
        columnUsed = new boolean[n];
        dfs(0);
        return res;
    }

    private void dfs(int index) {
        if (index == board.length) {
            res++;
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
