package MeituanTest927;

import java.util.*;

public class Q4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int actions = scanner.nextInt();
        label: for (int i = 0; i < actions; i++) {
            int count = scanner.nextInt();
            Deque<Integer> deque = new LinkedList<>();
            int start = 1;
            for (int j = 0; j < count; j++) {
                int temp = scanner.nextInt();
                if (temp >= start) {
                    while (temp >= start) {
                        deque.addLast(start);
                        start++;
                    }
                }
                if (deque.size() == 0) {
                    continue;
                }
                if (deque.peekFirst() == temp) deque.removeFirst();
                else if (deque.pollLast() == temp) deque.removeLast();
                else {
                    System.out.println("No");
                    break label;
                }
            }
            System.out.println("Yes");
        }
    }
}
