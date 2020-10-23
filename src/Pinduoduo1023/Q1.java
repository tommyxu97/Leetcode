package Pinduoduo1023;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        Arrays.sort(prices);
        if (prices[n - 1] - prices[0] > 2 * m) {
            System.out.println(-1); return;
        }
        System.out.println((prices[n - 1] - m) + " " + (prices[0] + m));
    }
}
