package Algorithm;

public class Q992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    private int atMostKDistinct(int[] A, int K) {
        int[] freq = new int[A.length + 1];
        int count = 0;
        int res = 0;
        int len = A.length;
        int left = 0, right = 0;
        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;
            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}
