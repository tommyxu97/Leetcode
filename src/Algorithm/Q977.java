package Algorithm;

import java.util.Arrays;

public class Q977 {
    public int[] sortedSquares(int[] A) {
        // 尝试stream方法
        A = Arrays.stream(A).map(i -> i * i).toArray();
        Arrays.sort(A);
        return A;
    }
}
