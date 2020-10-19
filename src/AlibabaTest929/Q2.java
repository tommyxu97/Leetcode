package AlibabaTest929;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), q = scanner.nextInt();
        List<String> dict = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dict.add(scanner.next());
        }
        for (int i = 0; i < q; i++) {
            String query = scanner.next();
            if (query.equals("")) {
                System.out.println(0);
                continue;
            }
            int[] count = new int[query.length()];
            int[] min = new int[query.length()];
            Arrays.fill(min, Integer.MAX_VALUE);
            for (String word: dict) {
                for (int j = 1; j <= query.length(); j++) {
                    if (word.length() > query.length()) continue;
                    if (word.substring(0, j).equals(query.substring(0, j))) count[j - 1]++;
                }
            }
            for (String word: dict) {
                for (int j = 1; j <= query.length(); j++) {
                    if (word.length() > query.length()) continue;
                    if (word.substring(0, j).equals(query.substring(0, j))) {
                        min[j - 1] = j + count[j - 1];
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for (int index = 0; index < query.length(); index++) {
                res = Math.min(res, min[index]);
            }
            System.out.println(res);
        }
    }
}
