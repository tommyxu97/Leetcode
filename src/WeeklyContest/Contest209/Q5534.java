package WeeklyContest.Contest209;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q5534 {
    public static void main(String[] args) {
        Q5534 q5534 = new Q5534();
        List<List<Integer>> points = new ArrayList<>();
        List<Integer> point1 = new ArrayList<>();
        point1.add(1); point1.add(0);
        List<Integer> point2 = new ArrayList<>();
        point2.add(2); point2.add(1);
        points.add(point1); points.add(point2);
        int angle = 13;
        List<Integer> location = new ArrayList<>();
        location.add(1); location.add(1);
        System.out.println(q5534.visiblePoints(points, angle, location));
    }

    // TODO: Error solution
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>(points.size());
        int res = 0;
        for (List<Integer> point: points) {
            double temp = Math.atan2(point.get(1) - location.get(1), point.get(0) - location.get(0)) * (180 / Math.PI);
            angles.add(temp < 0? temp + 360: temp);
        }
        Collections.sort(angles);
        int start = 0, end = 0;
        for (int i = 0; i < angles.size(); i++) {
            if (angles.get(i) < angles.get(start) + angle) {
                res++; end = i;
            }
            else break;
        }
        int more = end;
        while (end < angles.size() + more) {
            end++; res++;
            while (angles.get(start) < angles.get(end >= angles.size()? end - angles.size(): end) - angle) {
                res--;
                start++;
            }
        }
        return res;
    }
}
