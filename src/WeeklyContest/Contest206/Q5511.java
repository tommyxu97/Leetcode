package WeeklyContest.Contest206;

public class Q5511 {

    public int numSpecial(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (isUnique(i, j, mat)) res++;
                }
            }
        }
        return res;
    }

    public boolean isUnique(int i, int j, int[][] mat) {
        for (int m = 0; m < mat.length; m++) {
            if (m == i) continue;
            if (mat[m][j] == 1) return false;
        }
        for (int n = 0; n < mat[0].length; n++) {
            if (n == j) continue;
            if (mat[i][n] == 1) return false;
        }
        return true;
    }
}
