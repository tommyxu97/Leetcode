package MeituanTest927;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String str = scanner.next();
        if (len == 0) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[len];
        dp[0] = str.charAt(0) == 'E'? 1: -1;
        for (int i = 1; i < len; i++) {
            int temp = str.charAt(i) == 'E'? 1: -1;
            dp[i] = Math.max(temp, dp[i - 1] + temp);
        }
        int max = 0;
        for (int i: dp) {
            max = Math.max(i, max);
        }
        System.out.println(max);
    }
}
