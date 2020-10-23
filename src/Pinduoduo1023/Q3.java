package Pinduoduo1023;

import java.util.Scanner;

public class Q3 {
    // WA
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int temp1 = (int) (Math.pow(2, m) - 1), temp2 = (int) (Math.pow(2, m) - 1), temp3 = (int) (Math.pow(2, m) - 1);
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            if (line[0].equals("&")) {
                temp1 = temp1 & Integer.parseInt(line[1]);
            } else if (line[0].equals("|")) {
                temp2 = temp2 | Integer.parseInt(line[1]);
            } else if (line[0].equals("^")) {
                temp3 = temp3 ^ Integer.parseInt(line[1]);
            }
        }
        System.out.println(3);
        System.out.println("&" + " " + temp1);
        System.out.println("|" + " " + temp2);
        System.out.println("^" + " " + temp3);
    }
}
