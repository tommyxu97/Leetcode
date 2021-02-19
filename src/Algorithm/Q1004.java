package Algorithm;

public class Q1004 {
    public int longestOnes(int[] A, int K) {
        int len = A.length;
        int left = 0, right = 0, count = 0;
        int res = 0;
        while (right < len) {
            if (A[right] == 0) {
                count++;
            }
            while (count > K) {
                if (A[left] == 0) {
                    count--;
                }
                left++;
            }
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }
}
