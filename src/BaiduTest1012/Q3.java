package BaiduTest1012;

import java.util.HashMap;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Node dummy = new Node(0);
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();

        }
    }

    static class Node {
        int key;
        Node bigger;
        Node smaller;
        Node same;
        Node(int k) {
            key = k;
        }
    }
}
