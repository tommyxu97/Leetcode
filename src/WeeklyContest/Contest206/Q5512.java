package WeeklyContest.Contest206;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q5512 {

    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        int res = new Q5512().unhappyFriends(4, new int[][] {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}}, new int[][]
                {{0, 1}, {2, 3}});
        System.out.println(res);
        System.out.println(list);
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
             for (int j = 0; j < 2; j++) {
                int person = pairs[i][j];
                int friend = j == 0? pairs[i][1]: pairs[i][0];
                int curPref1 = gerPreferenceIndex(friend, preferences[person]);
                for (int m = 0; m < pairs.length; m++) {
                    if (m == i) continue;
                    for (n = 0; n < 2; n++) {
                        int person2 = pairs[m][n];
                        int friend2 = n == 0? pairs[m][1]: pairs[m][0];
                        int curPref2 = gerPreferenceIndex(friend2, preferences[person2]);
                        int pref1 = gerPreferenceIndex(person2, preferences[person]);
                        int pref2 = gerPreferenceIndex(person, preferences[person2]);
                        if (pref1 < curPref1 && pref2 < curPref2) res.add(person);
                    }
                }
            }
        }
        return res.size();
    }

    public int gerPreferenceIndex(int friend, int[] preferences) {
        for (int i = 0; i < preferences.length; i++) {
            if (preferences[i] == friend) return i;
        }
        return -1;
    }
}
