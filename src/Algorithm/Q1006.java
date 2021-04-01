package Algorithm;

public class Q1006 {
    public int clumsy(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 6;
        int res = N * (N - 1) / (N - 2) + (N - 3);
        N -= 4;
        while (N > 3) {
            res += - N * (N - 1) / (N - 2) + (N - 3);
            N -= 4;
        }
        return res - clumsy(N);
    }
}
