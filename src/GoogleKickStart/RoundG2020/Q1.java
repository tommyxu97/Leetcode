package GoogleKickStart.RoundG2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            String str = scanner.next();
            List<Integer> kick = new ArrayList<>();
            List<Integer> start = new ArrayList<>();
            int index = 0;
            while ((index = str.indexOf("KICK", index)) != -1) {
                kick.add(index); index += 3; // 不是4因为KICK最后面有个K会重叠
            }
            index = 0;
            while ((index = str.indexOf("START", index)) != -1) {
                start.add(index); index += 5;
            }
            index = 0;
            int res = 0;
            for (int kickIndex: kick) {
                if (index == start.size()) break;
                while (index < start.size() && start.get(index) < kickIndex) index++;
                res += start.size() - index;
            }
            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }
}
