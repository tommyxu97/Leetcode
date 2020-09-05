package SwordToOffer;

public class Offer12 {

    public static void main(String[] args) {
        System.out.println(new Offer12().exist(new char[][]{{'a','b'}, {'c', 'd'}}, "aba"));
    }

    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    // DFS
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 || board[i][j] != word.charAt(index) || visited[i][j]) return false;
        visited[i][j] = true;
        boolean flag = dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i + 1, j, index + 1)
                ||     dfs(board, word, i, j - 1, index + 1) || dfs(board, word, i , j + 1, index + 1);
        visited[i][j] = false;
        return flag;
    }
}
