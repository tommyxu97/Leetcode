package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Q649 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + senate.length());
            } else {
                dire.offer(direIndex + senate.length());
            }
        }
        return !radiant.isEmpty()? "Radiant": "Dire";
    }
}
