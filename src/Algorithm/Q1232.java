package Algorithm;

public class Q1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 3) return true;
        double flag = 0;
        boolean isHorizontal = false, isVertical = false;
        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];
        if (point1[0] == point2[0]) {
            isVertical = true; flag = point1[0];
        } else if (point1[1] == point2[1]) {
            isHorizontal = true; flag = point1[1];
        } else {
            flag = (double) (point2[1] - point1[1]) / (point2[0] - point1[0]);
        }
        for (int i = 2; i < coordinates.length; i++) {
            int[] point = coordinates[i];
            if (isHorizontal) {
                if (point[1] != flag) return false;
            } else if (isVertical) {
                if (point[0] != flag) return false;
            } else {
                if ((double) (point[1] - point1[1]) / (point[0] - point1[0]) != flag) return false;
            }
        }
        return true;
    }

    public boolean checkStraightLine2(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 3) return true;
        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];
        for (int i = 2; i < coordinates.length; i++) {
            int[] point3 = coordinates[i];
            if ((point2[1] - point1[1]) * (point3[0] - point1[0]) !=
                    (point3[1] - point1[1]) * (point2[0] - point1[0]))
                return false;
        }
        return true;
    }
}
