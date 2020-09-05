package BiWeeklyContest;

public class Q5491_BiWeeklyContest34 {

    // https://leetcode-cn.com/contest/biweekly-contest-34/
    // https://leetcode-cn.com/problems/matrix-diagonal-sum/

    public int diagonalSum(int[][] mat) {
        if (mat.length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            sum += mat[mat.length - 1 - i][i];
        }
        if (mat.length % 2 == 1) sum -= mat[mat.length/2][mat.length/2];
        return sum;
    }
}
