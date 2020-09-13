package Algorithm;

public class Q79 {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i , j)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int x, int y) {
        if (index == word.length()) return true;
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) return false;
        if (board[x][y] != word.charAt(index) || visited[x][y]) return false;
        visited[x][y] = true;
        boolean flag = dfs(board, word, index + 1, x - 1, y) || dfs(board, word, index + 1, x + 1, y)
                || dfs(board, word, index + 1, x, y - 1) || dfs(board, word, index + 1, x , y + 1);
        visited[x][y] = false;
        return flag;
    }
}
