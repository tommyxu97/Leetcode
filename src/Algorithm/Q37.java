package Algorithm;

public class Q37 {

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board ,int row, int col) {
        if (row == 9) return true;
        if (col == 9) return dfs(board, row + 1, 0);
        if (board[row][col] != '.') return dfs(board, row, col + 1);
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, c, row, col)) {
                board[row][col] = c;
                if (dfs(board, row, col + 1)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, char c, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
        }
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }
        return true;
    }
}
