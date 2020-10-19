package GoogleKickStart.RoundG2020;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        for (int num = 1; num <= nums; num++) {
            int count = scanner.nextInt(), N = scanner.nextInt();
            int[] array = new int[count];
            for (int temp = 0; temp < count; temp++) {
                array[temp] = scanner.nextInt();
            }
            // 暴力遍历
            long res = Long.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                long tempRes = 0;
                for (int temp: array) {
                    tempRes += Math.min(Math.abs(temp - i), Math.min(N - temp + i, N + temp - i));
                }
                res = Math.min(res, tempRes);
            }
            System.out.println("Case #" + num + ": " + res);
        }
    }
}