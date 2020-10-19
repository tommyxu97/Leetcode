package BaiduTest1012;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), k = scanner.nextInt();
        int[] stations = new int[m];
        for (int i = 0; i < m; i++) {
            stations[i] = scanner.nextInt();
        }
        int distance = scanner.nextInt();
        int temp = 0, index = 0;
        while (temp < distance) {
            if (temp + k >= distance) {
                System.out.println(n);
                return;
            }
            List<Integer> stationsInRange = new ArrayList<>();
            while (index < m && stations[index] > temp && stations[index] <= temp + k) {
                stationsInRange.add(stations[index]);
                index++;
            }
            if (stationsInRange.size() == 0) {
                System.out.println("No"); return;
            }
            temp = stationsInRange.get(stationsInRange.size() - 1);
            n--;
        }
        System.out.println(n);
    }
}
