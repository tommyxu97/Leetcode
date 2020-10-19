package AlibabaTest929;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String str = scanner.next();
        int start = 0, end = len - 1;
        for (int i = 0; i <= len; i++) {
            if (i == len) {
                System.out.println(0);
                return;
            }
            if (str.charAt(i) != '1') {
                start = i;
                break;
            }
        }
        for (int i = len - 1; i >= 0 ; i--) {
            if (str.charAt(i) != '1') {
                end = i;
                break;
            }
        }
        str = str.substring(start, end + 1);
        String[] ones = str.split("0+");
        long sum = 1;
        for (String temp: ones) {
            if (temp.equals("")) continue;
            sum = sum * (temp.length() + 1) % 1000000007;
        }
        System.out.println(sum);
    }
}
