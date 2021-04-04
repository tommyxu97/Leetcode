package Algorithm;

import java.util.HashMap;

public class Q781 {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int answer: answers) {
            if (map.containsKey(answer) && map.get(answer) > 0) {
                map.put(answer, map.get(answer) - 1);
            } else {
                res += answer + 1;
                map.put(answer, answer);
            }
        }
        return res;
    }
}
