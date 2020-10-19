package BaiduTest1012;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        if (m == 0 || n == 0) {
            System.out.println(0);
            return;
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String temp = scanner.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp.charAt(j) == 'M'? 1: 0;
            }
        }
        int res = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            res = Math.max(dp[i][0], res);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
            res = Math.max(dp[0][j], res);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        System.out.println(res * res);
    }
}
