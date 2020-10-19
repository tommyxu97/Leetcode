package GoogleKickStart.RoundG2020;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        for (int num = 1; num <= nums; num++) {
            int row = scanner.nextInt();
            int[][] matrix = new int[row][row];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            // 需要用long类型
            long max = 0;
            for (int i = 0; i < row; i++) {
                long tempCoin = 0;
                int tempRow = i, tempCol = 0;
                while (tempRow < row && tempCol < row) {
                    tempCoin += matrix[tempRow][tempCol];
                    tempRow ++; tempCol++;
                }
                max = Math.max(max, tempCoin);
            }
            for (int i = 0; i < row; i++) {
                long tempCoin = 0;
                int tempRow = 0, tempCol = i;
                while (tempRow < row && tempCol < row) {
                    tempCoin += matrix[tempRow][tempCol];
                    tempRow ++; tempCol++;
                }
                max = Math.max(max, tempCoin);
            }
            System.out.println("Case #" + num + ": " + max);
        }
    }
}
