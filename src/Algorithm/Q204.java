package Algorithm;

import java.util.Arrays;

public class Q204 {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        int sqrt = (int) Math.sqrt(n);
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, 2, n, true);
        for (int i = 2; i <= sqrt; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) res++;
        }
        return res;
    }
}
